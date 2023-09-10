package com.isaacyakl.pleasanthollow.api.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@MappedSuperclass
@Data
@NoArgsConstructor
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID parentId;

    // TODO: Implement auditing
    // https://docs.spring.io/spring-data/jpa/docs/1.7.0.DATAJPA-580-SNAPSHOT/reference/html/auditing.html
    // @CreatedDate
    // private Timestamp createdOn;
    // @CreatedBy
    // private UUID createdBy;
    // @LastModifiedDate
    // private Timestamp lastModifiedOn;
    // @LastModifiedBy
    // private UUID lastModifiedBy;

    @NotNull(message = "isEnabled is required")
    private Boolean isEnabled;
    @NotBlank(message = "Title is required")
    private String title;
    private String description;

    public Object(UUID parentUuid, @NotNull(message = "isEnabled is required") Boolean isEnabled,
            @NotBlank(message = "Title is required") String title, String description) {
        this.parentId = parentUuid;
        this.isEnabled = isEnabled;
        this.title = title;
        this.description = description;
    }
}
