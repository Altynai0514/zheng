/*
 * file name:  BubbleSort.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月18日
 */
package com.common.sort;

/**
 * 冒泡排序 
 *（比较相邻的两个元素，如果它们之间的大小关系与期望的关系相反（逆序），则交换两个元素的位置；否则不交换）
 *（每轮将一个未排序的最大数放在后面 ）
 * 
 * @author  zheng
 * @version  [version, 2015年11月18日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class BubbleSort {
    
    public static void bubble(int[] arr){
        int temp = 0;
        // 总共循环多少次（n－1次）
        for(int i=0;i<arr.length-1;i++){
            // 每轮将一个未排序的最大数放在后面
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
}
