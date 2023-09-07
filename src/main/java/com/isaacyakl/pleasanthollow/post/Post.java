package com.isaacyakl.pleasanthollow.post;

import com.isaacyakl.pleasanthollow.entity.Object;

import java.util.UUID;

import com.isaacyakl.pleasanthollow.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post extends Object {
    @NotNull(message = "Category is required")
    private UUID categoryId;

    @NotBlank(message = "Body is required")
    private String body;

    // Todo implement upvote and view counters
    @Column(columnDefinition = "integer default " + Constants.DEFAULT_UPVOTE_COUNT)
    private int upvoteCount = Constants.DEFAULT_UPVOTE_COUNT;
    @Column(columnDefinition = "integer default " + Constants.DEFAULT_VIEW_COUNT)
    private int viewCount = Constants.DEFAULT_VIEW_COUNT;

    @Builder
    public Post(UUID parentUuid, Boolean isEnabled, String title, String description,
            @NotNull(message = "Category is required") UUID categoryId,
            @NotBlank(message = "Body is required") String body) {
        super(parentUuid, isEnabled, title, description);
        this.body = body;
    }
}
