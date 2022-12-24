package com.adekunle.redisusingspringdataandjedis.repository;

import com.adekunle.redisusingspringdataandjedis.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{

    private final RedisTemplate redisTemplate;
    private final static String KEY = "USER";

    @Override
    public boolean saveUser(Users user) {
        try {
            redisTemplate.opsForHash().put(KEY,user.toString(), user);
return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) redisTemplate.opsForHash().values(KEY);
    }

    @Override
    public Users getUserById(Long id) {
        Users user = (Users)redisTemplate.opsForHash().get(KEY, id);
        return user;
    }

    @Override
    public boolean deleteUserById(Long userId) {
        try {
            redisTemplate.opsForHash().delete(KEY,userId.toString());
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(Long userId, Users user) {
        try {
            redisTemplate.opsForHash().put(KEY,user.toString(), user);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
