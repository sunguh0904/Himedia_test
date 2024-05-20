package com.ohigraffers.practice.post.controller;

import com.ohigraffers.practice.post.dto.request.PostCreateRequest;
import com.ohigraffers.practice.post.dto.request.PostUpdateRequest;
import com.ohigraffers.practice.post.dto.response.PostResponse;
import com.ohigraffers.practice.post.dto.response.ResponseMessage;
import com.ohigraffers.practice.post.model.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/* Swagger 문서화 시 Grouping 작성 */
@Tag(name = "Post 관련 api")
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
    @Operation(summary = "포스트 전체 조회")
    @GetMapping("/find")
    public ResponseEntity<ResponseMessage> findAllPosts() {
        /* 응답 데이터 설정 */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        /* Post 타입은 PostResponse 타입으로 변환해서 반환 */
        /* hateoas 적용 */
        List<EntityModel<PostResponse>> postEntityModel = posts.stream().map(
                post -> EntityModel.of(PostResponse.from(post),
                linkTo(methodOn(PostController.class).findAllPosts()).withRel("posts"),
                linkTo(methodOn(PostController.class).findPostByCode(post.getCode())).withSelfRel()
                )).toList();
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("posts", postEntityModel);
        ResponseMessage resMsg = new ResponseMessage(200, "조회 성공", resMap);
        /* ResponseEntity 반환 */
        return new ResponseEntity<>(resMsg, headers, HttpStatus.OK);
    }

    /* 2. 특정 코드로 포스트 조회 */
    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* RequestMapping 어노테이션 작성 */
    @Operation(summary = "특정 코드로 포스트 조회")
    @GetMapping("/find/{code}")
    public ResponseEntity<ResponseMessage> findPostByCode(@PathVariable long code) {
        /* 응답 데이터 설정 */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        /* Post 타입은 PostResponse 타입으로 변환해서 반환 */
        /* hateoas 적용 */
        Post foundPost = posts.stream().filter(post -> post.getCode() == code).toList().get(0);
        PostResponse response = PostResponse.from(foundPost);
        /* ResponseEntity 반환 */
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("posts", response);
        ResponseMessage resMsg = new ResponseMessage(200, "조회 성공", resMap);
        return ResponseEntity.ok().headers(headers).body(resMsg);
    }

    /* 3. 신규 포스트 등록 */
    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* RequestMapping 어노테이션 작성 */
    @Operation(summary = "신규 포스트 등록")
    @PostMapping("/regist")
   public ResponseEntity<Void> registPost(@RequestBody PostCreateRequest pcr) {
       /* 리스트에 추가 */
        Long lastPost = posts.get(posts.size() - 1).getCode();
       posts.add(new Post(lastPost + 1, pcr.getTitle(), pcr.getContent(), pcr.getWriter()));
       /* ResponseEntity 반환 */
       return ResponseEntity.created(URI.create("/posts/regist" + posts.get(posts.size() - 1).getCode())).build();
   }

   /* 4. 포스트 제목과 내용 수정 */
   /* Swagger 문서화 시 설명 어노테이션 작성 */
   /* RequestMapping 어노테이션 작성 */
    @Operation(summary = "포스트 제목 내용 수정")
    @PutMapping("/update/{postCode}")
    public ResponseEntity<Void> modifyPost(@PathVariable int postCode, @RequestBody PostUpdateRequest pur) {
        /* 리스트에서 찾아서 수정 */
        /* 수정 메소드 활용 */
        Post foundPost = posts.stream().filter(post -> post.getCode() == postCode).toList().get(0);
        foundPost.modifyTitleAndContent(pur.getTitle(), pur.getContent());
        /* ResponseEntity 반환 */
        return ResponseEntity.created(URI.create("/posts/update/" + postCode)).build();
    }

    /* 5. 포스트 삭제 */
    /* Swagger 문서화 시 설명 어노테이션 작성 */
    /* RequestMapping 어노테이션 작성 */
    @Operation(description = "포스트 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "포스트 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "포스트 삭제 실패")
    })
    @DeleteMapping("/posts/{postCode}")
    public ResponseEntity<Void> removeUser(@PathVariable int postCode) {
        /* 리스트에서 찾아서 삭제 */
        Post foundPost = posts.stream().filter(post -> post.getCode() == postCode).toList().get(0);
        posts.remove(foundPost);
        /* ResponseEntity 반환 */
        return ResponseEntity.noContent().build();
    }

}
