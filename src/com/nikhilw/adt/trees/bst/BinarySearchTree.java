package com.nikhilw.adt.trees.bst;

/**
 * TODO Auto-generated type comment.
 *
 * @author nikhil
 */
public class BinarySearchTree {
	private final BinaryTreeNode root;

	public BinarySearchTree(int data) {
		root = new BinaryTreeNode(data);
	}

	public BinaryTreeNode insert(BinaryTreeNode node, int data) {
		if (node == null) { // Ex: When you reached a leaf in your previous recursive call
			return new BinaryTreeNode(data);
		}

		if (data < node.getData()) {
			node.setLeft(insert(node.getLeft(), data));
		} else {
			node.setRight(insert(node.getRight(), data));
		}

		return node;
	}

	public void inOrder(BinaryTreeNode node) {
		if (node != null) {
			inOrder(node.getLeft());
			System.out.println(node.getData());
			inOrder(node.getRight());
		}
	}

	public void descOrder(BinaryTreeNode node) {
		if (node != null) {
			descOrder(node.getRight());
			System.out.println(node.getData());
			descOrder(node.getLeft());
		}
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

}
