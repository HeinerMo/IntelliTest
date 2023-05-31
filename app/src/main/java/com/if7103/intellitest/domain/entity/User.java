package com.if7103.intellitest.domain.entity;

import androidx.annotation.NonNull;

public class User {
    private String userName;
    private String password;
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return this.password;
    }

    @NonNull
    @Override
    public String toString() {
        return "UserName: " + userName + " Password: " + password;
    }
}
