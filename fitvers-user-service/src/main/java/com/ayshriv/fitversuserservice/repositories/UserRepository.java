package com.ayshriv.fitversuserservice.repositories;

import com.ayshriv.fitversuserservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
