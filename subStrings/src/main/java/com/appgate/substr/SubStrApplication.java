package com.appgate.substr;

import com.appgate.substr.definition.SubStrDefinition;
import com.appgate.substr.main.SubStrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubStrApplication implements CommandLineRunner {

    @Autowired
    private SubStrDefinition subStrDefinition;

    public static void main(String[] args) {
        SpringApplication.run(SubStrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        subStrDefinition.execute("babgbag", "bag");
    }
}
