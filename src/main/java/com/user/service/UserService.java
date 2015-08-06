/*
 * file name:  UserService.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月2日
 */
package com.user.service;

import org.springframework.stereotype.Service;

import com.application.SpringContextHolder;
import com.bean.User;
import com.mybatis.inter.IUserOperation;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年8月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
@Service
public class UserService {
    
    public User[] getAllUsers(){
        IUserOperation userOperation = SpringContextHolder.getBean(IUserOperation.class);
        User[] users = userOperation.getAll();
        System.out.println(users[0].getId()+" "+users[0].getName()+" "+users[0].getAge()+" "+users[0].getHobby()+" "+users[0].getAddress());
        return users;
    }
}
