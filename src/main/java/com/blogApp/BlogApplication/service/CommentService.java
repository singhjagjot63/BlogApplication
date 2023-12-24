package com.blogApp.BlogApplication.service;

import com.blogApp.BlogApplication.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getComments(long postId);
    CommentDto getCommentById(long postId, long commentId);
    CommentDto updateCommentById(long postId, long commentId, CommentDto commentRequest);
    void deleteCommentById(long postId, long commentId);
}
