package com.sinotest.service;

import com.sinotest.entity.UserInfo;

import java.util.List;

/**
 * @author 86136
 */
public interface UserInfoService {

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> finAllUserInfo();

    /**
     * 插入一条数据
     * @param userInfo
     */
    void saveUserInfo(UserInfo userInfo);
}
