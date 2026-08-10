package com.back.p65260807.domain.post.post.repository;

import com.back.p65260807.domain.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}