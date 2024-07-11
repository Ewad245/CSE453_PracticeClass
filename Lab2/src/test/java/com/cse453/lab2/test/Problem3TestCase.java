package com.cse453.lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.cse453.lab2.problem3.Triangle;

class Problem3TestCase {

	@ParameterizedTest
	@MethodSource
	void triangleTest(double a, double b, double c, boolean expected) {
		boolean result = Triangle.isTriangle(a, b, c);
		assertEquals(expected, result);
	}

	private static Stream<Arguments> triangleTest() {
		return Stream.of(Arguments.of(2, 3, 5, false), Arguments.of(2, 4, 2, false), Arguments.of(10, 14, 16, true));
	}

}
