package com.losluminosos.medsystem.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class OpenApiConfiguration {
    @Bean
    public OpenAPI medSystemOpenApi() {
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("MedSystem API")
                        .description("MedSystem REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("ACME Learning Platform Wiki Documentation")
                        .url("https://acme-learning-platform.wiki.github.io/docs"));
        return openApi;
    }
}
