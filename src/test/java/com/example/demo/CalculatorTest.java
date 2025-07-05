package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit tests for the {@link Calculator} class.
 * <p>
 * This test class uses JUnit 5 to verify the correctness of various arithmetic operations
 * implemented in the Calculator class, including addition, subtraction, multiplication,
 * division, and checking if a number is even.
 * </p>
 *
 * <ul>
 *   <li>Setup and teardown methods are provided to initialize and clean up resources before and after tests.</li>
 *   <li>Tests cover normal cases, edge cases (such as division by zero), and parameterized scenarios for even/odd checks.</li>
 *   <li>Disabled tests are included for features under development.</li>
 *   <li>Grouped assertions and null checks are demonstrated.</li>
 * </ul>
 *
 * <p>
 * The tests ensure that:
 * <ul>
 *   <li>Basic arithmetic operations return correct results for positive, negative, and zero values.</li>
 *   <li>Division by zero throws an {@link IllegalArgumentException} with the expected message.</li>
 *   <li>The {@code isEven} method correctly identifies even and odd numbers, including negative numbers and zero.</li>
 *   <li>Integer division truncates towards zero.</li>
 * </ul>
 * </p>
 *
 * @see Calculator
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    private Calculator calculator;

	@BeforeAll
	void setupAll() {
		System.out.println("Before all tests");
	}
	
	@BeforeEach
	void setUp() {
        calculator = new Calculator();
        System.out.println("Before each test");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("After each test");
	}
	
	@AfterAll
	void tearDownAll() {
		System.out.println("After all tests");
	}
	
	@Test
	void testAddition() {
		assertEquals(5, calculator.add(2, 3));
	}
	
    @Test
    void testSubtraction() {
        assertEquals(1, calculator.subtract(4, 3));
    }
	
	@Test
	void testMultiplication() {
		assertEquals(12, calculator.multiply(3, 4));		
	}
	
	@Test
	void testDivision() {
		assertEquals(2, calculator.divide(10, 5));
	}
	
    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
    
    @Test
    void testIsEvenTrue() {
        assertTrue(calculator.isEven(4));
    }

    @Test
    void testIsEvenFalse() {
        assertFalse(calculator.isEven(5));
    }

    @Test
    void testAssertAll() {
        assertAll("Grouped assertions",
                () -> assertEquals(5, calculator.add(2, 3)),
                () -> assertEquals(1, calculator.subtract(3, 2)),
                () -> assertEquals(6, calculator.multiply(2, 3))
        );
    }

    @Test
    void testAssertNotNull() {
        assertNotNull(calculator);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testIsEvenWithParameters(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, 0, 2, 100, -100})
    void testIsEvenWithNegativeAndZero(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -1, 1, 3, 99, -101})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(calculator.isEven(number));
    }

    @Test
    void testAdditionWithNegativeNumbers() {
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    void testSubtractionWithNegativeNumbers() {
        assertEquals(-5, calculator.subtract(-2, 3));
        assertEquals(1, calculator.subtract(-2, -3));
    }

    @Test
    void testMultiplicationWithZero() {
        assertEquals(0, calculator.multiply(0, 5));
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    void testMultiplicationWithNegativeNumbers() {
        assertEquals(-6, calculator.multiply(-2, 3));
        assertEquals(6, calculator.multiply(-2, -3));
    }

    @Test
    void testDivisionWithNegativeNumbers() {
        assertEquals(-2, calculator.divide(-6, 3));
        assertEquals(2, calculator.divide(-6, -3));
    }

    /**
     * Verifies that integer division truncates towards zero.
     */
    @Test
        void testDivisionResultIsTruncated() {
            assertEquals(2, calculator.divide(5, 2));
            assertEquals(-2, calculator.divide(-5, 2));
        }
    }
