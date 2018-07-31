package com.application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Address;
import com.bean.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/home-controller")
public class HomeController {
 
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    @RequestMapping("/")
    public void viewHome() {
        
    	System.out.println("Hit");
    }
    
    @GetMapping("/getString")
    public String returnString() {
        return "My name is Prateek";
    }
    
    @PostMapping("/postString")
    public void receiveString(@RequestBody String s) {
    	logger.info(s);
    }
    
    
    
    @GetMapping("/getInteger")
    public Integer returnInteger() {
        return 99999999;
    }
    
    @PostMapping("/postInteger")
    public void receiveInteger(@RequestBody int a) {
    	logger.info(a+"");
    }
    
   
    
    @GetMapping("/getIntArray")
    public int[] returnIntArray() {
        return new int[] {1,2,3,4,5,6,7,8,9,0};
    }
    
    @PostMapping("/postIntArray")
    public void receiveIntArray(@RequestBody int[] array) {
    	for(int i:array) logger.info(i+"");
    }
    
    
    @GetMapping("/getList")
    public List<String> returnList() {
        List<String> strList = new ArrayList<>();
        strList.add("Prateek");
        strList.add("Shrivastava");
        return strList;
    }
    
    @PostMapping("/postList")
    public void receiveList(@RequestBody List<String> list) {
    	 logger.info(list.toString());
    }
    
    
    
    @GetMapping("/getMap")
    public Map<String,String> returnMap() {
        Map<String,String> map = new HashMap<>();
        map.put("firstName", "Prateek");
        map.put("LastName", "Shrivastava");
        return map;
    }
    
    @PostMapping("/postMap")
    public void receiveMap(@RequestBody Map<String,String> map) {
    	 logger.info(map.toString());
    }
    
    
    @GetMapping("/getPerson")
    public Person returnPerson() {
        Address addr1 = new Address("Nagpur", "440022", "India");
       
        Person p1 = new Person("Prateek Shrivastava","12234567","Project Engineer",addr1);
      
        return p1;
    }
    
    @PostMapping("/postPerson")
    public void receivePerson(@RequestBody Person person) {
      
       logger.info(person.toString());       
       logger.info(person.getName());
        
    }
    
    @GetMapping("/getParameters/{name}")
    public void receiveParameters(@RequestParam(value = "firstParam", defaultValue="sample Vaue") String param,@PathVariable(value="name") String name) {
    	logger.info("Received Request Param: "+param + ", Path Param: "+name);
        Address addr1 = new Address("Nagpur", "440022", "India");
       
        Person p1 = new Person("Prateek Shrivastava","12234567","Project Engineer",addr1);
      
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
    

    @PostMapping("/postPersonMap")
    public void receivePersonMap(@RequestBody Map<String,Person> map) {
        
    	 logger.info(map.toString());
    }
    
    
    //Creating a custom JSON object using object mapper, but we could have used hashmap and returned it..
    @GetMapping("/getCustomJSON")
    public String returnPersonJSON() {
      
        ObjectMapper objMap = new ObjectMapper();
        
        ObjectNode objNode = objMap.createObjectNode();
        
        objNode.put("Name", "Prateek");
        objNode.put("lastName", "Shrivastava");
        return objNode.toString();
        
    }
    
    
    @PostMapping("/postCustomJSON")
    public void receiveCustomJSON(@RequestBody String input) {
      
       logger.info(input);
       
       JsonParser parser = JsonParserFactory.getJsonParser();
       Map<String,Object> map = parser.parseMap(input);
       
       logger.info(map.get("key").toString());
        
    }
    
    @GetMapping("/returnCustomStatusAndHeaders")
    public ResponseEntity sendCustomStatusAndHeaders() {
    	  Address addr1 = new Address("Nagpur", "440022", "India");
          
          Person p1 = new Person("Prateek Shrivastava","12234567","Project Engineer",addr1);
		//return ResponseEntity.ok(p1);
          
          //return ResponseEntity.accepted().body(p1);
          //return ResponseEntity.badRequest().body(p1);
          //return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
          HttpHeaders headers = new HttpHeaders();
          headers.add("SampleHeader1", "value1");
          headers.add("SampleHeader2", "value2");
          headers.add("SampleHeader3", "value3");
          headers.add("SampleHeader4", "value4");
          headers.add("SampleHeader1", "value5");
          //return ResponseEntity.noContent().header("CustomHeader", "value").build();
          //return ResponseEntity.noContent().headers(headers).build();
          
          //Creating Custom JSON
          Map<String,String> map = new HashMap<String,String>();
          map.put("JsonKey1", "value1");
          map.put("JsonKey2", "value2");
          map.put("JsonKey3", "value3");
          map.put("JsonKey4", "value4");
          map.put("JsonKey5", "value5");
          //return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(map);
          return ResponseEntity.ok().headers(headers).body(map);
    }
    
    
    @PostMapping("/uploadFile")
    public ResponseEntity receiveFile(@RequestParam(value="file") MultipartFile[] files, @RequestParam(value="file") MultipartFile file, 
    		@RequestParam(value = "queryParam") String queryParam, 
    		@RequestParam(value="formParam") String formParam) throws IOException {
    
    	
    	// All the form data with key as a 'file' will be available inside the array, hence can be used for uploading multiple files
    for(MultipartFile f: files) {
    	  logger.info("multipart array: "+f.getOriginalFilename());
      }
       logger.info(file.getOriginalFilename());
       logger.info("Query Param: "+ queryParam + ", Form Param: "+ formParam);
       
       logger.info(file.getSize()+"");
       
       logger.info(file.getBytes().length+"");
       
       return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getOriginalFilename()+"\"").body(file.getBytes());
        
    }
 
    
    @GetMapping("/downloadFile")
    public ResponseEntity returnFile() throws FileNotFoundException {
    
    	File file = new File("abc.jpg");
    	
       logger.info(file.exists()+"");
       logger.info(file.getAbsolutePath()+"");
       logger.info(file.getPath()+"");
       
       InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
     //  Resource resource = new UrlResource("file://"+file.getPath());
       
       logger.info(resource.exists()+"");
       
       return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getName()+"\"").body(resource);
        
    }
    
    
}