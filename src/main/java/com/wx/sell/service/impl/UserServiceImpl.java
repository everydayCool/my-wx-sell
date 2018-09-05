package com.wx.sell.service.impl;

import com.wx.sell.constant.ErrorConstant;
import com.wx.sell.dao.UserDao;
import com.wx.sell.entity.User;
import com.wx.sell.exception.BusinessException;
import com.wx.sell.service.UserService;
import com.wx.sell.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Donghua.Chen on 2018/4/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响


    @Transactional
    @Override
    public int updateUser(User user) {
        if (null == user.getId())
            throw BusinessException.withErrorCode("用户编号不可能为空");
        return userDao.updateUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password))
            throw BusinessException.withErrorCode(ErrorConstant.Auth.USERNAME_PASSWORD_IS_EMPTY);

        String pwd = TaleUtils.MD5encode(username + password);
        User user = userDao.getUserByCond(username, pwd);
        if (null == user)
            throw BusinessException.withErrorCode(ErrorConstant.Auth.USERNAME_PASSWORD_ERROR);

        return user;
    }


}
