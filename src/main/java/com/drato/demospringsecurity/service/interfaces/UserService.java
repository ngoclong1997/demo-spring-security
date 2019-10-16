package com.drato.demospringsecurity.service.interfaces;

import com.drato.demospringsecurity.model.User;

public interface UserService {
    public User findUserByUsername(String username);
    public void createUser(User user);
    public boolean userExisted(String username);
}
