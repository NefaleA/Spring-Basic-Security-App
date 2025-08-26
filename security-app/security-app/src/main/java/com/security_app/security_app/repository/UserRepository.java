package com.security_app.security_app.repository;

import com.security_app.security_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserPhoneNumber(String phoneNumber);

    Optional<User> findByEmail(String email);

    boolean existsByUserPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);
}