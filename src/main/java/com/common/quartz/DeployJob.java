/*
 * file name:  DeployJob.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月16日
 */
package com.common.quartz;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.UnableToInterruptJobException;

/**
 * Deploy job
 * 继承NamedJob是为了给线程设定job name，看log时能辨别该线程做的什么事
 * 
 * @author  zheng
 * @version  [version, 2015年11月16日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class DeployJob extends NamedJob{
    
    private static Log log = LogFactory.getLog(DeployJob.class);
    
    /**
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        // 执行父类业务
        super.execute(context);
        // 执行业务
        String name1 = context.getJobDetail().getJobDataMap().getString("name");
        JSONObject json = (JSONObject) context.getJobDetail().getJobDataMap().get("params");
        String thread1 = json.getString("thread");
        log.info("name : "+name1+"   thread : "+thread1);
        
        if(Thread.currentThread().isInterrupted()){
            log.info("----------------the job has been interrupted !");
            return;
        }
    }

    /**
     * @throws UnableToInterruptJobException
     */
    @Override
    public void interrupt() throws UnableToInterruptJobException {
        try {
            Scheduler scheduler = ScheduleFactory.getScheduler("deploy1");
            JobKey jobKey = JobKey.jobKey("deploy1Job","jobGroup");
            boolean interruptFlag = scheduler.interrupt(jobKey);
            if(!interruptFlag)
                log.error("error with interrupt the job");
        }
        catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
