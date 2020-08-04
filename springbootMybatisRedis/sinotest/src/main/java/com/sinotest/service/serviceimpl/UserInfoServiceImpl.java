package com.sinotest.service.serviceimpl;

import com.sinotest.entity.UserInfo;
import com.sinotest.mapper.UserInfoMapper;
import com.sinotest.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86136
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> finAllUserInfo() {
        return userInfoMapper.findAll();
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoMapper.saveUserInfo(userInfo);
    }
}
