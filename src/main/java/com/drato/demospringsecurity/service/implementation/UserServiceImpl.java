package com.drato.demospringsecurity.service.implementation;

import com.drato.demospringsecurity.model.User;
import com.drato.demospringsecurity.repository.RoleRepository;
import com.drato.demospringsecurity.repository.UserRepository;
import com.drato.demospringsecurity.service.interfaces.UserRoleService;
import com.drato.demospringsecurity.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRoleService.createUserRole(user);
        userRepository.save(user);
    }

    @Override
    public boolean userExisted(String username) {
        return userRepository.existsUserByUsername(username);
    }
}
