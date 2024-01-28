package com.example.dgbackend.domain.recipeimage.controller;

import com.example.dgbackend.domain.recipeimage.service.RecipeImageService;
import com.example.dgbackend.global.common.response.ApiResponse;
import com.example.dgbackend.global.s3.S3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "레시피 이미지 API", description = "레시피 이미지 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe-images")
public class RecipeImageController {

    private final S3Service s3Service;
    private final RecipeImageService recipeImageService;

    @Operation(summary = "레시피 이미지 조회", description = "레시피 이미지 조회")
    @Parameter(name = "recipeId", description = "레시피 id", required = true)
    @GetMapping
    public ApiResponse<List<String>> getRecipeImages(@RequestParam("recipeId") Long recipeId) {
        return ApiResponse.onSuccess(recipeImageService.getRecipeImages(recipeId));
    }

}
