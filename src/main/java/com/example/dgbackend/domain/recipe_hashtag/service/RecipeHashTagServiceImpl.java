package com.example.dgbackend.domain.recipe_hashtag.service;

import com.example.dgbackend.domain.recipe_hashtag.repository.RecipeHashTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeHashTagServiceImpl implements RecipeHashTagService{

    private final RecipeHashTagRepository recipeHashTagRepository;

}
