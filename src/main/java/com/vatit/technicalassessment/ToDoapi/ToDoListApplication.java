package com.vatit.technicalassessment.ToDoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@springfox.documentation.swagger2.annotations.EnableSwagger2

@io.swagger.annotations.SwaggerDefinition(schemes = io.swagger.annotations.SwaggerDefinition.Scheme.HTTP)

public class ToDoListApplication {
    
    //Main Method which starts the entire program
    public static void main( String[] args ) {
        SpringApplication.run(ToDoListApplication.class ,args);
        ToDoList.addToDO(new com.vatit.technicalassessment.ToDoapi.controller.json.ToDo("Do some work" ,false));
    }
    //Configurations for the Swagger UI page.
    @org.springframework.context.annotation.Bean
    public springfox.documentation.spring.web.plugins.Docket SwaggerConfig( ) {
        return new springfox.documentation.spring.web.plugins.Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .select()
          .paths(springfox.documentation.builders.PathSelectors.ant("/todos/*"))
          .apis(springfox.documentation.builders.RequestHandlerSelectors.basePackage("com.vatit.technicalassessment"))
          .build()
          .apiInfo(BuildApiDetails());
    }
    
    //App Information that will be displayed at the top of the Swagger UI Page
    private springfox.documentation.service.ApiInfo BuildApiDetails( ) {
        return new springfox.documentation.service.ApiInfo(
          "ToDo API" ,
          "Test ToDo APIs" ,
          "1.0" ,
          "Free to use" ,
          new springfox.documentation.service.Contact("Dewald Havenga" ,"" ,"Dewald.havenga@gmail.com") ,
          "API License" ,
          "" ,
          java.util.Collections.emptyList()
        );
    }
    
}
