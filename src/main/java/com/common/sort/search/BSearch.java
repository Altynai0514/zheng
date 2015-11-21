/*
 * file name:  BSearch.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月19日
 */
package com.common.sort.search;

import java.util.Arrays;

/**
 * 折半查找 (前提为有序序列)
 * 
 * @author  zheng
 * @version  [version, 2015年11月19日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class BSearch {
    
    public static void bSearch(int[] arr, int data){
        //组合成一个新的数组，data为新数组的最后一个数
        int[] newArr  = Arrays.copyOf(arr, arr.length+1);
        newArr[newArr.length-1] = data;
        
        int low=0;  
        int hight=newArr.length-1;  
        while(low<=hight){  
            int middle=(low+hight)/2;  
            if(data==newArr[middle]){  
                System.out.println("查找成功");  
                System.out.println("该元素的位置为："+middle);  
                return; 
            }else if(data>newArr[middle]){  
                low=middle+1;  
            }else  
                hight=middle-1;  
        }  
        System.out.println("查找失败"); 
    }
    
    public static void main(String[] args) {
        int[] arr = {2,3,4,8,10,11,22,77,99,456};
        BSearch.bSearch(arr, 2);
    }
}
