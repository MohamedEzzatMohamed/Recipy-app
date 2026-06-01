package com.mezzat.recipeapp.data.repository;

import com.mezzat.recipeapp.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
