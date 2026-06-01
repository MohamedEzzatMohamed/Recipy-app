package com.mezzat.recipeapp.data.repository;

import com.mezzat.recipeapp.domain.entities.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Long> {
}
