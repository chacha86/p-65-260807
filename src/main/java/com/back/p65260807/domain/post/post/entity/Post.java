package com.back.p65260807.domain.post.post.entity;

import com.back.p65260807.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Post extends BaseEntity {
    private String title;
    private String content;

}