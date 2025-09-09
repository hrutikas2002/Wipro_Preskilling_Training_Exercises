package com.wipro.ecom.controller;

import com.wipro.ecom.dto.CartDetailDTO;
import com.wipro.ecom.dto.CartRequestDTO;
import com.wipro.ecom.entity.Cart;
import com.wipro.ecom.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

	private final CartService cartService;

	// Helpers to read UID from Authentication and role checks
	private int uid(Authentication auth) {
		try { return Integer.parseInt(auth.getName()); }
		catch (Exception e) { throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token"); }
	}
	private boolean isAdmin(Authentication auth) {
		return auth.getAuthorities().stream().anyMatch(a -> "ROLE_ADMIN".equals(a.getAuthority()));
	}

	// ✅ Token-driven "my cart" endpoint
	@GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDetailDTO> myCart(Authentication auth) {
        return ResponseEntity.ok(cartService.viewCartDetail(uid(auth)));
    }

	@PostMapping(value = "/addProd",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> addProduct(@RequestBody CartRequestDTO dto, Authentication auth) {
		// Derive/validate userId from JWT for non-admins
		int me = uid(auth);
		if (!isAdmin(auth)) dto.setUserId(me);
		else if (dto.getUserId() == 0) dto.setUserId(me);
		return ResponseEntity.ok(cartService.addProduct(dto));
	}

	@PutMapping(value = "/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> updateCart(@RequestBody CartRequestDTO dto, Authentication auth) {
		int me = uid(auth);
		if (!isAdmin(auth)) dto.setUserId(me);
		else if (dto.getUserId() == 0) dto.setUserId(me);
		return ResponseEntity.ok(cartService.updateProduct(dto));
	}

	// Delete by item id (no userId needed)
	@DeleteMapping("/deleteProd/{itemid}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("itemid") int itemId) {
		cartService.deleteItem(itemId);
		return ResponseEntity.noContent().build();
	}

	// (Optional legacy) keep only if old UI still calls /cart/{userId}
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> viewCartFor(@PathVariable int userId, Authentication auth) {
		int me = uid(auth);
		if (!isAdmin(auth) && me != userId) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden");
		return ResponseEntity.ok(cartService.viewCart(userId));
	}
}
