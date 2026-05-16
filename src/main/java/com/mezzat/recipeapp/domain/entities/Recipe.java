package com.mezzat.recipeapp.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "recipe")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Recipe implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "description")
    private String description;

    @Column(name = "prep_time")
    private Integer prepTime;

    @Column(name = "cook_time")
    private Integer cookTime;

    @Column(name = "servings")
    private Integer servings;

    @Column(name = "source")
    private String source;

    @Column(name = "url")
    private String url;

    @Lob
    @Column(name = "directions")
    private String directions;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Lob
    @Column(name = "images")
    private Byte[] images;

    @OneToMany(mappedBy = "recipe")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = {"recipe", "unitOfMeasure"}, allowSetters = true)
    private Set<Ingredient> ingredients = new HashSet<>();

    @OneToOne
    @JoinColumn(unique = true)
    private Notes note;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    @JsonIgnoreProperties(value = {"recipies"}, allowSetters = true)
    private Set<Category> categories = new HashSet<>();

    public Recipe recipeName(String recipeName) {
        this.recipeName = recipeName;
        return this;
    }

    public Recipe description(String description) {
        this.description = description;
        return this;
    }

    public Recipe prepTime(Integer prepTime) {
        this.prepTime = prepTime;
        return this;
    }

    public Recipe cookTime(Integer cookTime) {
        this.cookTime = cookTime;
        return this;
    }

    public Recipe servings(Integer servings) {
        this.servings = servings;
        return this;
    }

    public Recipe source(String source) {
        this.source = source;
        return this;
    }

    public Recipe url(String url) {
        this.url = url;
        return this;
    }

    public Recipe directions(String directions) {
        this.directions = directions;
        return this;
    }

    public Recipe difficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public Recipe images(Byte[] images) {
        this.images = images;
        return this;
    }

    public Recipe ingredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public Recipe addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.setRecipe(this);
        return this;
    }

    public Recipe removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
        ingredient.setRecipe(null);
        return this;
    }

    public Recipe note(Notes notes) {
        this.note = notes;
        return this;
    }

    public Recipe categories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Recipe addCategory(Category category) {
        this.categories.add(category);
        category.getRecipes().add(this);
        return this;
    }

    public Recipe removeCategory(Category category) {
        this.categories.remove(category);
        category.getRecipes().remove(this);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Recipe)) {
            return false;
        }
        return id != null && id.equals(((Recipe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Recipy{" +
                "id=" + getId() +
                ", recipeName='" + getRecipeName() + "'" +
                ", description='" + getDescription() + "'" +
                ", prepTime=" + getPrepTime() +
                ", cookTime=" + getCookTime() +
                ", servings=" + getServings() +
                ", source='" + getSource() + "'" +
                ", url='" + getUrl() + "'" +
                ", directions='" + getDirections() + "'" +
                ", difficulty='" + getDifficulty() + "'" +
                ", images='" + getImages() + "'" +
                "}";
    }
}
