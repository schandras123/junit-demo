package com.example.demo;

public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract (int a, int b) {
		return a - b;
	}
	
	public int multiply (int a, int b) {
		return a * b;
	}
	
	public int divide (int a, int b) {
		if(b == 0) throw new IllegalArgumentException("Cannot devide by zero");
		return a / b;
	}
	
	public boolean isEven(int number) {
		return number % 2 == 0;
	}

}
