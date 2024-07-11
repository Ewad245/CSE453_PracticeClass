package com.cse453.lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.cse453.lab2.problem3.Triangle;
import com.cse453.lab2.problem4.Fibonacci;

class Problem4TestCase {

	@ParameterizedTest
	@MethodSource
	void fibonacciTest(int input, int expected) {
		Fibonacci testclass = new Fibonacci();
		int result = testclass.fib(input);
		assertEquals(expected, result);
	}

	private static Stream<Arguments> fibonacciTest() {
		return Stream.of(Arguments.of(0, 0), Arguments.of(2, 1), Arguments.of(19, 4181));
	}

}
