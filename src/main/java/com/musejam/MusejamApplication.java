package com.musejam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class MusejamApplication extends SpringBootServletInitializer {

        public static void main(String args[]){
            SpringApplication.run(MusejamApplication.class,args);
        }
}
