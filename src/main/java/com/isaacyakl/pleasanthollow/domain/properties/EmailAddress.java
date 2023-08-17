package com.isaacyakl.pleasanthollow.domain.properties;

import com.isaacyakl.pleasanthollow.domain.template.Object;
import jakarta.persistence.Entity;

@Entity
public class EmailAddress extends Object {
    private String email;
    private Boolean isPrimary;
    private Boolean isVerified;
    private Boolean showOnProfile;
}
