/*
 * file name:  SpringContextHolder.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月2日
 */
package com.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 以静态变量保存Spring ApplicationContext，使其在任何地方可以取出使用
 * 
 * @author  zheng
 * @version  [version, 2015年8月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
     
    /**
     * 实现ApplicationCOntextAware接口的context注入函数，将其存入静态变量
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }
    
    /**
     * get ApplicationContext instance
     * @return [explain parameter]
     * 
     * @return ApplicationContext [explain return type]
     * @exception throws [exception type] [explain exception]
     * @see [class,class#method,class#member]
     */
    public static ApplicationContext getApplicationContext(){
        checkApplicationContext();
        return applicationContext;
    }
    
    public static <T> T getBean(Class<T> clazz){
        checkApplicationContext();
        return applicationContext.getBean(clazz);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name){
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }
    
    /**
     * 清除ApplicationContext静态变量
     * 
     * @return void [explain return type]
     * @exception throws [exception type] [explain exception]
     * @see [class,class#method,class#member]
     */
    public static void cleanApplicationContext(){
        applicationContext = null;
    }
    
    private static void checkApplicationContext(){
        if(applicationContext == null){
            throw new IllegalStateException("The ApplicationContext is not Ioc, place define SpringContextHolder in applicationContext.xml!");
        }
    }
}
