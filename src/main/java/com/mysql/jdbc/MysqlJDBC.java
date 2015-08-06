/*
 * file name:  MysqlJDBC.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月2日
 */
package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年8月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class MysqlJDBC {
    
    public static void main(String[] args) {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zheng_schema","root","");
            //创建Statement
            Statement statement = connection.createStatement();
            //获取结果集
            ResultSet rs = statement.executeQuery("select * from user");
            
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
