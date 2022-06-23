package com.declaration.declaration.repository;

import com.declaration.declaration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
