package com.soaic.hellospringboot.mapper;

import com.soaic.hellospringboot.entity.MyUser;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MyUserMapper {

    Integer insertUser(MyUser user);

    Integer batchInsertUser(List<MyUser> users);

    MyUser deleteUser(Integer id);

    MyUser updateUser(MyUser user);

    MyUser selectUser(Integer id);

    List<MyUser> selectAllUser();

    @Select("select * from user_t where username like CONCAT('%',#{0},'%')")
    @ResultMap("com.soaic.hellospringboot.mapper.MyUserMapper.userMap")
    List<MyUser> selectUserByName(String name);

}
