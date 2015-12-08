/*
 * file name:  Student.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年12月6日
 */
package com.utils.test.comparable;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年12月6日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class StdComparable implements Comparable<StdComparable> {
    
    private int id;
    private String name;
    
    public StdComparable(int id,String name){
        this.id = id;
        this.name = name;
    }

    /**
     * @param o
     * @return
     */
    /*@Override
    public int compareTo(StdComparable o) {
        if(id>o.getId()){
            return 1;
        }else if(id<o.getId()){
            return -1;
        }else{
            return 0;
        }
    }*/
    
    @Override
    public int compareTo(StdComparable o) {
        
        int i = this.name.compareTo(o.getName());
        
        if(i==0){
            return this.id-o.getId();
        }else{
            return i;
        }
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
