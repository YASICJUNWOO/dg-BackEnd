package com.example.dgbackend.domain.recipe.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequest {

    @NotNull
    private String name;

    @NotNull
    private String info;

    @NotNull
    private String cookingTime;

    @NotNull
    private String calorie;

    @NotNull
    private String ingredient;

    @NotNull
    private String recipeInstruction;

    private String recommendCombination;

}
