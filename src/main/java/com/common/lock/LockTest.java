/*
 * file name:  lockTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月2日
 */
package com.common.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock
 * 
 * @author  zheng
 * @version  [version, 2015年11月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class LockTest {
    
    private List<Integer> list = new ArrayList<Integer>();
    
    private Lock lock = new ReentrantLock();
    
    public void insert(Thread thread){
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁！");
            for(int i=0;i<5;i++){
                list.add(i);
            }
        }
        catch (Exception e) {
            // TODO: handle exception
        }finally{
            System.out.println(thread.getName()+"释放了锁！");
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        final LockTest test = new LockTest();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }).start();
        
    }
}
