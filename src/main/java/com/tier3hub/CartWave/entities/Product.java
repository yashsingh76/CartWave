package com.tier3hub.CartWave.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false,length = 100)
    private String name;

    @Column(name = "description", nullable = false,length = 500)
    private String description;

    @Column(name = "image",columnDefinition = "LONGBLOB")
    private String image;

    @Column(name = "special_price")
    private double specialPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "status")
    private boolean status;

    @Column(name = "created_at",columnDefinition = "DATE")
    private LocalDate createdAt;

    @Column(name = "updated_at",columnDefinition = "DATE")
    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


}
