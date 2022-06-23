package com.declaration.declaration.service;
import com.declaration.declaration.model.User;

import java.util.List;
public interface IUserService {
    List<User> findAll();

    void save(User user);
}
