package com.isaacyakl.pleasanthollow.api.entity;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

//@Entity
//@Table(name = "access_events")
@Data
public class AccessEvent {
    // @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID accessedBy;
    private Date accessedOn;
    private UUID accessedObjectId;
}