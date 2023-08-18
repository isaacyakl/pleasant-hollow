package com.isaacyakl.pleasanthollow.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

//@Entity
//@Table(name = "access_events")
public class AccessEvent
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID accessedBy;
    private Date accessedOn;
    private UUID accessedObjectId;
}
