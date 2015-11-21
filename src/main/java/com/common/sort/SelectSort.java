/*
 * file name:  SelectSort.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月18日
 */
package com.common.sort;

/**
 * 选择排序 
 *（首先遍历线性表并将最小的元素与第一个元素进行交换，随后遍历剩余的元素将第二小的元素与第二个元素进行交换，以此类推）
 * (思路:每次循环得到最小值的下标，然后交换数据,如果交换的位置不等于原来的位置，则不交换。)
 * @author  zheng
 * @version  [version, 2015年11月18日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class SelectSort {
    
    public static void select(int[] arr){
        int temp = 0;
        int min = 0;
        
        for(int i=0;i<arr.length;i++){
            min = i;
            // 查找第i小的数，直到记下第i小数的位置  
            for(int j=i+1;j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            // 如果第i小数的位置不在i，则交换
            if(i != min){
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
