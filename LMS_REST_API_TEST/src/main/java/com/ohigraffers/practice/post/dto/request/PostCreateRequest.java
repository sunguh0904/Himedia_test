package com.ohigraffers.practice.post.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
/* Swagger 문서화 시 설명 어노테이션 작성 */
@Schema(description = "포스트 생성 DTO")
public class PostCreateRequest {

    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* 필수 값이므로 유효성 검사 어노테이션 작성 */
    @NotNull(message = "타이틀은 반드시 입력되어야 합니다.")
    @NotBlank(message = "타이틀은 공백일 수 없습니다.")
    @Size(max = 20, message = "타이틀은 길이 20을 초과할 수 없습니다.")
    @Schema(description = "포스트 타이틀")
    private String title;

    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* 필수 값이므로 유효성 검사 어노테이션 작성 */
    @NotNull(message = "컨텐트는 반드시 입력되어야 합니다.")
    @NotBlank(message = "컨텐트는 공백일 수 없습니다.")
    @Length(max = 1000, message = "컨텐트는 길이 1000을 초과할 수 없습니다.")
    @Schema(description = "포스트 컨텐트")
    private String content;

    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* 필수 값이므로 유효성 검사 어노테이션 작성 */
    @NotNull(message = "저자는 반드시 입력되어야 합니다.")
    @NotBlank(message = "저자는 공백일 수 없습니다.")
    @Size(max = 5, message = "저자는 길이 5를 초과할 수 없습니다.")
    @Schema(description = "포스트 저자")
    private String writer;

}

