package com.example.dgbackend.domain.recipeimage.service;

import com.example.dgbackend.domain.recipe.Recipe;
import com.example.dgbackend.domain.recipe.dto.RecipeResponse;
import com.example.dgbackend.domain.recipe.service.RecipeService;
import com.example.dgbackend.domain.recipeimage.RecipeImage;
import com.example.dgbackend.domain.recipeimage.dto.RecipeImageRequest;
import com.example.dgbackend.domain.recipeimage.dto.RecipeImageResponse;
import com.example.dgbackend.domain.recipeimage.dto.RecipeImageVO;
import com.example.dgbackend.domain.recipeimage.repository.RecipeImageRepository;
import com.example.dgbackend.global.common.response.code.status.ErrorStatus;
import com.example.dgbackend.global.exception.ApiException;
import com.example.dgbackend.global.s3.S3Service;
import com.example.dgbackend.global.s3.dto.S3Result;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    //파일 없을 시 예외처리
    private List<MultipartFile> validFileList(List<MultipartFile> request) {

        if (request == null || request.isEmpty()) {
            throw new ApiException(ErrorStatus._NOTHING_RECIPE_IMAGE);
        }

        return request;
    }

}
