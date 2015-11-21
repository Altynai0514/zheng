/*
 * file name:  ArrayListUtil.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年10月18日
 */
package com.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Resizable-array implementation of the <tt>List</tt> interface.  Implements
 * all optional list operations, and permits all elements, including <tt>null</tt>. 
 * 
 * @author  zheng
 * @version  [version, 2015年10月18日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class ArrayListTest {
    
    public static void main(String[] args) {
        //通过集合Collections.synchronizedList将其转换为一个线程安全的类
        List<String> list1 = Collections.synchronizedList(new ArrayList<String>());
        List<String> list2 = new ArrayList<String>();
        list2.add("abcd");
        
        List<String> list = new ArrayList<String>();
        //Appends the specified element to the end of this list.
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        //Inserts the specified element at the specified position in this list.
        list.add(3,"aaa");
        
        //Returns <tt>true</tt> if this list contains the specified element.
        boolean flag = list.contains("aaa");
        
        //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        int index = list.indexOf("ccc");
        //Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
        int last = list.lastIndexOf("aaa");
        
        //Returns an array containing all of the elements in this list in proper sequence (from first to last element).
        Object[] array =  list.toArray();
        
        //Returns the element at the specified position in this list.
        String string = list.get(2);
        
        //Replaces the element at the specified position in this list with the specified element.
        list.set(2, "ddd");
        
        //Removes the element at the specified position in this list.
        list.remove(3);
        list.removeAll(list2);
        
        //Removes all of the elements from this list.  The list will be empty after this call returns.
        list.clear();
        
        /**
         * Appends all of the elements in the specified collection to the end of
         * this list, in the order that they are returned by the
         * specified collection's Iterator.  The behavior of this operation is
         * undefined if the specified collection is modified while the operation
         * is in progress.  (This implies that the behavior of this call is
         * undefined if the specified collection is this list, and this
         * list is nonempty.)
         */
        list.addAll(list2);
        //list.addAll(3, list2);
        
        //Retains only the elements in this list that are contained in the specified collection.
        //list.retainAll(list2);
        
        //Returns an iterator over the elements in this list in proper sequence.
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //Returns a list iterator over the elements in this list (in proper sequence).
        ListIterator<String> list3 = list.listIterator();
        while(list3.hasNext()){
            //System.out.println(list3.next()); --null
        }
        //Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
        //The specified index indicates the first element that would be returned by an initial call to {@link ListIterator#next next}.
        ListIterator<String> list4 = list.listIterator(2);
        while(list4.hasNext()){
            System.out.println(list4.next());
        }
        
        //Returns a view of the portion of this list between the specified {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. 
        List<String> list5 = list.subList(1, 3);
        for(String str:list5){
            System.out.println(str);
        }
        
    }
    
}
