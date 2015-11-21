/*
 * file name:  SortTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月18日
 */
package com.common.sort;

import com.common.sort.search.OrderSearch;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年11月18日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class SortTest {
    
    public static void main(String[] args) {
        int[] arr = {11,22,4,99,3,10,77,456,2,8};
        
        //BubbleSort.bubble(arr);
        //SelectSort.select(arr);
        //InsertSort.insert(arr);
        //OrderSearch.order(arr, 77);
        
        for(int i:arr)
            System.out.print(i+" ");
        
        System.out.println(Reverse.isReverseNum("123453654321"));
    }
}
