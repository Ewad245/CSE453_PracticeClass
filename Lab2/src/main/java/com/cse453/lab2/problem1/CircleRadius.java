package com.cse453.lab2.problem1;

import java.util.Scanner;

public class CircleRadius {

	public static void main(String args[]) {
		double r, area, circum;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the radius ");
		r = reader.nextDouble();
		if (r >= 0) {
			circum = 2 * Math.PI * r;
			System.out.println(circum);
			reader.close();
		} else
			System.out.println(-1);
	}

}
