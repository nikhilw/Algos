package com.nikhilw.algorithms.sort;

import com.nikhilw.adt.trees.bst.BinarySearchTree;

/**
 * Avg case: O(n log n)
 * Worst case: O(n^2)
 * Auxiliary memory: O(n)
 * Can be implemented as stable sort.
 *
 * @author nikhil
 */
public class TreeSort {
	public static void sortDescending(int[] unsorted) {
		BinarySearchTree bst = buildTree(unsorted);

		bst.descOrder(bst.getRoot());
	}

	public static void sortAscending(int[] unsorted) {
		BinarySearchTree bst = buildTree(unsorted);

		bst.inOrder(bst.getRoot());
	}

	private static BinarySearchTree buildTree(int[] unsorted) {
		BinarySearchTree bst = new BinarySearchTree(unsorted[0]);

		for (int i = 1; i < unsorted.length; i++) {
			bst.insert(bst.getRoot(), unsorted[i]);
		}

		return bst;
	}

	public static void main(String[] args) {
		int[] unsorted = {1, 4, 8, 5, 9, 3, 6, 2};

		TreeSort.sortAscending(unsorted);
		System.out.println("\n********\n");
		TreeSort.sortDescending(unsorted);

	}
}
