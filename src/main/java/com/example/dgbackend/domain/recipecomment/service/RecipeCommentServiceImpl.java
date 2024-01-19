package com.example.dgbackend.domain.recipecomment.service;

import com.example.dgbackend.domain.recipecomment.RecipeComment;
import com.example.dgbackend.domain.recipecomment.repository.RecipeCommentRepository;
import com.example.dgbackend.global.common.response.code.status.ErrorStatus;
import com.example.dgbackend.global.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeCommentServiceImpl implements RecipeCommentService {

    private final RecipeCommentRepository recipeCommentRepository;

    @Override
    public RecipeComment getParentEntityById(Long parentId) {
        RecipeComment ParentRecipeComment = getEntityById(parentId);

        //부모의 부모 댓글이 존재할 경우
        if (ParentRecipeComment.getParentComment() != null) {
            throw new ApiException(ErrorStatus._OVER_DEPTH_RECIPE_COMMENT);
        }

        return ParentRecipeComment;
    }

    @Override
    public RecipeComment getEntityById(Long id) {
        return recipeCommentRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorStatus._EMPTY_RECIPE_COMMENT));
    }

}
