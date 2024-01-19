package com.example.dgbackend.domain.recipecomment.service;

import com.example.dgbackend.domain.recipecomment.RecipeComment;

public interface RecipeCommentService {

    RecipeComment getParentEntityById(Long id);

    RecipeComment getEntityById(Long id);

}
