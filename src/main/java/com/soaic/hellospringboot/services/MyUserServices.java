package com.soaic.hellospringboot.services;

import com.soaic.hellospringboot.entity.MyUser;
import com.soaic.hellospringboot.mapper.MyUserMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyUserServices {

    @Resource
    private MyUserMapper userMapper;

    @CachePut(value = "user", key = "#user.id")  //如果方法参数为对象，并且不指定key，需要重写toString方法
    @Transactional(rollbackFor = IllegalArgumentException.class, noRollbackFor = IllegalStateException.class)
    public MyUser insertUser(MyUser user) {

        userMapper.insertUser(user);
        System.out.println("添加缓存key为"+user.getId());

        if (userMapper.selectUserByName2(user.getUserName()).size() >= 2) {
            throw new IllegalArgumentException("userName " +user.getUserName() + " is all through exist");
        }

        if (user.getPassword().equals("123456")) {
            throw new IllegalStateException("can't insert password 123456");
        }
        return user;
    }

    @Cacheable(value = "user") //不指定key，默认以方法参数为key
    public MyUser selectUser(Integer id) {
        MyUser user = userMapper.selectUser(id);
        System.out.println("添加缓存key为" + id);
        return user;
    }

    @CacheEvict(value = "user", beforeInvocation=true)
    public boolean removeUser(Integer id) {
        userMapper.deleteUser(id);
        System.out.println("删除缓存key为" + id);
        return true;
    }

    public List<MyUser> findUsers(MyUser myUser){
        return userMapper.findUsers(myUser);
    }

    public List<MyUser> login(String userName, String password) {
        return userMapper.login(userName, password);
    }

    public Integer insertUser(List<MyUser> users) {
        return userMapper.batchInsertUser(users);
    }

    public MyUser updateUser(MyUser user) {
        return userMapper.updateUser(user);
    }

    public List<MyUser> selectUser() {
        return userMapper.selectAllUser();
    }

    public List<MyUser> selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

}
