package com.isaacyakl.pleasanthollow.user;

import lombok.Data;

//@Entity
//@Table(name = "user_settings")
@Data
public class UserSettings {
    private Boolean[] notifyBy; // email, sms, push
}
