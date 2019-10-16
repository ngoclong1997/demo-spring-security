package com.drato.demospringsecurity.service.implementation;

import com.drato.demospringsecurity.model.User;
import com.drato.demospringsecurity.model.UserRole;
import com.drato.demospringsecurity.repository.UserRoleRepository;
import com.drato.demospringsecurity.service.interfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository repository;

    @Override
    public void createUserRole(User user) {
        List<String> roles = user.getRoles();
        String username = user.getUsername();
        UserRole userRole;
        for (String role : roles) {
            userRole = new UserRole(role, username);
            repository.save(userRole);
        }
    }
}
