/*
 * file name:  ScheduleJobFactory.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月22日
 */
package com.common.quartz;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 * To create scheduler job
 * 
 * @author xpz
 * @version [version, Jul 18, 2015]
 * @see [about class/method]
 * @since [product/module version]
 */
public class ScheduleJobFactory {
    private static Log log = LogFactory.getLog(ScheduleJobFactory.class);
    
    /***
     * create a simpleScheduler job
     * 
     * @param scheduler: the scheduler
     * @param jobName: the job name
     * @param jobGroup: the job group
     * @param triggerName: the trigger name
     * @param triggerGroup: the trigger group
     * @param ssb: the schedBuilder (eg:SimpleScheduleBuilder ssb =
     * SimpleScheduleBuilder.simpleSchedule() .withIntervalInMinutes(1)
     * .repeatForever();)
     * @param jobClass: the class which implement
     * job/StatefulJob(@DisallowConcurrentExecution)
     * @param params [explain parameter]
     * @return void [explain return type]
     * @exception throws [exception type] [explain exception]
     * @see [class,class#method,class#member]
     */
    public static void createSimpleJob(Scheduler scheduler, String jobName,
            String jobGroup, String triggerName, String triggerGroup,
            SimpleScheduleBuilder ssb, Class<? extends Job> jobClass,
            JSONObject params) {
        // build a schedule job
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobName, jobGroup)
                .build();
        // set job name
        jobDetail.getJobDataMap().put("name", jobName);
        // set job params
        if (params != null) {
            jobDetail.getJobDataMap().put("params", params);
        }
        // build a schedule simpleTrigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .startNow()
                .withSchedule(ssb)
                .build();
        // create a new schedule job
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        }
        catch (SchedulerException e) {
            log.info("error with create a simple schedule job!", e);
        }
    }
    
    /***
     * create a cronScheduler job
     * 
     * @param scheduler: the scheduler
     * @param jobName: the job name
     * @param jobGroup: the job group
     * @param triggerName: the trigger name
     * @param triggerGroup: the trigger group
     * @param cronExpression: the cron expression
     * @param jobClass: the class which implements
     * job/StatefulJob(@DisallowConcurrentExecution)
     * @param params: the param need to trransfer
     * @return void [explain return type]
     * @exception throws [exception type] [explain exception]
     * @see [class,class#method,class#member]
     */
    public static void createCronJob(Scheduler scheduler, String jobName,
            String jobGroup, String triggerName, String triggerGroup,
            String cronExpression, Class<? extends Job> jobClass,
            JSONObject params) {
        // build a schedule job
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobName, jobGroup)
                .build();
        // set job name
        jobDetail.getJobDataMap().put("name", jobName);
        // set job params
        if (params != null) {
            jobDetail.getJobDataMap().put("params", params);
        }
        // build a schedule cronTrigger
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
        // create a new schedule job
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        }
        catch (SchedulerException e) {
            log.info("error with create a simple schedule job!", e);
        }
    }
    
    /***
     * delete job from scheduler
     * @param scheduler
     * @param job
     * @param jobGroup [explain parameter]
     * 
     * @return void [explain return type]
     * @exception throws [exception type] [explain exception]
     * @see [class,class#method,class#member]
     */
    public static void deleteJob(Scheduler scheduler, String jobName, String jobGroup){
        try {
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
            if(scheduler.checkExists(jobKey)){
                scheduler.pauseJob(jobKey);
              //Get all Triggers that are associated with the identified job
                List<? extends Trigger>  triggers = scheduler.getTriggersOfJob(jobKey);
                for(Trigger trigger : triggers){
                    scheduler.pauseTrigger(trigger.getKey());
                    boolean unscJobFlag = scheduler.unscheduleJob(trigger.getKey());
                    if(!unscJobFlag)
                        log.error("error with unschedule job");
                }
            }
            
            //Interrupt all instances of the identified InterruptableJob executing in this Scheduler instance.
            if(scheduler.checkExists(jobKey)){
                boolean interruptFlag = scheduler.interrupt(jobKey);
                if(!interruptFlag)
                    log.error("error with interrupt the job");
            }
            
            if(scheduler.checkExists(jobKey)){
                boolean delJobFlag = scheduler.deleteJob(jobKey);
                if(!delJobFlag)
                    log.error("error with delete the job");
            }
        }
        catch (SchedulerException e) {
            e.printStackTrace();
        }
    } 
}