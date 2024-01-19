package com.example.dgbackend.global.common.response.code.status;

import com.example.dgbackend.global.common.response.code.BaseErrorCode;
import com.example.dgbackend.global.common.response.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    //일반 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    //멤버 관련
    _EMPTY_MEMBER(HttpStatus.CONFLICT, "MEMBER_001", "존재하지 않는 사용자입니다."),

    //인증 관련
    _EMPTY_JWT(HttpStatus.UNAUTHORIZED, "AUTH_001", "JWT가 존재하지 않습니다."),
    _INVALID_JWT(HttpStatus.UNAUTHORIZED, "AUTH_002", "유효하지 않은 JWT입니다."),

    //레시피
    _EMPTY_RECIPE(HttpStatus.CONFLICT, "RECIPE_001", "존재하지 않는 레시피입니다."),
    _DELETE_RECIPE(HttpStatus.BAD_REQUEST, "RECIPE_002", "삭제된 레시피입니다."),
    _ALREADY_CREATE_RECIPE(HttpStatus.BAD_REQUEST, "RECIPE_003", "이미 존재하는 레시피입니다."),

    //레시피 댓글
    _EMPTY_RECIPE_COMMENT(HttpStatus.CONFLICT, "RECIPE_COMMENT_001", "존재하지 않는 레시피 댓글입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
            .message(message)
            .code(code)
            .isSuccess(false)
            .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
            .message(message)
            .code(code)
            .isSuccess(false)
            .httpStatus(httpStatus)
            .build()
            ;
    }
}