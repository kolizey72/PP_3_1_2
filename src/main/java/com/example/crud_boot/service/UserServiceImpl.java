package com.example.crud_boot.service;

import com.example.crud_boot.model.User;
import com.example.crud_boot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(long id) {
        return userRepository.findById(id);
    }

    public void add(User user) {
        userRepository.add(user);
    }

    public void update(long id, User updatedUser) {
        userRepository.update(id, updatedUser);
    }

    public void delete(long id) {
        userRepository.delete(id);
    }
}
