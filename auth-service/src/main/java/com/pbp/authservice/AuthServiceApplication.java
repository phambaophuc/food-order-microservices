package com.pbp.authservice;

import com.pbp.authservice.constant.AppConstant;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "Auth API", version = AppConstant.SPRINGDOC_VERSION, description = "Documentation Auth API v1.0"),
		servers = @Server(url = AppConstant.SERVER_GATEWAY_AUTH_URL)
)
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
