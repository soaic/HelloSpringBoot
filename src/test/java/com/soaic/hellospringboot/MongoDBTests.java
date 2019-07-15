package com.soaic.hellospringboot;


import com.alibaba.fastjson.JSON;
import com.soaic.hellospringboot.entity.MyUser;
import com.soaic.hellospringboot.entity.Role;
import com.soaic.hellospringboot.services.MyUserDaoImpl;
import com.soaic.hellospringboot.services.MyUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBTests {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private MyUserDaoImpl myUserDaoImpl;

    @Test
    public void testSave() {
        MyUser myUser = new MyUser();
        myUser.setUserName("Soaic");
        myUser.setPassword("123456");

        Collection<Role> roles = new LinkedHashSet<>();
        Role role = new Role();
        role.setRoleName("管理员");
        roles.add(role);

        Role role1 = new Role();
        role1.setRoleName("程序员");
        roles.add(role1);
        myUser.setRoles(roles);

        //myUserRepository.save(myUser);
        myUserDaoImpl.insertUser(myUser);
    }

    @Test
    public void testFind() {
        List<MyUser> myUserList = myUserDaoImpl.findByUserName("Soaic");
        System.out.println(JSON.toJSONString(myUserList));
    }

    @Test
    public void testUpdate() {
        List<MyUser> myUserList = myUserRepository.withQueryUserName("Soaic");
        for (MyUser myUser: myUserList) {
            myUser.setPassword("1234567");
            myUserDaoImpl.updateUser(myUser);
        }
    }

    @Test
    public void testDel() {
        List<MyUser> myUserList = myUserRepository.findByUserName("Soaic");
        for (MyUser myUser: myUserList) {
            myUserDaoImpl.deleteUser(myUser.getId());
        }
    }

}
