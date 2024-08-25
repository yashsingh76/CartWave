package com.tier3hub.CartWave.repositories;

import com.tier3hub.CartWave.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
