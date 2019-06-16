package com.retail.app;

import com.retail.app.model.Product;
import com.retail.app.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebSecurity
@Configuration
@EnableSwagger2
public class RetailAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100"));
			productService.save(new Product(2L, "Game Console", 200.00, "http://placehold.it/200x100"));
			productService.save(new Product(3L, "Sofa", 100.00, "http://placehold.it/200x100"));
			productService.save(new Product(4L, "Icecream", 5.00, "http://placehold.it/200x100"));
			productService.save(new Product(5L, "Beer", 3.00, "http://placehold.it/200x100"));
			productService.save(new Product(6L, "Phone", 500.00, "http://placehold.it/200x100"));
			productService.save(new Product(7L, "Watch", 30.00, "http://placehold.it/200x100"));
		};
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}
