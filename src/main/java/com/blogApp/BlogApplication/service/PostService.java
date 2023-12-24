package com.blogApp.BlogApplication.service;

import com.blogApp.BlogApplication.dto.PostDto;
import org.springframework.stereotype.Service;
import payload.PostResponse;

import java.util.List;


public interface PostService {

    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String direction);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}
