package com.adekunle.redisusingspringdataandjedis.service;

import com.adekunle.redisusingspringdataandjedis.model.Users;

import java.util.List;

public interface UserService {
    boolean createUser(Users user);

    List<Users> getAllUsers();

    Users getUserById(Long id);

    boolean deleteUserById(Long userId);

    boolean updateUser(Long userId, Users user);
}
