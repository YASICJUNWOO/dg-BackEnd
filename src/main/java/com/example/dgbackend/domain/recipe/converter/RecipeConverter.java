package com.example.dgbackend.domain.recipe.converter;

import com.example.dgbackend.domain.member.Member;
import com.example.dgbackend.domain.recipe.Recipe;
import com.example.dgbackend.domain.recipe.dto.RecipeRequestDTO;
import com.example.dgbackend.domain.recipe.dto.RecipeResponseDTO;

public class RecipeConverter {

    public static RecipeResponseDTO toResponse(Recipe recipe) {
        return RecipeResponseDTO.builder()
                .name(recipe.getName())
                .info(recipe.getInfo())
                .cookingTime(recipe.getCookingTime())
                .calorie(recipe.getCalorie())
                .likeCount(recipe.getLikeCount())
                .commentCount(recipe.getCommentCount())
                .ingredient(recipe.getIngredient())
                .recipeInstruction(recipe.getRecipeInstruction())
                .recommendCombination(recipe.getRecommendCombination())
                .state(recipe.isState())
                .memberName(recipe.getMember().getName())
                .build();
    }

    public static Recipe toEntity(RecipeRequestDTO recipeRequestDto, Member member) {
        return Recipe.builder()
                .name(recipeRequestDto.getName())
                .info(recipeRequestDto.getInfo())
                .cookingTime(recipeRequestDto.getCookingTime())
                .calorie(recipeRequestDto.getCalorie())
                .likeCount(0L)
                .commentCount(0L)
                .ingredient(recipeRequestDto.getIngredient())
                .recipeInstruction(recipeRequestDto.getRecipeInstruction())
                .recommendCombination(recipeRequestDto.getRecommendCombination())
                .member(member)
                .build();
    }

}
