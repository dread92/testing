package io.reade.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.reade.testing.model.User;

@Repository("userRepositiory")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
