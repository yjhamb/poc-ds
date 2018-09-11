package com.apple.ist.poc.ds;

public class BinarySearchTree {

	private class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	Node root = null;

	public Node getRoot() {
		return root;
	}

	public void insert(Node parent, int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		if (data <= parent.data) {
			if (parent.left != null) {
				insert(parent.left, data);
			} else {
				Node child = new Node(data);
				parent.left = child;
			}
		} else {
			if (parent.right != null) {
				insert(parent.right, data);
			} else {
				Node child = new Node(data);
				parent.right = child;
			}
		}
	}

	public void insertChild(int data) {
		Node y = null;
		Node x = root;
		while (x != null) {
			y = x;
			if (data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		if (y == null) {
			root = new Node(data);
		} else {
			if (data < y.data) {
				y.left = new Node(data);
			} else {
				y.right = new Node(data);
			}
		}
	}

	public void delete(int data) {
		Node node = root;
		Node parent = null;
		while (node != null) {
			if (data == node.data) {
				break;
			} else if (data < node.data) {
				parent = node;
				node = node.left;
			} else {
				parent = node;
				node = node.right;
			}
		}
		if (node != null) {
			if (node.left == null && node.right == null) {
				if (parent.left == node) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (node.left != null) {
				if (parent.left == node) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			} else if (node.right != null) {
				if (parent.left == node) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			} else {
				// find child with no left node and substitute
			}
		}
	}

	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.println(node.data);
			traverseInOrder(node.right);
		}
	}

	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.println(node.data);
			traverseInOrder(node.left);
			traverseInOrder(node.right);
		}
	}

	public void traversePostOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			traverseInOrder(node.right);
			System.out.println(node.data);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree intTree = new BinarySearchTree();
		int arr[] = { 4, 15, 22, 1, 9, 6, 23 };
		for (int i : arr) {
			intTree.insertChild(i);
		}
		// intTree.traverseInOrder(intTree.getRoot());
		intTree.traversePreOrder(intTree.getRoot());
		// intTree.traversePostOrder(intTree.getRoot());
	}

}
