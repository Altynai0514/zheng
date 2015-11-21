/*
 * file name:  BInsertSort.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月19日
 */
package com.common.sort;

import java.util.Arrays;

/**
 * 折半插入排序 (前提为有序序列)
 * （向有序序列中插入元素，插入位置可以不断地平分有序序列，并把待插入元素与平分有序序列得到的元素进行比较，以确定下一步要平分的子序列，直到找到合适的插入位置）
 * 
 * @author  zheng
 * @version  [version, 2015年11月19日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class BInsertSort {
    
    public static int[] bInsert(int[] arr,int data){
        //组合成一个新的数组，data为新数组的最后一个数
        int[] newArr = Arrays.copyOf(arr, arr.length+1);
        newArr[newArr.length-1] = data;
        
        int low = 0;
        int hight = newArr.length-2;
        while(low <= hight){
            int middle = (low+hight)/2;
            if(data > newArr[middle])
                low = middle + 1;
            else 
                hight = middle - 1;
        }
        //把hight＋1后的元素依次向后移一位
        for(int i=newArr.length-1;i>hight+1;i--){
            newArr[i] = newArr[i-1];
        }
        //给higth＋1赋值
        newArr[hight+1] = data;
        
        return newArr;
    }
    
    public static void main(String[] args) {
        //有序序列
        int[] sortArr = {1,4,11,23,88,100,1001}; 
        int[] newArr = BInsertSort.bInsert(sortArr, 44);
        
        for(int i:newArr)
            System.out.print(i+" ");
    }
}
