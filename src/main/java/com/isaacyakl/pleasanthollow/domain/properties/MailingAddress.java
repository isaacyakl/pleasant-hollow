package com.isaacyakl.pleasanthollow.domain.properties;

import com.isaacyakl.pleasanthollow.domain.template.Object;
import jakarta.persistence.Entity;

@Entity
public class MailingAddress extends Object {
    private String street;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private Boolean isPrimary;
    private Boolean showOnProfile;
}
