/*
 * file name:  SelfInteceptor.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月3日
 */
package com.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 * 
 * @author  zheng
 * @version  [version, 2015年8月3日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class SelfInteceptor implements HandlerInterceptor {
    
    //最后执行，可用于释放资源
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }
    
    //生产视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub
    }
    
    //Action之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object arg2) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        return false;
    }
}
