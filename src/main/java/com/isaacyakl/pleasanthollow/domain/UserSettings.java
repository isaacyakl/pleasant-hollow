package com.isaacyakl.pleasanthollow.domain;

import jakarta.persistence.Entity;

@Entity
public class UserSettings {
    private Boolean[] notifyBy; // email, sms, push
}
