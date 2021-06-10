package com.appgate.substr;

import com.appgate.substr.definition.SubStrDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubStrApplication {

    @Autowired
    private SubStrDefinition subStrDefinition;

    public static void main(String[] args) {
        SpringApplication.run(SubStrApplication.class, args);
    }

 }
