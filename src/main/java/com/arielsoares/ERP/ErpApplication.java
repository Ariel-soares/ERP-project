package com.arielsoares.ERP;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
info = @Info(
		title = "ERP application",
		description = "ERP application for business managemente",
		version = "v1",
		contact = @Contact(
				name = "Madan Reddy",
				email = "tutor@eazybytes.com",
				url = "https://www.eazybytes.com"
		),
		license = @License(
				name = "Apache 2.0",
				url = "https://www.eazybytes.com"
		)
),
externalDocs = @ExternalDocumentation(
		description =  "ERP REST API Documentation"
)
)
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
	}

}
