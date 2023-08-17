package com.isaacyakl.pleasanthollow.domain;

import com.isaacyakl.pleasanthollow.domain.template.Object;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post extends Object {
    private String body;
}
