package com.mezzat.recipeapp.data.repository;

import com.mezzat.recipeapp.domain.entities.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Long> {
}
