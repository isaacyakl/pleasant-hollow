package com.isaacyakl.pleasanthollow.api.category;

import com.isaacyakl.pleasanthollow.api.Constants;
import com.isaacyakl.pleasanthollow.api.entities.Object;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
