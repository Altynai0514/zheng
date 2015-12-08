/*
 * file name:  ComparatorTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年12月6日
 */
package com.utils.test.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import com.utils.test.comparable.StdComparable;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年12月6日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class ComparatorTest {
    public static void main(String[] args) {
        StdComparator comparator = new StdComparator();
        
        System.out.println("TreeSet实现方法：");
        //1.实现方法1
        TreeSet<Student> set = new TreeSet<Student>(comparator);
        set.add(new Student(20, "xiaohong"));
        set.add(new Student(1, "xiaohong"));
        set.add(new Student(16, "xiaohong"));
        set.add(new Student(9, "xiaohong"));
        set.add(new Student(2, "xiaohong"));
        set.add(new Student(10, "xiaohong"));
        
        for(Student s:set){
            System.out.print(s.getId()+" ");
        }
        
        System.out.println("数组实现方法：");
        //2.实现方法2
        Student[] arr = {new Student(20,"zhangsan"),new Student(1,"zhangsan"),new Student(16,"zhangsan"),
                new Student(9,"zhangsan"),new Student(2,"zhangsan"),new Student(10,"zhangsan")};
        Arrays.sort(arr, new StdComparator());
        for(Student s:arr){
            System.out.print(s.getId()+" ");
        }
        
        System.out.println("集合实现方法：");
        //2.实现方法3
        List<Student> list = Arrays.asList(arr);
        Collections.sort(list, new StdComparator());
        for(Student s:list){
            System.out.print(s.getId()+" ");
        }
    }
}
