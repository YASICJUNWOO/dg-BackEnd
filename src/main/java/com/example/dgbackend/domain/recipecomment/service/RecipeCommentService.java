package com.example.dgbackend.domain.recipecomment.service;

import com.example.dgbackend.domain.recipecomment.RecipeComment;
import com.example.dgbackend.domain.recipecomment.dto.RecipeCommentVO;

public interface RecipeCommentService {
    RecipeComment getEntity(RecipeCommentVO paramVO);

    RecipeComment getParentEntityById(Long id);

    RecipeComment getEntityById(Long id);

}
