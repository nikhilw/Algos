package com.nikhilw.algorithms.sort;

import java.util.Arrays;

/**
 * Avg case: O(n^2)
 * Worst case: O(n^2)
 * Auxiliary memory: 1
 *
 * @author nikhil
 */
public class SelectionSort {
	public static int[] sort(int[] unsorted) {
		int n = unsorted.length,
			minIndex, temp;

		for (int i = 0; i < n-1; i++) {
			minIndex = i;
			for (int j = i + 1; j < n; j++) { // All till index i are sorted, so being with next.
				if (unsorted[j] < unsorted[minIndex]) {
					minIndex = j; // This is the new minimum value index
				}
			}

			// Now set value of new minimum value index at i.
			temp = unsorted[minIndex];
			unsorted[minIndex] = unsorted[i];
			unsorted[i] = temp;
		}

		return unsorted;
	}

	public static void main(String[] args) {

//		int[] unsorted = {1, 4, 8, 5, 9, 3, 6, 2};
		int[] unsorted = {9, 8, 7, 6, 5, 4, 3, 2, 1}; // worst case

		System.out.println(Arrays.toString(SelectionSort.sort(unsorted)));
	}
}
