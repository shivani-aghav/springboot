package com.te.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator c = new Calculator();
	/*
	 * @Autowired private Calculator c;
	 */

//	@Test
//	void contextLoads() {
//
//	}


	
	// @Disabled if we write it before the method it will not going to test
	@Test
	void  testSum() {
		int expectedResult= 15;
		int actualResult = c.doSum(5, 5, 5);
		assertThat(actualResult).isEqualTo(expectedResult);
		
		
		
		
	}

	@Test
	@Disabled
	void testProduct() {
		// this is my excepted
		int expectedResult = 10;
		// actual will come
		int actualResult = c.doProduct(5, 2);
		assertThat(actualResult).isEqualTo(expectedResult);

	}

	
	@Test
	void testCompare() {
		boolean expectedResult = true;
		boolean actualResult = c.compareTwoNums(12, 12);
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
