package com.soaic.hellospringboot.services;

import com.soaic.hellospringboot.entity.MyUser;

import java.util.List;

public interface MyUserDAO {

    List<MyUser> findByUserName(String userName);

    MyUser insertUser(MyUser myUser);

    boolean deleteUser(String id);

    boolean updateUser(MyUser myUser);



}
