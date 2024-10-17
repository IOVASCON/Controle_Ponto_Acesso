package com.dio.live.swagger;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("API de Controle de Ponto e Acesso")
                                                .version("1.0.0")
                                                .description("Documentação da API de Controle de Ponto e Acesso")
                                                .contact(new Contact()
                                                                .name("DIO")
                                                                .url("https://web.digitalinnovation.one")
                                                                .email("contato@digitalinnovationone.com.br")));
        }
}
