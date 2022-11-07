package com.te.springboot;

public class Calculator {
	// sum
	public int doSum(int a, int b, int c) {
		return a + b + c;
	}

	// product
	public int doProduct(int a, int b) {
		return a * b;
	}

	// compare
	public Boolean compareTwoNums(int a, int b) {
		return a == b;
	}
//
	public int doSub(int a, int b) {
		return a - b;
	}
}
