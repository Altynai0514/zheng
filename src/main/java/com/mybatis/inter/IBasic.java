/*
 * file name:  IBasic.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月2日
 */
package com.mybatis.inter;


/**
 * 通用接口，包含增删改查
 * 
 * @author  zheng
 * @version  [version, 2015年8月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public interface IBasic {
    public <T> T[] getAll();
    
    public <T,K> T getById(K id);
    
    public <T> T add(T t);
    
    public <T> T update(T t);
    
    public <K> int delete(K id);
}
