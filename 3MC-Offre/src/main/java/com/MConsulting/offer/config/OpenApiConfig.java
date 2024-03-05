package com.MConsulting.offer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
   
    private final String devUrl = "http://localhost:8080";

       @Bean
    public OpenAPI openApi() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server url for development environment");


        Contact contact = new Contact();
        contact.setEmail("patrick.fouotsop@facsciences-uy1.cm");
        contact.setName("Patrick Fouotsop");
        contact.setUrl("https://fouotsop.github.io/portfolio");

        License mitLicense = new License().name("MIT License").url("https://opensource.org/licenses/MIT");
        Info info = new Info()
                .title("3MC digital consulting Post management module")
                .description("This module is responsible for managing posts created by clients of 3m digital consulting, such as project offers ")
                .version("1.0.0")
                .contact(contact)
                .license(mitLicense);

        return new OpenAPI().info(info)
                .addServersItem(devServer);
              
    }
}
