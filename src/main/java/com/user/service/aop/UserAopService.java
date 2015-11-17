/*
 * file name:  UserAopService.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月2日
 */
package com.user.service.aop;

import com.user.impl.UserBye;
import com.user.impl.UserHello;

/**
 * 被代理类，相当于自己干的事
 * 
 * @author  zheng
 * @version  [version, 2015年11月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class UserAopService implements UserHello, UserBye {
    private String name;
    
    @Override
    public void sayBye() {
        System.out.println("Bye "+name);
    }
    
    @Override
    public void sayHello() {
        System.out.println("Hi "+name);
    }

    /**
     * @return returns name
     */
    public String getName() {
        return name;
    }

    /**
     * @param assgin values to name
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
