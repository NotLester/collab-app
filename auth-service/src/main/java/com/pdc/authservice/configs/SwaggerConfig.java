package com.pdc.authservice.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:" + serverPort + "/api/v1");
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setName("Authentication Service Team");
        contact.setEmail("support@authservice.com");

        License mitLicense = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Authentication Service API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints for user authentication and token management.")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .components(new Components());
    }

}