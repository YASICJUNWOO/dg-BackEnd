package com.example.dgbackend.domain.recipe.controller;

import com.example.dgbackend.domain.enums.Gender;
import com.example.dgbackend.domain.enums.SocialType;
import com.example.dgbackend.domain.member.Member;
import com.example.dgbackend.domain.member.repository.MemberRepository;
import com.example.dgbackend.domain.recipe.dto.RecipeParamVO;
import com.example.dgbackend.domain.recipe.dto.RecipeRequestDTO;
import com.example.dgbackend.domain.recipe.dto.RecipeResponseDTO;
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
    public ApiResponse<List<RecipeResponseDTO>> getRecipes() {
        return ApiResponse.onSuccess(recipeServiceImpl.getExistRecipes());
    }

    @GetMapping("/detail")
    public ApiResponse<RecipeResponseDTO> getRecipe(@RequestParam String name, @RequestParam String member) {
        return ApiResponse.onSuccess(recipeServiceImpl.getRecipeDetail(RecipeParamVO.of(name, member)));
    }

    @PostMapping
    public ApiResponse<RecipeResponseDTO> createRecipe(@RequestBody RecipeRequestDTO recipeRequestDto) {
        return ApiResponse.onSuccess(recipeServiceImpl.createRecipe(recipeRequestDto, member));
    }

    @PatchMapping
    public ApiResponse<RecipeResponseDTO> updateRecipe(@RequestParam String name, @RequestParam String member, @RequestBody RecipeRequestDTO recipeRequestDto) {
        return ApiResponse.onSuccess(recipeServiceImpl.updateRecipe(RecipeParamVO.of(name, member), recipeRequestDto));
    }

    @DeleteMapping
    public ApiResponse<String> deleteRecipe(@RequestParam String name, @RequestParam String member) {
        recipeServiceImpl.deleteRecipe(RecipeParamVO.of(name, member));
        return ApiResponse.onSuccess("삭제 완료");
    }

}
