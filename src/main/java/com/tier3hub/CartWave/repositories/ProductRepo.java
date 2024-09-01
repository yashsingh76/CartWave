package com.tier3hub.CartWave.repositories;

import com.tier3hub.CartWave.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {


}
