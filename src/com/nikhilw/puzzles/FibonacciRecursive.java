package com.nikhilw.puzzles;

import java.util.Arrays;

/**
 * @author nikhil
 */
public class FibonacciRecursive {

	public static int[] generateFibonacci(int n) {
		int[] fib = new int[n];

		for (int i = 0; i < n; i++) {
			fib[i] = fibonacciValue(i);
		}

		return fib;
	}

	private static int fibonacciValue(int num) {
		if (num < 2) { // Why do people compare num == 0 and num == 1 to return 0 and 1?
			return num;
		} else {
			return fibonacciValue(num - 1) + fibonacciValue(num - 2);
		}
	}

	public static void main(String[] args) {
		int tillNumber = 15;

		System.out.println(Arrays.toString(FibonacciRecursive.generateFibonacci(tillNumber)));

	}
}
