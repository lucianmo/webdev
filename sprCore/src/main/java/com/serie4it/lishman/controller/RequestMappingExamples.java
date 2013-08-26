package com.serie4it.lishman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("path/*")
public class RequestMappingExamples {

    @RequestMapping("req.html")
    public ModelAndView reqMap() { 
    	ModelAndView mymav = new ModelAndView();
    	mymav.addObject("color", "red");
    	mymav.addObject("methodName", "@RequestMapping maps web requests onto a method of the controller. http://lishys-notes.com/old-lishys-notes/spring-mvc/controllers.html#1");
    	mymav.setViewName("notes/pagerequest");
        return mymav;
    }
    
    @RequestMapping("one.html")
    public ModelAndView first() {
    	ModelAndView mymav = new ModelAndView();
    	mymav.addObject("color", "red");
    	mymav.addObject("methodName", "@RequestMapping maps web requests onto a method of the controller. http://lishys-notes.com/old-lishys-notes/spring-mvc/controllers.html#1");    	
    	mymav.addObject("colorOne", "#01DF01");
    	mymav.addObject("methodOne", "First method method would be mapped to this URL http://host/root/app/my-path/one.html.");
    	mymav.setViewName("notes/pagerequest");
        return mymav;    	        
    }

    @RequestMapping("tw*.html")
    public ModelAndView second() {
    	ModelAndView mymav = new ModelAndView();
    	mymav.addObject("color", "red");
    	mymav.addObject("methodName", "@RequestMapping maps web requests onto a method of the controller. http://lishys-notes.com/old-lishys-notes/spring-mvc/controllers.html#1");    	
    	mymav.addObject("colorTwo", "#0101DF");
    	mymav.addObject("methodTwo", "Ant-style path patterns such as tw*.html are also supported.");
    	mymav.setViewName("notes/pagerequest");
        return mymav;       	
        
    }
    
    @RequestMapping("twenty.html")
    public ModelAndView twenty() {
    	ModelAndView mymav = new ModelAndView();
    	mymav.addObject("color", "red");
    	mymav.addObject("methodName", "@RequestMapping maps web requests onto a method of the controller. http://lishys-notes.com/old-lishys-notes/spring-mvc/controllers.html#1");    	
    	mymav.addObject("colorTwenty", "#FA8258");
    	mymav.addObject("methodTwenty", "So URLs ending in /my-path/two.html and /my-path/twenty.html would both find their way to the second() method.");
    	mymav.setViewName("notes/pagerequest");
        return mymav;       	
        
    }    
}
