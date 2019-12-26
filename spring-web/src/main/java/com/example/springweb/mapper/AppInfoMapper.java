package com.example.springweb.mapper;

import com.example.springweb.dao.AppInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppInfoMapper {
    @Select("select * from AppInfo ")
    @Results({
            @Result(property = "Id", column = "id"),
            @Result(property = "Name", column = "name"),
            @Result(property = "Audit_status", column = "audit_status"),
            @Result(property = "Classification", column = "classification"),
            @Result(property = "Name_conforms", column = "name_conforms"),
            @Result(property = "Security_level", column = "security_level")
    })
    List<AppInfo> findAll();

    @Select("select * from AppInfo where id = #{Id}")
    @Results({
            @Result(property = "Id", column = "id"),
            @Result(property = "Name", column = "name"),
            @Result(property = "Audit_status", column = "audit_status"),
            @Result(property = "Classification", column = "classification"),
            @Result(property = "Name_conforms", column = "name_conforms"),
            @Result(property = "Security_level", column = "security_level")
    })
    AppInfo getOne(String id);

    @Update("update AppInfo set name = #{Name}, audit_status = #{Audit_status}, classification = #{Classification}, name_conforms = #{Name_conforms}, security_level = #{Security_level} where id = #{Id}")
    void updateByID(AppInfo appInfo);

}
