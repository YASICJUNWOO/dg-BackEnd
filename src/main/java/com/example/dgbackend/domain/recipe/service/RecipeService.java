package com.example.dgbackend.domain.recipe.service;

import com.example.dgbackend.domain.recipe.Recipe;
import com.example.dgbackend.domain.recipe.converter.RecipeConverter;
import com.example.dgbackend.domain.recipe.dto.RecipeParamVO;
import com.example.dgbackend.domain.recipe.dto.RecipeResponseDTO;
import com.example.dgbackend.domain.recipe.repository.RecipeRepository;
import com.example.dgbackend.global.common.response.code.status.ErrorStatus;
import com.example.dgbackend.global.exception.ApiException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Transactional
    public List<RecipeResponseDTO> getExistRecipes() {
        return recipeRepository.findAllByState(true).stream()
                .map(RecipeConverter::toResponse)
                .toList();
    }

    //레시피 이름과 회원 이름으로 레시피 탐색
    @Transactional
    public Recipe getRecipe(RecipeParamVO recipeParamVO) {

        Recipe recipe = recipeRepository.findByNameAndMember_Name(recipeParamVO.getName(), recipeParamVO.getMemberName())
                .orElseThrow(() -> new ApiException(ErrorStatus._EMPTY_RECIPE));

        return isDelete(recipe);
    }

    //레시피가 삭제된 경우 예외처리
    @Transactional
    public Recipe isDelete(Recipe recipe) {

        if (!recipe.isState()) throw new ApiException(ErrorStatus._DELETE_RECIPE);

        return recipe;
    }

}
