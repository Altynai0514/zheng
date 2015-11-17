/*
 * file name:  lockInterruptiblyTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月2日
 */
package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年11月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class LockInterruptiblyTest {
    
    private Lock lock = new ReentrantLock();
    
    public void insert(Thread thread) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName()+"得到了锁！");
        }
        catch (Exception e) {
            // TODO: handle exception
        }finally{
            System.out.println(Thread.currentThread().getName()+"执行finally!");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁！");
        }
    }
    
    class MyThread extends Thread{
        private LockInterruptiblyTest test = null;
        
        public MyThread(LockInterruptiblyTest test){
            this.test = test;
        }
        
        @Override
        public void run() {
            try {
                test.insert(Thread.currentThread());
            }
            catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"被中断");
            }
        }
    }
    
    /*public static void main(String[] args) {
        LockInterruptiblyTest lockTest = new LockInterruptiblyTest();
        MyThread thread1 = new MyThread(lockTest);
        MyThread thread2 = new MyThread(lockTest);
        thread1.start();
        thread2.start();
        
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        thread2.interrupt();
    }*/
    
}
