package com.wx.sell.service;


import com.wx.sell.entity.User;

/**
 * Created by inner_peace
 */
public interface UserService {


    int updateUser(User user);


    User getUserById(Integer id);


    User login(String username, String password);

}
