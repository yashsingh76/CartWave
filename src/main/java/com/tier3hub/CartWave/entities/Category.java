package com.tier3hub.CartWave.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false,length = 100)
    private String name;

    @Column(name = "description", nullable = false,length = 500)
    private String description;

    @Column(name = "image",columnDefinition = "LONGBLOB")
    private String image;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "created_at",columnDefinition = "DATE")
    private LocalDate createdAt;

    @Column(name = "updated_at",columnDefinition = "DATE")
    private LocalDate updatedAt;
}
