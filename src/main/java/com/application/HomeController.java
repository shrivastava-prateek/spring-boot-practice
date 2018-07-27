package com.application;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home-controller")
public class HomeController {
 
    @RequestMapping("/")
    public void viewHome() {
        
    	System.out.println("Hit");
    }
    
    
    @RequestMapping("/")
    public List<String> returnList() {
        
     return null;
    }
}