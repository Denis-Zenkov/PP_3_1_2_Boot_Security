package ru.kata.spring.boot_security.demo.repository;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();

    void addUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    void deleteUser(Long id);
}
