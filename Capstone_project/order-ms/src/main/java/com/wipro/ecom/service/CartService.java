package com.wipro.ecom.service;

import com.wipro.ecom.dto.CartDetailDTO;
import com.wipro.ecom.dto.CartRequestDTO;
import com.wipro.ecom.entity.Cart;

public interface CartService {

    Cart addProduct(CartRequestDTO dto);
    void deleteItem(int itemId);
    Cart updateProduct(CartRequestDTO dto);
    Cart viewCart(int userId);
    
    CartDetailDTO viewCartDetail(int userId);
}