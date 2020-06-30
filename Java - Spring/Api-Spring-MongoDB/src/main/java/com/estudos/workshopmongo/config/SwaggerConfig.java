package com.estudos.workshopmongo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.estudos.workshopmongo.resources"))
          .paths(PathSelectors.any())
          .build()
          .useDefaultResponseMessages(false)
          .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
          .globalResponseMessage(RequestMethod.POST, responseMessageForPOST())
          .globalResponseMessage(RequestMethod.PUT, responseMessageForPOST())
          .globalResponseMessage(RequestMethod.DELETE, responseMessageForDELETE())
          .apiInfo(apiInfo());
    }
    
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Rest Spring Boot - MongoDB")
                .description("Uma API Rest feita com Spring Boot que Utiliza MongoDB")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Lucas Veloso", "https://www.linkedin.com/in/veloso-lucas/", "l.brando815@gmail.com"))
                .build();
    }
    
    
    private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                .code(200)
                .message("Operation Performed Successfully")
                .build());
            
            add(new ResponseMessageBuilder()
                    .code(404)
                    .message("Not Found")
                    .build());
        }};
    }
    
    private List<ResponseMessage> responseMessageForPOST()
    {
        return new ArrayList<ResponseMessage>() {{
            
            add(new ResponseMessageBuilder()
                    .code(201)
                    .message("Created")
                    .build());   
            
            add(new ResponseMessageBuilder()
                    .code(204)
                    .message("No Content")
                    .build());
        }};
    }
    
    private List<ResponseMessage> responseMessageForDELETE()
    {
        return new ArrayList<ResponseMessage>() {{
            
            add(new ResponseMessageBuilder()
                .code(204)
                .message("No Content")
                .build());
        }};
    }
}
