package com.example.gcpDeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
       //System.out.println("Hello Boot");
    }
    
    @RequestMapping(value="/testapp")
    public String testApp(){
    	return "Hi this is GCP App engine deployment";
    }
}