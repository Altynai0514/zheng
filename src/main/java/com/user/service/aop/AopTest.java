/*
 * file name:  AopTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月2日
 */
package com.user.service.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.user.impl.UserBye;
import com.user.impl.UserHello;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年11月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class AopTest {
    
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        UserHello hello = (UserHello) ac.getBean("proxyFactoryBean");
        hello.sayHello();
        System.out.println("---------------------------");
        UserBye bye = (UserBye) ac.getBean("proxyFactoryBean");
        bye.sayBye();
    }
}
