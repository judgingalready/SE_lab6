package com.example.springweb.service;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.service.AppInfoService;
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
* AppInfoService Tester. 
* 
* @author <Authors name> 
* @since 11/24/2019
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppInfoServiceTest {
@Autowired
AppInfoService appInfoService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getAppInfoList() 
* 
*/ 
@Test
public void testGetAppInfoList() throws Exception {
    List<AppInfo> Alist = appInfoService.getAppInfoList();
    assertNotNull(Alist);
    assertEquals(Alist.get(0).getId(), "1");
    assertEquals(Alist.get(0).getName(),"工业APP1");
} 


@Test
public void testUpdateByID() throws Exception { 
    AppInfo a1 = new AppInfo("1718","2","3","4","5","6");
    AppInfo a2 = new AppInfo("1718","2","3","4","5","6");
    AppInfo a3 = new AppInfo("","2","3","4","5","6");
    AppInfo a4 = new AppInfo("1agtgnsgdhnghmfhjmfgjmfhjneedtjndyhnyjumkrurk","2","3","4","5","6");
    appInfoService.UpdateByID(a1);
    appInfoService.UpdateByID(a2);
    appInfoService.UpdateByID(a3);
    appInfoService.UpdateByID(a4);
    List<AppInfo> Alist = appInfoService.getAppInfoList();
    assertNotNull(Alist);
    assertEquals(Alist.get(0).getId(), "1718");
    assertEquals(Alist.get(0).getName(),"2");
    assertEquals(Alist.get(1).getId(), "1718");
    assertEquals(Alist.get(2).getId(), "");
    assertNotNull(Alist.get(3));
} 


} 
