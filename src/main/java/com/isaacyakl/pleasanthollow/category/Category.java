package com.isaacyakl.pleasanthollow.category;

import com.isaacyakl.pleasanthollow.entity.Object;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import com.isaacyakl.pleasanthollow.Constants;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category extends Object {
    // Todo implement view counter
    @Column(columnDefinition = "integer default " + Constants.DEFAULT_VIEW_COUNT)
    private int viewCount = Constants.DEFAULT_VIEW_COUNT;

    @Builder
    public Category(UUID parentUuid, Boolean isEnabled, String title, String description) {
        super(parentUuid, isEnabled, title, description);
    }
}
