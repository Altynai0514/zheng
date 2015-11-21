/*
 * file name:  Syncoronized.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月3日
 */
package com.common.lock;

/**
 * 
 * synchronized method
 * 
 * @author  zheng
 * @version  [version, 2015年11月3日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class Syncoronized {
    
    public synchronized void get(Thread thread){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=1){
            System.out.println(thread.getName()+"正在读取操作！");
        }
        System.out.println(thread.getName()+"读取完毕！");
    }
    
    public static void main(String[] args) {
        final Syncoronized syncoronized = new Syncoronized();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                syncoronized.get(Thread.currentThread());
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                syncoronized.get(Thread.currentThread());
            }
        }).start();
    }
}
