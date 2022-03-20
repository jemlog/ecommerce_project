package project.finaltoyproject.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion)
    {
        Info info = new Info().title("E-Commerce project API").version(appVersion)
                .description("Spring Boot를 이용한 이커머스 웹 애플리케이션 API입니다")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact().name("jemin"))
                .license(new License().name("by jemin"));

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER).name("Authorization");
        SecurityRequirement schemaRequirement = new SecurityRequirement().addList("bearerAuth");


        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth",securityScheme))
                .security(Arrays.asList(schemaRequirement))
                .info(info);
    }
}
