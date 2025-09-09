package com.wipro.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class CartItemDetailDTO {
    private Integer itemId;
    private Integer productId;
    private Integer qty;
    private ProductDTO1 product;   // embedded product
    private Double lineTotal;     // price * qty
}