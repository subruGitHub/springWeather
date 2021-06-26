package com.example.springWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeatherApplication.class, args);
	}


	@RequestMapping("/")
	public String goToHomePage () {
		return "<h1>This is the Home page</h1>";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s! Welcome to the Weather World", name);
	}


	@GetMapping("/square")
	public String helloSquare(@RequestParam(value = "num", defaultValue = "0") int num) {


		MathDemo mat1 = new MathDemo();
		int result = mat1.square(num);

		return String.format("Square of %s!", num + " is " + result);
	}

}
