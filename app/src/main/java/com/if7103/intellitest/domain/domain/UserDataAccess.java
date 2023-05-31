package com.if7103.intellitest.domain.domain;

import com.if7103.intellitest.domain.core.DataAccess;
import com.if7103.intellitest.domain.entity.User;

public interface UserDataAccess extends DataAccess {

    public User getByUsername(String username);

}
