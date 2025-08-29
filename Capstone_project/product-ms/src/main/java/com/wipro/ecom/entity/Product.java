package com.wipro.ecom.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="product_name")
    private String prodName;
    @Column(name="product_description")
    private String prodDesc;
    @Column(name="category")
    private String prodCat; // electronics, apparel, kitchen, books, etc
    @Column(name="make")
    private String make;
    @Column(name="available_quantity")
    private int availableQty;
    @Column(name="price")
    private Double price;
    @Column(name="unit_of_measurement")
    private String uom; // litre, kg, piece
    @Column(name="rating")
    private double prodRating;
    @Column(name="image_source")
    private String imageURL;
    @Column(name="date_of_manufacture")
    private LocalDate dateOfManufacture;
}
