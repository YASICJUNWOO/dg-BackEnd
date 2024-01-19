package com.example.dgbackend.domain.recipecomment.service;

import com.example.dgbackend.domain.member.Member;
import com.example.dgbackend.domain.member.service.MemberService;
import com.example.dgbackend.domain.recipe.Recipe;
import com.example.dgbackend.domain.recipe.service.RecipeService;
import com.example.dgbackend.domain.recipecomment.RecipeComment;
import com.example.dgbackend.domain.recipecomment.dto.RecipeCommentRequest;
import com.example.dgbackend.domain.recipecomment.dto.RecipeCommentVO;
import com.example.dgbackend.domain.recipecomment.repository.RecipeCommentRepository;
import com.example.dgbackend.global.common.response.code.status.ErrorStatus;
import com.example.dgbackend.global.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeCommentServiceImpl implements RecipeCommentService {

    private final RecipeCommentRepository recipeCommentRepository;
    private final MemberService memberService;
    private final RecipeService recipeService;

    @Override
    public RecipeComment getEntity(RecipeCommentVO paramVO) {
        Member member = memberService.findMemberByName(paramVO.getMemberName());
        Recipe recipe = recipeService.getRecipe(paramVO.getRecipeId());
        String content = paramVO.getContent();

        return Optional.ofNullable(paramVO.getParentId())

                //대댓글 일 때
                .filter(parentId -> parentId != 0)
                .map(parentId -> RecipeCommentRequest.toEntity(member, recipe, content, getParentEntityById(parentId)))

                //댓글 일 때
                .orElse(RecipeCommentRequest.toEntity(member, recipe, content, null));
    }

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
