package com.isaacyakl.pleasanthollow.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "user_settings")
public class UserSettings {
    private Boolean[] notifyBy; // email, sms, push
}
