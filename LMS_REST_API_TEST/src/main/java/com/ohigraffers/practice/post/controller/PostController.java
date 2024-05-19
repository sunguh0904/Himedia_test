package com.ohigraffers.practice.post.controller;

import com.ohigraffers.practice.post.dto.response.ResponseMessage;
import com.ohigraffers.practice.post.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/* Swagger 문서화 시 Grouping 작성 */
@RestController
@RequestMapping("/posts")
public class PostController {

    private List<Post> posts;

    public PostController(){
        posts = new ArrayList<>();
        posts.add(new Post(1L, "제목1", "내용1", "홍길동"));
        posts.add(new Post(2L, "제목2", "내용2", "유관순"));
        posts.add(new Post(3L, "제목3", "내용3", "신사임당"));
        posts.add(new Post(4L, "제목4", "내용4", "이순신"));
        posts.add(new Post(5L, "제목5", "내용5", "장보고"));
    }

    /* 1. 전체 포스트 조회 */
    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* RequestMapping 어노테이션 작성 */
    public ResponseEntity<ResponseMessage> findAllPosts() {

        /* 응답 데이터 설정 */
        /* Post 타입은 PostResponse 타입으로 변환해서 반환 */
        /* hateoas 적용 */

        /* ResponseEntity 반환 */
        return null;
    }

    /* 2. 특정 코드로 포스트 조회 */
    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* RequestMapping 어노테이션 작성 */
    public ResponseEntity<ResponseMessage> findPostByCode(/* 필요 매개변수 선언 */) {

        /* 응답 데이터 설정 */
        /* Post 타입은 PostResponse 타입으로 변환해서 반환 */
        /* hateoas 적용 */

        /* ResponseEntity 반환 */
        return null;
    }

    /* 3. 신규 포스트 등록 */
    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* RequestMapping 어노테이션 작성 */
   public ResponseEntity<Void> registPost(/* 필요 매개변수 선언, 유효성 검사 */) {

       /* 리스트에 추가 */

       /* ResponseEntity 반환 */
       return null;
   }

   /* 4. 포스트 제목과 내용 수정 */
   /* Swagger 문서화 시 설명 어노테이션 작성 */
   /* RequestMapping 어노테이션 작성 */
    public ResponseEntity<Void> modifyPost(/* 필요 매개변수 선언, 유효성 검사 */) {

        /* 리스트에서 찾아서 수정 */
        /* 수정 메소드 활용 */

        /* ResponseEntity 반환 */
        return null;
    }

    /* 5. 포스트 삭제 */
    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* RequestMapping 어노테이션 작성 */
    public ResponseEntity<Void> removeUser(/* 필요 매개변수 선언 */) {

        /* 리스트에서 찾아서 삭제 */

        /* ResponseEntity 반환 */
        return null;
    }

}
