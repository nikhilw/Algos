package com.nikhilw.algorithms.sort;

import java.util.Arrays;

/**
 * Bubble Sort, un-optimized. Does not detect if the list is already sorted.
 * Avg case: O(n^2)
 * Worst case: O(n^2)
 * Auxiliary memory: 1
 * 
 * @author nikhil
 */
public class BubbleSort {
	public static int[] sort(int[] unsorted) {
		int n = unsorted.length;
		
		for (int pass = n; pass >= 0; pass--) { // Its 'bubbling', so start with the last element 
			
			//System.out.println(Arrays.toString(unsorted)); // Print intermediate state after each pass
			//System.out.println("pass: " + pass);
			
			for (int i = 0; i < pass-1; i++) { // Don't compare elements already bubbled.
				//System.out.println("i: " + i);
				if (unsorted[i] > unsorted[i+1]) {
					int tmp = unsorted[i];
					unsorted[i] = unsorted[i+1];
					unsorted[i+1] = tmp;
				}
			}
		}
		
		return unsorted;
	}
	
	public static void main(String[] args) {
//		int[] unsorted = {1, 4, 8, 5, 9, 3, 6, 2};
		int[] unsorted = {9, 8, 7, 6, 5, 4, 3, 2, 1}; // worst case
		
		System.out.println(Arrays.toString(BubbleSort.sort(unsorted)));
	}

}

//	// Loop with common variable names and order of comparison.
//for (int i = 0; i < n; i++) { // save on 1 pass, last element doesnt need comparing again.
//
//System.out.println(Arrays.toString(unsorted));
//System.out.println("pass: " + i);
//
//for (int j = 1; j < n; j++) { // dont compare elements already bubbled.
//	System.out.println("j: " + j);
//	
//	if (unsorted[j - 1] > unsorted[j]) {
//		int tmp = unsorted[j];
//		unsorted[j] = unsorted[j-1];
//		unsorted[j-1] = tmp;
//	}
//}
//}
