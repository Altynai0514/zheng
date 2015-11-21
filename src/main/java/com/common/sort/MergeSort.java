/*
 * file name:  MergeSort.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月19日
 */
package com.common.sort;

/**
 *  归并排序 
 * （归并是指将若干个已排序的子文件合并成一个有序的文件。）
 * 
 * @author  zheng
 * @version  [version, 2015年11月19日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class MergeSort {
    
    public static void main(String[] args) {  
        int[] num = { 51, 38, 49, 27, 62, 05, 16 ,-14,55};  
        int[] temp = new int[num.length];  
        num = mergesort(num, 0, num.length - 1, temp);  
        for (int i : num) {  
           System.out.print(i + " ");  
        }  
    }  
    /** 
     * 归并排序 
     */  
    private static int[] mergesort(int[] num, int s, int t, int[] temp) {  
          int m;  
          int[] num2 = new int[t + 1];  
          if (s == t)  
              temp[s] = num[s];  
          else {  
              m = (s + t) / 2;  
              mergesort(num, s, m, num2);//左半部分递归调用  
              mergesort(num, m + 1, t, num2);//右半部分递归调用  
              merg(num2, s, m, t, temp);// 由num2去归并，返回的值放到temp中,temp赋新值，其实就是更新num2,然后让num2再去归并，返回新的temp  
          }  
          return temp;  
         }  
      
    /** 
     * 有序表的合并 
     * @param num 数组 
     * @param l 左数组第一个元素的下标 
     * @param m 左数组最后一个元素的下标 
     * @param n 右数组最后一个元素的下标 
     * @param temp 
     */  
    public static void merg(int[] num, int l, int m, int n, int[] temp) {  
        int i, j, k;  
        i = l;  
        j = m + 1;  
        k = l;  
        while (i <= m && j <= n) {  
           if (num[i] < num[j])//取出小的放入中间数组  
               temp[k++] = num[i++];  
           else   
               temp[k++] = num[j++];  
        }  
        //剩余部分依次置入中间数组  
        while (i <= m) {  
            temp[k++] = num[i++];  
        }  
        while (j <= n) {  
            temp[k++] = num[j++];  
        }  
    }  
}
