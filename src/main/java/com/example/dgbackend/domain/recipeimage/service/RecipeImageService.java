package com.example.dgbackend.domain.recipeimage.service;

import com.example.dgbackend.domain.recipe.service.RecipeService;
import com.example.dgbackend.domain.recipeimage.RecipeImage;
import com.example.dgbackend.domain.recipeimage.repository.RecipeImageRepository;
import com.example.dgbackend.global.s3.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RecipeImageService {

    private final RecipeImageRepository recipeImageRepository;
    private final RecipeService recipeService;

    private final S3Service s3Service;

    public List<String> getRecipeImages(Long recipeId) {
        return recipeImageRepository.findAllByRecipeId(recipeId).stream()
                .map(RecipeImage::getImageUrl)
                .toList();
    }

}
