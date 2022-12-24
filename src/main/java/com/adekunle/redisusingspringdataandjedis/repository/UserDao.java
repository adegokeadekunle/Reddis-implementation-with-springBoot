package com.adekunle.redisusingspringdataandjedis.repository;

import com.adekunle.redisusingspringdataandjedis.model.Users;

import java.util.List;

public interface UserDao{
    boolean saveUser(Users user);

    List<Users> getAllUsers();

    Users getUserById(Long id);

    boolean deleteUserById(Long userId);

    boolean updateUser(Long userId, Users user);
}
