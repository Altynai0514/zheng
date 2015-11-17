/*
 * file name:  NamedJob.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年11月16日
 */
package com.quartz;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年11月16日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public abstract class NamedJob implements InterruptableJob{
    private static Log log = LogFactory.getLog(NamedJob.class);

    /**
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        String jobName = context.getJobDetail().getJobDataMap().getString("name");
        if(StringUtils.isBlank(jobName))
            log.error("error with get the job name :"+jobName);
        else
            Thread.currentThread().setName(jobName);
            
    }
    
}
