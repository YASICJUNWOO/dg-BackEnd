package com.example.dgbackend.domain.recipe.service;

import com.example.dgbackend.domain.member.Member;
import com.example.dgbackend.domain.recipe.Recipe;
import com.example.dgbackend.domain.recipe.dto.RecipeParamVO;
import com.example.dgbackend.domain.recipe.dto.RecipeRequest;
import com.example.dgbackend.domain.recipe.dto.RecipeResponse;

import java.util.List;

public interface RecipeService {

    List<RecipeResponse> getExistRecipes();

    RecipeResponse getRecipeDetail(RecipeParamVO recipeParamVO);

    RecipeResponse createRecipe(RecipeRequest recipeRequest, Member member);

    RecipeResponse updateRecipe(RecipeParamVO recipeParamVO, RecipeRequest recipeRequest);

    void deleteRecipe(RecipeParamVO recipeParamVO);

    //레시피 이름과 회원 이름으로 레시피 탐색
    Recipe getRecipe(RecipeParamVO recipeParamVO);

    //레시피가 삭제된 경우 예외처리
    Recipe isDelete(Recipe recipe);

    void isAlreadyCreate(String RecipeName, String memberName);

}
