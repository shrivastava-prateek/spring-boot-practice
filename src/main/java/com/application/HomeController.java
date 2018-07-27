package com.application;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home-controller")
public class HomeController {
 
    @RequestMapping("/")
    public void viewHome() {
        
    	System.out.println("Hit");
    }
    
    @GetMapping("/getString")
    public String returnString() {
        return "My name is Prateek";
    }
    
    @GetMapping("/getIntger")
    public Integer returnInteger() {
        return 99999999;
    }
    
    
    @GetMapping("/getList")
    public List<String> returnList() {
        List<String> strList = new ArrayList<>();
        strList.add("Prateek");
        strList.add("Shrivastava");
        return strList;
    }
}