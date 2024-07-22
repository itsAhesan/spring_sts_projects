package com.jony.dao;

import com.jony.request.UserRequest;

public interface UserDao {

	UserRequest saveUser(UserRequest request);

	UserRequest getUser(int id);

}
