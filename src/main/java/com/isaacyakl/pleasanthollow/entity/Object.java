package com.isaacyakl.pleasanthollow.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import static jakarta.persistence.GenerationType.UUID;

@MappedSuperclass
@Data
public class Object {
    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;
    private UUID parentId;
    @NotBlank
    @CreatedDate
    private Date createdOn;
    @NotBlank
    private UUID createdBy;
    @NotBlank
    private Date lastModifiedOn;
    @NotBlank
    private UUID lastModifiedBy;
    @NotBlank
    private Boolean isEnabled;
    @NotBlank
    private String title;
    private String description;
}
