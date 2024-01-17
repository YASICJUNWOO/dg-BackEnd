package com.example.dgbackend.domain.recipe.controller;

import com.example.dgbackend.domain.recipe.dto.RecipeResponseDTO;
import com.example.dgbackend.domain.recipe.service.RecipeService;
import com.example.dgbackend.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public ApiResponse<List<RecipeResponseDTO>> getRecipes() {
        return ApiResponse.onSuccess(recipeService.getExistRecipes());
    }

}
