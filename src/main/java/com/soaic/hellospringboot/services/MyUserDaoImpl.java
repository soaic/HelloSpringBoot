package com.soaic.hellospringboot.services;

import com.mongodb.WriteResult;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.soaic.hellospringboot.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDaoImpl implements MyUserDAO{

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public List<MyUser> findByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        return mongoTemplate.find(query, MyUser.class);
    }

    @Override
    public MyUser insertUser(MyUser myUser) {
        return mongoTemplate.insert(myUser);
    }

    @Override
    public boolean deleteUser(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        DeleteResult result = mongoTemplate.remove(query, MyUser.class);
        return result.getDeletedCount() > 0;
    }

    @Override
    public boolean updateUser(MyUser myUser) {
        Criteria criteria= Criteria.where("id").is(myUser.getId());
        Update update = new Update();
        if (myUser.getUserName() != null)
            update.set("userName", myUser.getUserName());
        if (myUser.getPassword() != null)
            update.set("password", myUser.getPassword());
        UpdateResult result = mongoTemplate.updateFirst(new Query(criteria), update, MyUser.class);
        return result.getModifiedCount() > 0;
    }


}
