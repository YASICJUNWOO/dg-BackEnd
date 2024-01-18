package com.example.dgbackend.domain.recipe.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeResponse {

    @NotNull
    private String name;

    @NotNull
    private String info;

    @NotNull
    private String cookingTime;

    @NotNull
    private String calorie;

    @NotNull
    private Long likeCount;

    @NotNull
    private Long commentCount;

    @NotNull
    private String ingredient;

    @NotNull
    private String recipeInstruction;

    private String recommendCombination; //추천받은 조합

    private boolean state = true; //true : 존재, false : 삭제

    private String memberName;

}
