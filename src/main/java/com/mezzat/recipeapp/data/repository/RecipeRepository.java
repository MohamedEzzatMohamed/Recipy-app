package com.mezzat.recipeapp.data.repository;

import com.mezzat.recipeapp.domain.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
