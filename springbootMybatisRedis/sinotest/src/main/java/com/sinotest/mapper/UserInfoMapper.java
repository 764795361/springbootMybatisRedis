package com.sinotest.mapper;

import com.sinotest.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 86136
 */
@Mapper
public interface UserInfoMapper {

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from userInfo")
    List<UserInfo> findAll();

    /**
     * 添加一条数据
     * @param userInfo
     */
    @Insert("INSERT INTO userInfo (id,name,password,age,sex) values(#{id},#{name},#{password},#{age},#{sex})")
    void saveUserInfo(UserInfo userInfo);

}
