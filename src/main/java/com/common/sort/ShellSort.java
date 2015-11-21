/*
 * file name:  ShellSort.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月19日
 */
package com.common.sort;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年11月19日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class ShellSort {
    public static void main(String[] args) {  
        int[] arr={12,33,213,43,11,25};  
        int index=arr.length;  
        int len=index/2;//分割集合的间隔长度，初始值为数组长度的一半  
        int temp;  
        int pointer;//进行处理下标位置  
        //1.按每次减半划分步长，直到步长为1  
        while(len!=0){  
            //2.对各个集合进行处理  
            for(int i=len;i<index;i++){  
                pointer=i-len;//计算要和当前值进行比较的数的位置  
                temp=arr[i];//临时保存要进行比对的值，待交换值的使用  
                //3.将临时变量的值和集合内数值进行比较  
                while(temp<arr[pointer]){  
                    arr[pointer+len]=arr[pointer];//pointer是要交换位置的数的下标  
                    pointer=pointer-len;// 计算下一个欲进行比较的位置  
                    //如果当前下标位置大于或等于当前步长则继续循环，按步长距离与前面所有数进行比较  
                    //直至遇到比当前临时变量小的数为止  
                    if(pointer<0){  
                        break;  
                    }  
                }  
                // 跳出当前while循环然后，把临时变量赋值到当前下标位置，即：与最后的数值交换位置  
                arr[pointer+len]=temp;//因为前面已经减去步长，跳出循环后，这里需要补回来  
            }  
            len=len/2; // 计算下次分割的间隔步长  
        }  
        for(int x:arr){  
            System.out.print(x+" ");  
        }  
    }  
}
