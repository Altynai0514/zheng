/*
  * file name:  Arrays.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年10月14日
 */
package com.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This class contains various methods for manipulating arrays (such as
 * sorting and searching). This class also contains a static factory
 * that allows arrays to be viewed as lists.
 * 
 * @author  zheng
 * @version  [version, 2015年10月14日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] arr = {3,1,22,11,8,10,56,999,0};
        int[] arr1 = {3,10,22,11,8,44,56,999,0};
        Integer[] arrs = {3,1,22,11,8,10,56,999,0};
        Integer[] arrs1 = {3,1,22,11,8,10,56,999,0};
        Object[] objs = {3,11,2,10};
        
        
        //Sorts the specified array into ascending numerical order.
        Arrays.sort(arr);
        //Sorts the specified range of the array into ascending order. The range to be sorted extends from the index {@code fromIndex}, 
        //inclusive, to the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},the range to be sorted is empty.
        //the last index
        Arrays.sort(arr, 1, 9);
        
        /**
        * Sorts the specified array of objects into ascending order, according
        * to the {@linkplain Comparable natural ordering} of its elements.
        * All elements in the array must implement the {@link Comparable}
        * interface.  Furthermore, all elements in the array must be
        * <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)} must
        * not throw a {@code ClassCastException} for any elements {@code e1}
        * and {@code e2} in the array)
        */
        
        //Arrays.sort(objs);
        Arrays.sort(objs,1,4);
        
        //实例化内部类
        Comparator<Integer> com = new ArraysTest().new myComparator();
        //实现重大到小排列（public static <T> void sort(T[] a, int fromIndex, int toIndex,Comparator<? super T> c) ）
        Arrays.sort(arrs, 0, arrs.length, com);
        for(Integer i:arrs){
            System.out.print(i+" ");
        }
        
        //Searches the specified array of longs for the specified value using the binary search algorithm. 
        Arrays.sort(arr);
        int result = Arrays.binarySearch(arr,33);
        //public static int binarySearch(long[] a, int fromIndex, int toIndex,long key)
        int result1 = Arrays.binarySearch(arr,0,5,33);
        //public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) 
        int result3 = Arrays.binarySearch(arrs, 22, com);
        
        //Assigns the specified long value to each element of the specified array of longs.
        Arrays.fill(arr, 77);
        //public static void fill(long[] a, int fromIndex, int toIndex, long val) 
        Arrays.fill(arr, 0, 2, 77);
        
        //Returns a fixed-size list backed by the specified array. 
        List<Integer> list = Arrays.asList(arrs);
        
        /**
         * Returns <tt>true</tt> if the two specified arrays of longs are
         * <i>equal</i> to one another.  Two arrays are considered equal if both
         * arrays contain the same number of elements, and all corresponding pairs
         * of elements in the two arrays are equal.  In other words, two arrays
         * are equal if they contain the same elements in the same order.  Also,
         * two array references are considered equal if both are <tt>null</tt>.<p>
         */
        boolean flag = Arrays.equals(new int[0], new int[0]);
        boolean flag1 = Arrays.equals(arr, arr1);
        //Returns <tt>true</tt> if the two specified arrays are <i>deeply equal</i> to one another.
        boolean flag2 = Arrays.deepEquals(arrs, arrs1);
        
        /**
         * Copies the specified array, truncating or padding with nulls (if necessary)
         * so the copy has the specified length.  For all indices that are
         * valid in both the original array and the copy, the two arrays will
         * contain identical values.  For any indices that are valid in the
         * copy but not the original, the copy will contain <tt>null</tt>.
         * Such indices will exist if and only if the specified length
         * is greater than that of the original array.
         * The resulting array is of exactly the same class as the original array.
         */
        int[] a = Arrays.copyOf(arr, 3);
        //Copies the specified range of the specified array into a new array.
        int[] array = Arrays.copyOfRange(arr, 0, 5);
        
        //Returns a hash code based on the contents of the specified array.
        int hashcode = Arrays.hashCode(arrs);
        //Returns a hash code based on the "deep contents" of the specified array.
        int deepHashcode = Arrays.deepHashCode(arrs);
        
        //Returns a string representation of the contents of the specified array.
        String str = Arrays.toString(arrs);
        //Returns a string representation of the "deep contents" of the specified array.
        String deepStr = Arrays.deepToString(arrs);
    }
    
    /***
     * implements Comparator接口
     * 如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值，这样颠倒一下，就可以实现反向排序了
     * 
     * @author  zheng
     * @version  [version, 2015年10月18日]
     * @see  [about class/method]
     * @since  [product/module version]
     */
    class myComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1<o2){
                return 1;
            }else if(o1>o2){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
