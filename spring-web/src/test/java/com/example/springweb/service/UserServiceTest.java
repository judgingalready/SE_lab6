package com.example.springweb.service; 

import com.example.springweb.dao.User;
import com.example.springweb.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import java.util.List;
import static org.junit.Assert.*;
/** 
* UserService Tester. 
* 
* @author <Authors name> 
* @since 11/24/2019
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
@Autowired
UserService userService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void testGetUserList() throws Exception {
    List<User> users = userService.getUserList();
    assertNotNull(users);
    assertEquals(users.get(0).getId(), "1");
    assertEquals(users.get(0).getPassword(),"1234");
} 

@Test
public void testRegister() throws Exception {
    User user1 = new User("1718","testuser","123456");
    User user2 = new User("1718","testuser","123456");
    User user3 = new User("","testuser","123456");
    User user4 = new User("1718asdfasdfasdfasdfasfvadvardfvarvargvaregaeraargareg","testuser","123456");
    userService.register(user1);
    userService.register(user2);
    userService.register(user3);
    userService.register(user4);
    List<User> users = userService.getUserList();
    assertNotNull(users);
    assertEquals(users.get(0).getId(), "1718");
    assertEquals(users.get(0).getPassword(),"123456");
    assertEquals(users.get(1).getId(), "1718");
    assertEquals(users.get(2).getId(), "");
    assertNotNull(users.get(3));
}

} 
