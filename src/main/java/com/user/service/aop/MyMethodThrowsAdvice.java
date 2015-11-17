/*
 * file name:  MyMethodThrowsAdvice.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月2日
 */
package com.user.service.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 异常通知类
 * 
 * @author  zheng
 * @version  [version, 2015年11月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class MyMethodThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Method m ,Object[] objs,Object target,Exception e){
        System.out.println("出事了"+e.getMessage());
    }
}
