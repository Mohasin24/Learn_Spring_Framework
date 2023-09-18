package com.springcore;
/*
@Qualifier annotation have higher preference than the @primary so if we use both at same time then bean with
@Qualifier will be invoked
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
