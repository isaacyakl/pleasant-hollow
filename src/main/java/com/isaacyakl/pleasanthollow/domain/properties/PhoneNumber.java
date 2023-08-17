package com.isaacyakl.pleasanthollow.domain.properties;

import com.isaacyakl.pleasanthollow.domain.template.Object;
import jakarta.persistence.Entity;

@Entity
public class PhoneNumber extends Object {
    private String number;
    private Boolean isPrimary;
    private Boolean isVerified;
    private Boolean showOnProfile;
    private Boolean isSmsEnabled;
}
