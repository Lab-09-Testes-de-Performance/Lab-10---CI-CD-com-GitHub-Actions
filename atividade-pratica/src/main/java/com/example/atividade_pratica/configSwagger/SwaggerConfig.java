<<<<<<< HEAD
package com.example.atividade_pratica.configSwagger;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Produtos")
                        .description("Documentação da API de gerenciamento de produtos")
                        .version("1.0"));
    }
=======
package com.example.atividade_pratica.configSwagger;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Produtos")
                        .description("Documentação da API de gerenciamento de produtos")
                        .version("1.0"));
    }
>>>>>>> 844bd8c (Atualiza configuracao CI-CD)
}