/*
 * file name:  ReentrantReadWriteLock.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月3日
 */
package com.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年11月3日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class ReentrantLock {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    public void get(Thread thread){
        lock.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis()-start<=1){
                System.out.println(thread.getName()+"正在读取操作！");
            }
            System.out.println(thread.getName()+"读取完毕！");
        }
        catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.readLock().unlock();
        }
    }
    
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.get(Thread.currentThread());
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.get(Thread.currentThread());
            }
        }).start();
    }
}
