package com.blogApp.BlogApplication.controller;

import com.blogApp.BlogApplication.dto.PostDto;
import com.blogApp.BlogApplication.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payload.PostResponse;

import static com.blogApp.BlogApplication.utils.AppConstants.*;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create Blog post rest API

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }


    @GetMapping()
    public PostResponse getALl(@RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NO, required = false) int pageNo,
                               @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE,required = false) int pageSize,
                               @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
                               @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIR,required = false) String direction) {
        return postService.getAllPosts(pageNo, pageSize,sortBy,direction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody  PostDto postDto,
                                                  @PathVariable(name = "id") long id) {
        PostDto postDtoResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Deleted the post",HttpStatus.OK);
    }

}
