package com.example.testinternshipt1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTestInternshipT1Application {

    public static void main(String[] args) {
        SpringApplication.from(TestInternshipT1Application::main).with(TestTestInternshipT1Application.class).run(args);
    }

}
