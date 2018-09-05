package com.wx.sell.dao;

import com.wx.sell.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by inner_peace
 */
@Mapper
public interface UserDao {


    int updateUser(User user);


    User getUserById(@Param("id") Integer id);


    User getUserByCond(@Param("username") String username, @Param("password") String password);

}
