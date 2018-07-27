package com.application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Address;
import com.bean.Person;

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
    
    @GetMapping("/getInteger")
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
    
    @GetMapping("/getMap")
    public Map<String,String> returnMap() {
        Map<String,String> map = new HashMap<>();
        map.put("firstName", "Prateek");
        map.put("LastName", "Shrivastava");
        return map;
    }
    
    @GetMapping("/getPersonMap")
    public Map<String,Person> returnPersonMap() {
        Map<String,Person> map = new HashMap<>();
        
        Address addr1 = new Address("Nagpur", "440022", "India");
        Address addr2 = new Address("Nagpur", "440011", "India");
        Person p1 = new Person("Prateek Shrivastava","12234567","Project Engineer",addr1);
        Person p2 = new Person("Nikhil Palekar","12234567","Project Engineer",addr2);
        map.put("Prateek", p1);
        map.put("Nikhil", p2);
        return map;
    }
    
}