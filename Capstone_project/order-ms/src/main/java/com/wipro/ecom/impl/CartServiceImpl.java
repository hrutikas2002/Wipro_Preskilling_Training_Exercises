package com.wipro.ecom.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ecom.clients.ProductClient;
import com.wipro.ecom.dto.CartDetailDTO;
import com.wipro.ecom.dto.CartItemDetailDTO;
import com.wipro.ecom.dto.CartRequestDTO;
import com.wipro.ecom.dto.ProductDTO1;
import com.wipro.ecom.entity.Cart;
import com.wipro.ecom.entity.CartItem;
import com.wipro.ecom.repository.CartItemRepository;
import com.wipro.ecom.repository.CartRepository;
import com.wipro.ecom.service.CartService;

import lombok.var;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepo;
    private final CartItemRepository itemRepo;
    private final ProductClient productClient; // keep if you want to compute totals elsewhere

    public CartServiceImpl(CartRepository cartRepo, CartItemRepository itemRepo, ProductClient productClient) {
        this.cartRepo = cartRepo;
        this.itemRepo = itemRepo;
        this.productClient = productClient;
    }

    @Override
    @Transactional
    public Cart addProduct(CartRequestDTO dto) {
        // get or create cart for user
        Cart cart = cartRepo.findByUserId(dto.getUserId()).orElseGet(() -> {
            Cart c = new Cart();
            c.setUserId(dto.getUserId());
            return cartRepo.save(c);
        });

        // if product already in cart, bump qty; else add new line
        Optional<CartItem> existing = cart.getItems().stream()
            .filter(i -> i.getProductId().equals(dto.getProductId()))
            .findFirst();

        if (existing.isPresent()) {
            CartItem it = existing.get();
            it.setQty(it.getQty() + dto.getQuantity());
            itemRepo.save(it);
        } else {
            CartItem it = new CartItem();
            it.setCart(cart);
            it.setProductId(dto.getProductId());
            it.setQty(dto.getQuantity());
            itemRepo.save(it);
            cart.getItems().add(it);
        }
        return cartRepo.save(cart);
    }

    @Override
    @Transactional
    public void deleteItem(int itemId) {
        // delete by item id (spec requires /cart/deleteProd/{itemid})
        itemRepo.deleteById(itemId);
    }

    @Override
    @Transactional
    public Cart updateProduct(CartRequestDTO dto) {
        Cart cart = cartRepo.findByUserId(dto.getUserId()).orElseThrow();

        CartItem it = cart.getItems().stream()
            .filter(i -> i.getProductId().equals(dto.getProductId()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Item not in cart"));

        it.setQty(dto.getQuantity());
        itemRepo.save(it);
        return cart;
    }

    @Override
    @Transactional(readOnly = true)
    public Cart viewCart(int userId) {
        // Return empty cart object (with no items) for first-time users
        return cartRepo.findByUserId(userId).orElseGet(() -> {
            Cart c = new Cart();
            c.setUserId(userId);
            return c;
        });
    }
    
    @Override
    @Transactional(readOnly = true)
    public CartDetailDTO viewCartDetail(int userId) {
        Cart cart = cartRepo.findByUserId(userId).orElseGet(() -> {
            Cart c = new Cart(); c.setUserId(userId); return c;
        });

        var items = new ArrayList<CartItemDetailDTO>();
        int totalQty = 0;
        double subtotal = 0.0;

        if (cart.getItems() != null) {
            for (CartItem it : cart.getItems()) {
                ProductDTO1 product = null;
                try { product = productClient.getProduct(it.getProductId()); } catch (Exception ignored) {}
                double price = (product != null && product.getPrice() != null) ? product.getPrice() : 0.0;
                double line = price * it.getQty();

                items.add(new CartItemDetailDTO(
                    it.getId(),
                    it.getProductId(),
                    it.getQty(),
                    product,
                    line
                ));
                totalQty += it.getQty();
                subtotal += line;
            }
        }

        return new CartDetailDTO(cart.getId(), cart.getUserId(), items, totalQty, subtotal);
    }
}
