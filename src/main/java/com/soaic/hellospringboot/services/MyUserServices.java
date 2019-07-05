package com.soaic.hellospringboot.services;

import com.soaic.hellospringboot.entity.MyUser;
import com.soaic.hellospringboot.mapper.MyUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyUserServices {

    @Resource
    private MyUserMapper userMapper;

    public Integer insertUser(MyUser user) {
        return userMapper.insertUser(user);
    }

    public List<MyUser> login(String userName, String password) {
        return userMapper.login(userName, password);
    }

    public Integer insertUser(List<MyUser> users) {
        return userMapper.batchInsertUser(users);
    }

    public MyUser deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    public MyUser updateUser(MyUser user) {
        return userMapper.updateUser(user);
    }

    public MyUser selectUser(Integer id) {
        return userMapper.selectUser(id);
    }

    public List<MyUser> selectUser() {
        return userMapper.selectAllUser();
    }

    public List<MyUser> selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

}
