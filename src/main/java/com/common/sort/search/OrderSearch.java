/*
 * file name:  OrderSearch.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月19日
 */
package com.common.sort.search;

/**
 * 顺序查找
 * 
 * @author  zheng
 * @version  [version, 2015年11月19日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class OrderSearch {
    
    public static void order(int[] arr, int data){
        for(int i=0;i<arr.length;i++){  
            if(data==arr[i]){  
                System.out.println("查找成功");  
                System.out.println("该元素的位置为："+i);  
                break;  
            }if(i==arr.length-1){  
                System.out.println("查找失败");  
            }  
        }  
    }
}
