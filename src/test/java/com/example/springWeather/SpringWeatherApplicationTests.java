package com.example.springWeather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

@SpringBootTest
class SpringWeatherApplicationTests {

	@Test
	void contextLoads() {
	}
	@BeforeAll
	static void beforeAll() {
		System.out.println("**--- Executed once before all test methods in this class ---**");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("**--- Executed before each test method in this class ---**");
	}

	@Test
	@DisplayName("Should figure out Square of Number")
	void testSquareFunction() {

		MathDemo test1 = new MathDemo();
		int result= test1.square(5);
		System.out.println("**--- About to Assert ---**");
		Assertions.assertEquals(5*5, result);
		System.out.println("**--- After Assert Square---**");
	}

	@Test
	@DisplayName("Should figure out Sum of Numbers")
	void testAddFunction() {

		System.out.println("**--- Executed before each test method in this class ---**");
	}


	@AfterEach
	void afterEach() {
		System.out.println("**--- Executed after each test method in this class ---**");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("**--- Executed once after all test methods in this class ---**");
	}
}
