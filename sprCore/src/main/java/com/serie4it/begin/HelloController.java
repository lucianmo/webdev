package com.serie4it.begin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	protected final Logger logger = Logger.getLogger(getClass());

    @RequestMapping("/hello.html")
    public String handleRequest(Model model) {
 
        logger.info("Returning index view");
        model.addAttribute("message", "HELLO!!!");
        return "hello";
    }
    
    @RequestMapping("/index.html")
    public String handleRequestIndex(Model model) {
 
        logger.info("Returning index view");
        model.addAttribute("message", "index!!!");
        return "index";
    }    
}
