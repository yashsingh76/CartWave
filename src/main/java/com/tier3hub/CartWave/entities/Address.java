package com.tier3hub.CartWave.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String addressLine1;

    private String addressLine2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalcode;

    @Column(name = "created_At",columnDefinition = "DATE")
    private LocalDateTime createdAt;

    @Column(name = "updated_At",columnDefinition = "DATE")
    private LocalDateTime updatedAt;
}
