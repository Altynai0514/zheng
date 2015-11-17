/*
 * file name:  MyMethodAfterAdvice.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月2日
 */
package com.user.service.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置通知类
 * 
 * @author  zheng
 * @version  [version, 2015年11月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class MyMethodAfterAdvice implements AfterReturningAdvice {
    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object arg0, Method arg1, Object[] arg2,
            Object arg3) throws Throwable {
        System.out.println("method after...");
    }
}
