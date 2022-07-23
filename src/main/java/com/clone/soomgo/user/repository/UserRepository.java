package com.clone.soomgo.user.repository;

import com.clone.soomgo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
