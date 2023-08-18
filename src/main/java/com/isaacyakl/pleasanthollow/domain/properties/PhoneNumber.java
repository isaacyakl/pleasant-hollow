package com.isaacyakl.pleasanthollow.domain.properties;

import com.isaacyakl.pleasanthollow.domain.templates.Object;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "phone_numbers")
public class PhoneNumber extends Object {
    private String number;
    private Boolean isPrimary;
    private Boolean isVerified;
    private Boolean showOnProfile;
    private Boolean isSmsEnabled;
}
