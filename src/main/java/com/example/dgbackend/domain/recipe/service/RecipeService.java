package com.example.dgbackend.domain.recipe.service;

import com.example.dgbackend.domain.recipe.converter.RecipeConverter;
import com.example.dgbackend.domain.recipe.dto.RecipeResponseDTO;
import com.example.dgbackend.domain.recipe.repository.RecipeRepository;
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

}
