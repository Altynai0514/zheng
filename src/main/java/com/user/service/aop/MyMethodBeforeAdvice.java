/*
 * file name:  MyMethodBeforeAdvice.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月2日
 */
package com.user.service.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置通知类
 * 
 * @author  zheng
 * @version  [version, 2015年11月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    /**
     * @param arg0 被调用的方法
     * @param arg1 给method传递的参数
     * @param arg2 目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method arg0, Object[] arg1, Object arg2)
            throws Throwable {
        System.out.println("method before...");
    }
}
