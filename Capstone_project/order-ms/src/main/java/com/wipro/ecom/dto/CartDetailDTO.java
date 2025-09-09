package com.wipro.ecom.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class CartDetailDTO {
    private Integer id;
    private Integer userId;
    private List<CartItemDetailDTO> items;
    private Integer totalQty;
    private Double subtotal;
}
