package com.mezzat.recipeapp.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount", precision = 21, scale = 2)
    private BigDecimal amount;

    @ManyToOne
    @JsonIgnoreProperties(value = {"ingredients", "note", "categories"}, allowSetters = true)
    private Recipe recipe;

    @OneToOne
    @JoinColumn(unique = true)
    private UnitOfMeasure unitOfMeasure;

    public Ingredient description(String description) {
        this.description = description;
        return this;
    }

    public Ingredient amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Ingredient recipe(Recipe recipe) {
        this.recipe = recipe;
        return this;
    }

    public Ingredient unitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ingredient)) {
            return false;
        }
        return id != null && id.equals(((Ingredient) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + getId() +
                ", description='" + getDescription() + "'" +
                ", amount=" + getAmount() +
                "}";
    }
}
