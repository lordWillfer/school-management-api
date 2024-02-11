package org.willfer.schoolmanagementapi.infra.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenAPIDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("School Management API")
                        .description("Rest API of the School Management application. It contains CRUD functionalities for teachers and students, as well as register and unregister a subject.")
                        .contact(new Contact()
                                .name("Developer: Williams Fernández")
                                .url("https://github.com/lordWillfer")));
    }
}