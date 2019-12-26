package com.example.springweb.service;

import com.example.springweb.dao.User;
import com.example.springweb.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    public UserMapper userMapper;

    public List<User> getUserList() {
        List<User> list = userMapper.findAll();
        return list;
    }

    /*public void InsertUser(HelloUser helloUser){
        helloMapper.insert(helloUser);
        System.out.println("Afterinsert:"+helloMapper.findAll());
    }*/
    public void register(User helloUser){
        userMapper.insert(helloUser);
    }


    /*public User getOne(String id){
        //HelloUser result = new HelloUser();
        User result = userMapper.getOne(id);
        System.out.println("getOne:"+result);
        if (result==null)
        {
            result=new User();//索引为空的时候，返回null，需要这时候对其getId,getName就会出错。
        }
        System.out.println(result.toString());
        return result;
    }*/

    /*public void UpdateByID(HelloUser helloUser){
        helloMapper.updateByID(helloUser);
        System.out.println("AfterUpdate:"+ helloMapper.getOne(helloUser.getId()));
    }*/
    /*public void UpdateByID(Map<String, String> params){
        String id = params.get("id");
        //Long recordId = Long.parseLong(params.get("recordId"));
        //ObjectMapper objectMapper = new ObjectMapper();
        //HelloUser helloUser = objectMapper.convertValue(params, HelloUser.class);
        //helloMapper.updateByID(helloUser);
        User temp = userMapper.getOne(id);
        if(params.get("name")!=null)
            temp.setName(params.get("name"));
        if(params.get("password")!=null)
            temp.setPassword((params.get("password")));
        userMapper.updateByID(temp);
    }*/


    /*public void DeleteByID(String id){
        userMapper.deleteByID(id);
        System.out.println("AfterDelete:"+ userMapper.getOne(id));
    }*/
}
