/*
 * file name:  InsertSort.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月18日
 */
package com.common.sort;

/**
 * 直接插入排序 
 * （将第一个元素看成有序序列，后面的元素依次插入该序列使之还是一个有序序列） 
 * 
 * @author  zheng
 * @version  [version, 2015年11月18日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class InsertSort {
    
    public static void insert(int[] arr){
        //从第二个元素开始循环与之前的有序序列比较
        for(int i=1;i<arr.length;i++){
            //待插入的直
            int data = arr[i];
            //待插入值的下标
            int temp = i;
            
            //while循环作用：待插入元素插入到合适位置
            while(temp>0 && arr[temp-1]>data){
                arr[temp] = arr[temp-1];
                temp--;
            }
            //交换数据，使之构成有序序列  
            arr[temp] = data;
        }
    }
}
