package com.isaacyakl.pleasanthollow.domain.properties;

import com.isaacyakl.pleasanthollow.domain.templates.Object;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "email_addresses")
public class EmailAddress extends Object {
    private String email;
    private Boolean isPrimary;
    private Boolean isVerified;
    private Boolean showOnProfile;
}
