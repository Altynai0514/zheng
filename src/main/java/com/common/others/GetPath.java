/*
 * file name:  Common.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月4日
 */
package com.common.others;


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
        //获取当前类的绝对路径
        System.out.println(this.getClass().getResource("").getPath());
        //获取当前工程路径
        System.out.println(System.getProperty("user.dir"));
        //获取当前工程路径
        System.out.println( System.getProperty("java.class.path")); 
    }
    
    public static void main(String[] args) {
        GetPath common = new GetPath();
        common.dosth();
    }
}
