package com.javainuse;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootHelloWorldApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootHelloWorldApplication.class, args);
    }
    
    @RequestMapping(value="/kubernetestest")
    public String testApp(){
    	return "Hi there, this is for K8s";
    }
  
}
