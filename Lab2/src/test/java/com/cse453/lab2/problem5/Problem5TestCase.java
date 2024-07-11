package com.cse453.lab2.problem5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.cse453.lab2.problem2.RomantoInteger;
import com.cse453.lab2.problem5.Point;

class Problem5TestCase {

	static Point p1 = new Point(10, 20);
	static Point p2 = new Point(12, 16);
	static Point p3 = new Point(11,13);
	static Point p4 = new Point(20, 23);

	@Test
	void pointTest() {
		Point result1 = p1.add(new Point(3, 4));
		Point result2 = p1.sub(new Point(10, 11));
		assertAll(() -> {
			assertEquals(new Point(23, 24), result1);
			assertEquals(new Point(0, 9), result2);
		});
	}

	@Test
	void lineTest() {
		Line line = new Line(p1, p2);
		double result = line.getLength();
		boolean result2 = line.isSameLengthAs(new Line(p3,p4));
		assertAll(()-> {
			assertEquals(4.47213595499958, result);
			assertEquals(false, result2);
		});
		
	}
	
	@Test
	void vectorTest() {
		Vector2D vector = new Vector2D(p1, p2);
		Vector2D vector2 = new Vector2D(11, 15);
		int result1 = vector.dotProduct(vector2);
		boolean result2 = vector.isOrthogonalTo(vector2);
		assertAll(()-> {
			assertEquals(-22, result1);
			assertEquals(false, false);
		});
	}

}
