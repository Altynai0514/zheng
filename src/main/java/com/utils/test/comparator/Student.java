/*
 * file name:  Student.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年12月6日
 */
package com.utils.test.comparator;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年12月6日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class Student {
    
    private int id;
    private String name;
    
    public Student(int id,String name){
        this.id = id;
        this.name = name;
    }

    /**
     * @return returns id
     */
    public int getId() {
        return id;
    }

    /**
     * @param assgin values to id
     */
    public void setId(int id) {
        this.id = id;
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
