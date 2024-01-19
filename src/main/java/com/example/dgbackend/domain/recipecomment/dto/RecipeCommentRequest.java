package com.example.dgbackend.domain.recipecomment.dto;

import com.example.dgbackend.domain.member.Member;
import com.example.dgbackend.domain.recipe.Recipe;
import com.example.dgbackend.domain.recipecomment.RecipeComment;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class RecipeCommentRequest {

    @Getter
    @Builder
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class Post {

        @NotNull
        private String content;

        @NotNull
        private Long parentId;

    }

}
