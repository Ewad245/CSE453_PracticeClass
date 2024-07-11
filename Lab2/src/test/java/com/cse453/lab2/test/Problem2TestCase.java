package com.cse453.lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.cse453.lab2.problem1.CircleRadius;
import com.cse453.lab2.problem2.RomantoInteger;

class Problem2TestCase {

	@ParameterizedTest
	@MethodSource
	void romanToIntegerTest(String input, int expected) {
		RomantoInteger testclass = new RomantoInteger();
		int result = testclass.convert(input);
		assertEquals(expected, result);
	}

	private static Stream<Arguments> romanToIntegerTest() {
		return Stream.of(Arguments.of("IIV", -1), Arguments.of("VII", 7), Arguments.of("XLV", 45),
				Arguments.of("LXXX", -1), Arguments.of("ML", 1050));
	}

}
