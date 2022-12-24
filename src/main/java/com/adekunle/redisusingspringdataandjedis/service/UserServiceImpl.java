package com.adekunle.redisusingspringdataandjedis.service;

import com.adekunle.redisusingspringdataandjedis.model.Users;
import com.adekunle.redisusingspringdataandjedis.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Override
    public boolean createUser(Users user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Users getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean deleteUserById(Long userId) {
        return userDao.deleteUserById(userId);
    }

    @Override
    public boolean updateUser(Long userId, Users user) {
        return userDao.updateUser(userId, user);
    }
}
