package org.pbp.tableservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "Review API", version = "${springdoc.version}", description = "Documentation Review API v1.0")
)
public class TableServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TableServiceApplication.class, args);
    }

}
