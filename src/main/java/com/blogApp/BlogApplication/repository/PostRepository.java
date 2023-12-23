package com.blogApp.BlogApplication.repository;

import com.blogApp.BlogApplication.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
