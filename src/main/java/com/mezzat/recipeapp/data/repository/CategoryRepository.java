package com.mezzat.recipeapp.data.repository;

import com.mezzat.recipeapp.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
