package com.example.dgbackend.domain.recipeimage.repository;

import com.example.dgbackend.domain.recipeimage.RecipeImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeImageRepository extends JpaRepository<RecipeImage, Long> {
    List<RecipeImage> findAllByRecipeId(Long recipeId);
}
