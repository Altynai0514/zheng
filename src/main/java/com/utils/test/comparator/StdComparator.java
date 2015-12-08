/*
 * file name:  StdComparator.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年12月6日
 */
package com.utils.test.comparator;

import java.util.Comparator;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年12月6日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class StdComparator implements Comparator<Student> {

    /**
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId()-o2.getId();
    }
    
}
