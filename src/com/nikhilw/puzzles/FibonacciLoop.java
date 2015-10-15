package com.nikhilw.puzzles;

import java.util.Arrays;

/**
 * @author nikhil
 */
public class FibonacciLoop {

	public static int[] generateFibonacci(int n) {
		int[] fib = new int[n];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i < n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}

		return fib;
	}

	public static void main(String[] args) {
		int tillNumber = 15;

		System.out.println(Arrays.toString(FibonacciLoop.generateFibonacci(tillNumber)));

	}
}
