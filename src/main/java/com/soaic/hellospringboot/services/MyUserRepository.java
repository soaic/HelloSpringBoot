package com.soaic.hellospringboot.services;

import com.soaic.hellospringboot.entity.MyUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MyUserRepository extends MongoRepository<MyUser, String> {

    List<MyUser> findByUserName(String name);

    @Query("{'userName': ?0}")
    List<MyUser> withQueryUserName(String name);

}
