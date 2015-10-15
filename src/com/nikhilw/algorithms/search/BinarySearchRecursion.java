package com.nikhilw.algorithms.search;

import java.util.Arrays;

import com.nikhilw.algorithms.sort.SelectionSort;

/**
 * Binary search [O(log n)] works only with sorted lists, you cant judge which direction to
 * traverse in unless the elements are sorted.
 *
 * Either sort the array, but then the complexity of the sorting used gets added
 * to the search function.
 *
 * Or just use an unsorted linear search. [O(n)]
 *
 * @author nikhil
 */
public class BinarySearchRecursion {

	public static int search(int[] collection, int data) {
		int n = collection.length,
			low = 0,
			high = n-1;

		return searchRecursive(collection, low, high, data);

	}

	private static int searchRecursive(int[] collection, int low, int high, int data) {
		int mid = low + ((high-low)/2);

		if (mid < low || mid > high) {
			return -1; // Have to check the bound here.
		}

		if (collection[mid] == data) {
			return mid;
		} else if (data < collection[mid]) {
			return searchRecursive(collection, low, mid -1, data);
		} else {
			return searchRecursive(collection, mid + 1, high, data);
		}
	}

	public static void main(String[] args) {
		int[] collection = {9, 8, 7, 6, 5, 4, 3, 2};
		int dataToFind = 9;

		collection = SelectionSort.sort(collection); // Shouldn't it be treesort? //TODO update the TreeSort implementation.
		System.out.println("After sorting: " + Arrays.toString(collection));

		System.out.println("Data (" + dataToFind + ") is at index: " + BinarySearchRecursion.search(collection, dataToFind));
	}
}
