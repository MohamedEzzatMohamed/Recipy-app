package com.mezzat.recipeapp.domain.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "unit_of_measure")
public class UnitOfMeasure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToOne
    private Ingredient ingredient;

    public Long getId() {
        return id;
    }

    public String setDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
