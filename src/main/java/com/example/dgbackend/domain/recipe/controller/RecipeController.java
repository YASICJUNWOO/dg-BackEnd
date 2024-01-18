package com.example.dgbackend.domain.recipe.controller;

import com.example.dgbackend.domain.enums.Gender;
import com.example.dgbackend.domain.enums.SocialType;
import com.example.dgbackend.domain.member.Member;
import com.example.dgbackend.domain.member.repository.MemberRepository;
import com.example.dgbackend.domain.recipe.dto.RecipeParamVO;
import com.example.dgbackend.domain.recipe.dto.RecipeRequest;
import com.example.dgbackend.domain.recipe.dto.RecipeResponse;
import com.example.dgbackend.domain.recipe.service.RecipeServiceImpl;
import com.example.dgbackend.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeServiceImpl recipeServiceImpl;

    //Default Member 생성
    //TODO: @AutenticationPrincipal로 변경
    private final MemberRepository memberRepository;
    private Member member = Member.builder()
            .name("김동규").email("email@email.com").birthDate("birthDate")
            .phoneNumber("phoneNumber").nickName("nickName").gender(Gender.MALE).socialType(SocialType.APPLE)
            .build();

    @GetMapping
    public ApiResponse<List<RecipeResponse>> getRecipes() {
        return ApiResponse.onSuccess(recipeServiceImpl.getExistRecipes());
    }

    @GetMapping("/detail")
    public ApiResponse<RecipeResponse> getRecipe(@RequestParam String name, @RequestParam String member) {
        return ApiResponse.onSuccess(recipeServiceImpl.getRecipeDetail(RecipeParamVO.of(name, member)));
    }

    @PostMapping
    public ApiResponse<RecipeResponse> createRecipe(@RequestBody RecipeRequest recipeRequest) {
        return ApiResponse.onSuccess(recipeServiceImpl.createRecipe(recipeRequest, member));
    }

    @PatchMapping
    public ApiResponse<RecipeResponse> updateRecipe(@RequestParam String name, @RequestParam String member, @RequestBody RecipeRequest recipeRequest) {
        return ApiResponse.onSuccess(recipeServiceImpl.updateRecipe(RecipeParamVO.of(name, member), recipeRequest));
    }

    @DeleteMapping
    public ApiResponse<String> deleteRecipe(@RequestParam String name, @RequestParam String member) {
        recipeServiceImpl.deleteRecipe(RecipeParamVO.of(name, member));
        return ApiResponse.onSuccess("삭제 완료");
    }

}
