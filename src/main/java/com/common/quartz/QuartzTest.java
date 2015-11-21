/*
 * file name:  QuartzTest.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月16日
 */
package com.common.quartz;

import net.sf.json.JSONObject;

import org.quartz.Job;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年11月16日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class QuartzTest {
    
    public static Scheduler scheduler;
    
    public void runJob(String schedulerName , String jobName , String triggerName){
        try {
            scheduler = ScheduleFactory.getScheduler(schedulerName);
            SimpleScheduleBuilder ssb = SimpleScheduleBuilder.repeatSecondlyForever(2);
            JSONObject json = new JSONObject();
            json.put("thread", Thread.currentThread().getName());
            ScheduleJobFactory.createSimpleJob(scheduler, jobName, "jobGroup", triggerName, "triggerGroup", 
                    ssb, DeployJob.class, json);
            scheduler.start();
        }
        catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws InterruptedException, SchedulerException {
        final QuartzTest test = new QuartzTest();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.runJob("deploy1","deploy1Job","deploy1Trigger");
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.runJob("deploy2","deploy2Job","deploy2Trigger");
            }
        }).start();
        
        Thread.sleep(1000*10);
        ScheduleJobFactory.deleteJob(ScheduleFactory.getScheduler("deploy1"), "deploy1Job","jobGroup");
    }
}
