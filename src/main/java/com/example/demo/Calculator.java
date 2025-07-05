package com.example.demo;

/**
 * The {@code Calculator} class provides basic arithmetic operations such as addition,
 * subtraction, multiplication, and division, as well as a utility method to check if a number is even.
 * <p>
 * Example usage:
 * <pre>
 *     Calculator calc = new Calculator();
 *     int sum = calc.add(2, 3); // 5
 *     boolean isEven = calc.isEven(4); // true
 * </pre>
 * </p>
 *
 * <ul>
 *   <li>{@link #add(int, int)} - Adds two integers.</li>
 *   <li>{@link #subtract(int, int)} - Subtracts the second integer from the first.</li>
 *   <li>{@link #multiply(int, int)} - Multiplies two integers.</li>
 *   <li>{@link #divide(int, int)} - Divides the first integer by the second. Throws {@link IllegalArgumentException} if the divisor is zero.</li>
 *   <li>{@link #isEven(int)} - Checks if a number is even.</li>
 * </ul>
 *
 * @author Chandrasekhar Reddy Sammeta
 * @since 1.0
 */
public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		return a / b;
	}
	
	public boolean isEven(int number) {
		return number % 2 == 0;
	}

}
