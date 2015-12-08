/*
 * file name:  ComparableTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年12月6日
 */
package com.utils.test.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年12月6日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class ComparableTest{
    
    public static void main(String[] args) {
        StdComparable t1 = new StdComparable(10,"zhangsan");
        StdComparable t2 = new StdComparable(1,"xiaohong");
        StdComparable t3 = new StdComparable(6,"xiaosan");
        StdComparable t4 = new StdComparable(21,"xiaoer");
        StdComparable t5 = new StdComparable(4,"xiaoyi");
        
        //1.数组形式
        StdComparable[] arr = {t1,t2,t3,t4,t5};
        for(StdComparable s:arr){
            System.out.print(s.getId()+" ");
        }
        
        System.out.println();
        // 排序
        Arrays.sort(arr);
        for(StdComparable s:arr){
            //System.out.print(s.getId()+" ");
            System.out.print(s.getName()+" ");
        }
        
        System.out.println("---------上面数组，下面集合-----------");
        
        //2.集合形式
        List<StdComparable> list = Arrays.asList(arr);
        //重新洗牌
        Collections.shuffle(list);
        for(StdComparable s:arr){
            System.out.print(s.getId()+" ");
        }
        
        System.out.println();
        // 排序
        Collections.sort(list);
        for(StdComparable s:arr){
            //System.out.print(s.getId()+" ");
            System.out.print(s.getName()+" ");
        }
    }
}
