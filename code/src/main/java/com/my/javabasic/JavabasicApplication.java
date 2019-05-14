package com.my.javabasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JavabasicApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(JavabasicApplication.class, args);
    }

}
