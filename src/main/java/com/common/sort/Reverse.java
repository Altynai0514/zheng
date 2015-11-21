/*
 * file name:  ReverseTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月21日
 */
package com.common.sort;

/**
 * 原题：编写一个泛型方法，接收任意数组，并颠倒数组中的元素。  
 * 思想：  
 *  1.记住数组第一个和最后一个元素位置；  
 *  2.交换这两个位置上的元素；  
 *  3.第一个元素++，最后一个元素--，直到两个元素相逢。  
 * 
 * @author  zheng
 * @version  [version, 2015年11月21日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class Reverse {
    
    public static <T> void reverse(T[] arr){
        int start = 0;
        int end = arr.length-1;
        
        do {
            T temp = arr[start];
            arr[end] = arr[start];
            arr[start] = temp;
            
            start ++;
            end --;
        } while (start < end);
    }
    
    //判断一个整数是否是回文数。如果是返回‘true’,否则返回‘false’ 
    public static boolean isReverseNum(String str){
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString().equals(str)?true:false;
    }
    
}
