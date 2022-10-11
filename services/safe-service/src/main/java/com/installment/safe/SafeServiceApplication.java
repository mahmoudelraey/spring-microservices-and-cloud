package com.installment.safe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class SafeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeServiceApplication.class, args);
	}

}
