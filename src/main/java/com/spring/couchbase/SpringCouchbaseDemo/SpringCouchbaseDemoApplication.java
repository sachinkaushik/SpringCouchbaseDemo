package com.spring.couchbase.SpringCouchbaseDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringCouchbaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCouchbaseDemoApplication.class, args);

	}

}
