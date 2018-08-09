package io.reade.testing.service;

import io.reade.testing.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
