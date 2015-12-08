/*
 * file name:  Common.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月4日
 */
package com.utils;

import org.apache.catalina.connector.Request;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;


/**
 * get path test
 * 
 * @author  zheng
 * @version  [version, 2015年11月4日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class GetPath {
    
    public void dosth(){
        //获取当前类的所在工程路径
        System.out.println(this.getClass().getResource("/").getPath());
        //通过类加载器获取类所在工程路径（class文件）
        System.out.println(this.getClass().getClassLoader().getResource(""));
        //获取当前classPath的绝对路径的URL
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        
        //获取当前类的绝对路径
        System.out.println(this.getClass().getResource("").getPath());
        //获取当前工程路径
        System.out.println(System.getProperty("user.dir"));
        //获取当前工程路径
        System.out.println( System.getProperty("java.class.path")); 
        
        //Servlet获取绝对路径
        //this.getServletContext().getRealPath("/");
        //Struts获取绝对路径
        //this.getRequest().getServletContext().getRealPath("/");
        //Servlet和Struts都可以的获取绝对路径方式
        //request.getSession().getServletContext().getRealPath("/");
        
        //JSP获取绝对路径方式：
        //1.修改表单提交路径为绝对路径
        //<%= request.getContextPath() %>
        //2.表单提交路径不改，页面添加代码
        //2.1 <% String path = request.getContextPath();
        //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
        //2.2 <head>中添加如下代码，为页面添加基链接
        // <base href = "<%= basePath %>">
    }
    
    public static void main(String[] args) {
        GetPath common = new GetPath();
        common.dosth();
    }
}
