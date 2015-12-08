/*
 * file name:  CollectionsTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年12月6日
 */
package com.utils.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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
public class CollectionsTest {
    public static void main(String[] args) {
        Integer[] array = {1,6,23,45,88,99};
        Integer[] arr = {13,1,6,23,45,88,99,11};
        List<Integer> list = Arrays.asList(array);
        List<Integer> copyList = Arrays.asList(arr);
        
        //Reverses the order of the elements in the specified list.
        Collections.reverse(list);
        
        //Randomly permutes the specified list using a default source of randomness.  All permutations occur with approximately equal likelihood.
        Collections.shuffle(list);
        
        //Swaps the elements at the specified positions in the specified list.
        Collections.swap(list, 2, 5);
        
        //Replaces all of the elements of the specified list with the specified element.
        Collections.fill(list, null);
        
        /**
         * Copies all of the elements from one list into another.(copy src to dest)  After the
         * operation, the index of each copied element in the destination list
         * will be identical to its index in the source list.  The destination
         * list must be at least as long as the source list.  If it is longer, the
         * remaining elements in the destination list are unaffected. <p>
         */
        Collections.copy(list, copyList);
        
        //Rotates the elements in the specified list by the specified distance.
        Collections.rotate(list, 1);
        
        //Replaces all occurrences of one specified value in a list with another.
        Collections.replaceAll(list, 1, 77);
        
        //Returns the starting position of the first occurrence of the specified
        //target list within the specified source list, or -1 if there is no such occurrence. 
        int num = Collections.indexOfSubList(copyList,list);
        int num1 = Collections.lastIndexOfSubList(copyList,list);
        
        //Returns an unmodifiable view of the specified list.
        List<Integer> list2 = Collections.unmodifiableList(list);
        
        //Returns a synchronized (thread-safe) list backed by the specified list.
        List<Integer> list3 = (List<Integer>) Collections.synchronizedList(list);
        synchronized (list3) {
            Iterator<Integer> iterator = list3.iterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
        }
        
        //Returns {@code true} if the two specified collections have no elements in common.
        boolean flag = Collections.disjoint(list, copyList);
        
        //Adds all of the specified elements to the specified collection.
        Collections.addAll(list, 44);
        
        
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        
    }
}
