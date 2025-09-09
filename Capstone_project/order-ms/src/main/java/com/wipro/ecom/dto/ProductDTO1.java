package com.wipro.ecom.dto;

import lombok.Data;

@Data
public class ProductDTO1 {
	private Integer id;
    private String prodName;
    private String prodDesc;
    private String prodCat;
    private String make;
    private Integer availableQty;
    private Double price;
    private String uom;
    private Double prodRating;
    private String imageURL;
    private String dateOfManufacture;
}
