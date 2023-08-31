package com.isaacyakl.pleasanthollow.post;

import com.isaacyakl.pleasanthollow.entity.Object;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post extends Object {
    @NotBlank(message = "Body is required")
    private String body;
}
