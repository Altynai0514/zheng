/*
 * file name:  MyMethodAroundAdvice.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月2日
 */
package com.user.service.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知类
 * 
 * @author  zheng
 * @version  [version, 2015年11月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class MyMethodAroundAdvice implements MethodInterceptor {
    /**
     * @param arg0
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation arg0) throws Throwable {
        System.out.println("method around start...");
        arg0.proceed();
        System.out.println("method around end...");
        return null;
    }
}
