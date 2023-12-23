package com.blogApp.BlogApplication.service;

import com.blogApp.BlogApplication.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}
