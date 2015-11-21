/*
 * file name:  RecursionSort.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月19日
 */
package com.common.sort;

/**
 * 递归算法 
 * 
 * @author  zheng
 * @version  [version, 2015年11月19日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class RecursionSort {
    //三角函数：1，3，6，10，15，21......
    public int sort1(int n){
        if(n==1)
            return 1;
        return n+sort1(n-1);
    }
    
    //计算n! (1*2*3*4*5=120)
    public int sort2(int n){
        if(n==1)
            return 1;
        return n*sort2(n-1);
    }
    
    public static void main(String[] args) {
        RecursionSort rs = new RecursionSort();
        System.out.println(rs.sort1(6));
        System.out.println(rs.sort2(5));
    }
}
