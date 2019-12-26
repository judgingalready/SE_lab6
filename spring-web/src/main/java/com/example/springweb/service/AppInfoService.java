package com.example.springweb.service;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.mapper.AppInfoMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AppInfoService {
    @Resource
    public AppInfoMapper appInfoMapper;

    public List<AppInfo> getAppInfoList() {
        return appInfoMapper.findAll();
    }

    public void UpdateByID(AppInfo temp){
        appInfoMapper.updateByID(temp);
    }

}
