package com.if7103.intellitest.domain.domain;

import android.util.Log;

import com.if7103.intellitest.domain.entity.User;

public class ApplicationData {
    private User user;
    private static ApplicationData applicationData;

    private ApplicationData() {

    }

    public static ApplicationData getData() {
        if (applicationData == null) {
            applicationData = new ApplicationData();
        }
        return  applicationData;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}
