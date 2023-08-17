package com.isaacyakl.pleasanthollow.domain;

import com.isaacyakl.pleasanthollow.domain.properties.Link;
import com.isaacyakl.pleasanthollow.domain.template.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends Person {
    @Column(name = "display_name")
    private String displayName;
    private Link[] links;

}
