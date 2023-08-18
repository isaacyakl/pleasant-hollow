package com.isaacyakl.pleasanthollow.domain.templates;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@MappedSuperclass
public class Object {
    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;
    private UUID parentId;
    private Date createdOn;
    private UUID createdBy;
    private Date lastModifiedOn;
    private UUID lastModifiedBy;
    private Boolean isEnabled;
    private String title;
    private String description;
}
