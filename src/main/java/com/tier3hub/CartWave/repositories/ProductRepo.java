package com.tier3hub.CartWave.repositories;

import com.tier3hub.CartWave.entities.Category;
import com.tier3hub.CartWave.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    Page<Product> findByName(String keyword, Pageable page);

    Page<Product> findByCategory(Category category, Pageable page);
}
