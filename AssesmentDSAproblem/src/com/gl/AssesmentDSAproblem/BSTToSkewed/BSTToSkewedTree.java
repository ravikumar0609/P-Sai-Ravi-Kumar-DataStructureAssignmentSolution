package com.gl.AssesmentDSAproblem.BSTToSkewed;

/**
 * @author psairavikumar
 * @version 1.0.0
 * @implSpec Binary Search tree to Right Skewed Tree
 * @implNote used Doubly linked list for implementing BST tree
 */

public class BSTToSkewedTree {
	public Node node;
	public Node prevNode = null;
	public Node headNode = null;

	// class to create new node
	static class Node {
		int value;
		Node left, right;

		// constructor to initialize node by default left and right points to null
		Node(int data) {
			value = data;
		}
	}

	// Traverse and Create Right Skeweed tree
	public void createRightSkewedTree(Node root) {
		// base check if root is null it returns
		if (root == null) {
			return;
		}
		// recursion to Traverse entire left subtree
		createRightSkewedTree(root.left);
		Node rightNode = root.right;
		// base check if head node is null assign root as head node
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		// if head node is not null, make a right skewed tree with left as null
		else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		// recursion to Traverse entire right subtree
		createRightSkewedTree(rightNode);
	}

	// traversing right skewed tree and print the tree
	public void traverseRightSkewed(Node root) {
		// base check
		if (root == null) {
			return;
		}
		System.out.print(root.value + " -> ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		BSTToSkewedTree tree = new BSTToSkewedTree();
		// Create binary search tree with manual input
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);
		// traverse tree and create Right Skewed Tree
		tree.createRightSkewedTree(tree.node);
		System.out.print("Rightly Skewed Tree is as following: ");
		// Print Right Skewed tree.
		tree.traverseRightSkewed(tree.headNode);
	}
}
