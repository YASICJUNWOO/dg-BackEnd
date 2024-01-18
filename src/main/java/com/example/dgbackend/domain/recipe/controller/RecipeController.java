package com.example.dgbackend.domain.recipe.controller;

import com.example.dgbackend.domain.enums.Gender;
import com.example.dgbackend.domain.enums.SocialType;
import com.example.dgbackend.domain.member.Member;
import com.example.dgbackend.domain.member.MemberRepository;
import com.example.dgbackend.domain.recipe.dto.RecipeParamVO;
import com.example.dgbackend.domain.recipe.dto.RecipeRequestDTO;
import com.example.dgbackend.domain.recipe.dto.RecipeResponseDTO;
import com.example.dgbackend.domain.recipe.service.RecipeService;
import com.example.dgbackend.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/detail")
    public ApiResponse<RecipeResponseDTO> getRecipe(@RequestParam String name, @RequestParam String member) {
        return ApiResponse.onSuccess(recipeService.getRecipeDetail(RecipeParamVO.of(name, member)));
    }

}
