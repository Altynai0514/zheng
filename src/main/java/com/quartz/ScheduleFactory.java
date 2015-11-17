/*
 * file name:  ScheduleFactory.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月22日
 */
package com.quartz;

import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * create Scheduler(单例)
 * 
 * @author  zheng
 * @version  [version, 2015年8月22日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class ScheduleFactory {
    private static Scheduler scheduler;
    
    private ScheduleFactory(){}
    
    private static class SingleClassInstance{
        private static final ScheduleFactory instance = new ScheduleFactory();
    }
    
    /***
     * get single schedule factory instance
     * @return [explain parameter]
     * 
     * @return ScheduleFactory [explain return type]
     * @exception throws [exception type] [explain exception]
     * @see [class,class#method,class#member]
     */
    public static ScheduleFactory getScheduleFactory(){
        return SingleClassInstance.instance;
    }
    
    /***
     * get scheduler
     * @return
     * @throws SchedulerException [explain parameter]
     * 
     * @return Scheduler [explain return type]
     * @exception throws [exception type] [explain exception]
     * @see [class,class#method,class#member]
     */
    public static Scheduler getScheduler(String threadName) throws SchedulerException{
        if(scheduler == null){
            StdSchedulerFactory sf = new StdSchedulerFactory("quartz.properties");
            Properties properties = new Properties();
            properties.put("org.quartz.scheduler.instanceName", threadName);
            properties.put("org.quartz.threadPool.threadCount", "20");
            sf.initialize(properties);
            scheduler = sf.getScheduler();
        }
        return scheduler;
    }
}
