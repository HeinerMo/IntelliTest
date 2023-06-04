package com.if7103.intellitest.domain.entity;

import androidx.annotation.NonNull;

import java.util.List;

public class User {
    private String userName;
    private String password;

    private List<Integer> points;
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

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }
}
