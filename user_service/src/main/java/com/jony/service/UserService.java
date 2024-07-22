package com.jony.service;

import com.jony.request.UserRequest;

public interface UserService {

	UserRequest saveUser(UserRequest request);

	UserRequest getUser(int id);

}
