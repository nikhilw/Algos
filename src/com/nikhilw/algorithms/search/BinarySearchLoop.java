package com.nikhilw.algorithms.search;

import java.util.Arrays;

import com.nikhilw.algorithms.sort.SelectionSort;

/**
 * Binary search works only with sorted lists, you cant judge which direction to
 * traverse in unless the elements are sorted.
 *
 * Either sort the array, but then the complexity of the sorting used gets added
 * to the search function.
 *
 * Or just use an unsorted linear search. [O(n)]
 *
 * @author nikhil
 */
public class BinarySearchLoop {

	public static int search(int[] collection, int data) {
		int n = collection.length;

		int low = 0,
			high = n-1,
			mid;

		while (low <= high) {
			mid = low + ((high-low)/2);

			if (collection[mid] == data) {
				return mid;
			}

			if (data < collection[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] collection = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int dataToFind = 4;

		collection = SelectionSort.sort(collection); // Shouldn't it be treesort? //TODO update the TreeSort implementation.
		System.out.println("After sorting: " + Arrays.toString(collection));

		System.out.println("Data (" + dataToFind + ") is at index: " + BinarySearchLoop.search(collection, dataToFind));
	}
}
