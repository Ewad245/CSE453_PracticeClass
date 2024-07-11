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

class Problem1TestCase {

	@ParameterizedTest
	@MethodSource
	void circleRadiusTest(String input, double expected) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		CircleRadius.main(new String[0]);
		String result = outContent.toString();
		String[] re = result.split(" ");
		assertEquals(expected, Double.parseDouble(re[3]));
	}

	private static Stream<Arguments> circleRadiusTest() {
		return Stream.of(Arguments.of("4", 25.1), Arguments.of("0", 0), Arguments.of("-10", -1),
				Arguments.of("1000000000", 6.3), Arguments.of("f", -1));
	}

}
