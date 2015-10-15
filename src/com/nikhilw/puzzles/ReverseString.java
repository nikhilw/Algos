package com.nikhilw.puzzles;

public class ReverseString {
	
	public static void main(String[] args) {
		
		String orig = "This is a test String";
		
		System.out.println(reverseWithCharArray(orig));
		System.out.println(reverseByRecursion(orig));
		
		// This is certainly not the expected answer in an interview, although it is during actual work!
		System.out.println(reverseUsingAPI(orig));
	}
	
	private static String reverseWithCharArray(String orig) {
		StringBuilder reverse = new StringBuilder();
		char[] strChars = orig.toCharArray();
		
		for (int i = strChars.length - 1; i >= 0; i--) { // Reverse loop
			reverse.append(strChars[i]);
		}
		
		return reverse.toString();
	}
	
	private static String reverseByRecursion(String orig) {
		if (orig.length() < 2) {
			return orig;
		}
		
		return reverseByRecursion(orig.substring(1)) + orig.charAt(0);
	}
	
	private static String reverseUsingAPI(String orig) {
		return new StringBuilder(orig).reverse().toString();
	}
}
