package com.example.springweb.mapper;

import com.example.springweb.dao.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user ")
    @Results({
            @Result(property = "id", column = "stringId"),
            @Result(property = "name", column = "user_name")
    })
    List<User> findAll();

    @Insert("insert into user(stringId,user_name,password) values(#{id},#{name},#{password})")
    void insert(User helloUser);


    @Select("select * from user where stringId = #{id}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "user_name")
    })
    User getOne(String id);

    @Update("update user set user_name = #{name}, password = #{password} where StringId = #{id}")
    void updateByID(User helloUser);//UPDATE è¡¨åç§SET åˆ—åç§= æ–°å€WHERE åˆ—åç§= æŸå€
    @Delete("delete from user where StringId = #{id}")
    void deleteByID(String id);//DELETE FROM è¡¨åç§WHERE åˆ—åç§= å€}
}
