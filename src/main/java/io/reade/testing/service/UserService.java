package io.reade.testing.service;

import io.reade.testing.model.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}
