/*
 * file name:  UserController.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年8月2日
 */
package com.user.controller;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.User;
import com.user.service.UserService;

/**
 * <Simple feature description >
 * <Detailed feature description>
 * 
 * @author  zheng
 * @version  [version, 2015年8月2日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
@Controller
@RequestMapping("/userController")
public class UserController {
//    @Resource(name = "userService")
//    private UserService userService;
    
    //@RequestMapping(value="/getAllUsers",method=RequestMethod.POST)
    @RequestMapping("/getAllUsers")
    @ResponseBody
    public String getAllUsers(){
        System.out.println("lalallalalalalalallala");
//        JSONObject object = new JSONObject();
//        JSONArray array = new JSONArray();
//        User[] users = userService.getAllUsers();
//        for(User user:users){
//            System.out.println("controller:"+user.getId()+" "+user.getName()+" "+user.getAge()+" "+user.getHobby()+" "+user.getAddress());
//            array.add(user);
//        }
//        object.put("users", array);
        return "";
    }
    
    
}
