package com.blogApp.BlogApplication.repository;

import com.blogApp.BlogApplication.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("Select c from Comment c where c.post.id = :id")
    List<Comment> getCommentsById(long id);

}
