package com.vatit.technicalassessment.ToDoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListApplication {
    
    public static void main( String[] args ) {
        SpringApplication.run(ToDoListApplication.class ,args);
        ToDoList.addToDO(new com.vatit.technicalassessment.ToDoapi.controller.json.ToDo("Do some work" ,false));

    }
    
}
