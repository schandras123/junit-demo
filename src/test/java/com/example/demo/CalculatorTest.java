package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {
	private Calculator calculator;

	@BeforeAll
	void setupAll() {
		System.out.println("Before all tests");
	}
	
	@BeforeEach
	void setUp() {
		calculator = new Calculator();
		System.err.println("Before each test");
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
	void testSubstraction() {
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

    @Disabled("Temporarily disabled test")
    @Test
    void testDisabledExample() {
        fail("This test is disabled");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testIsEvenWithParameters(int number) {
        assertTrue(calculator.isEven(number));
    }
}
