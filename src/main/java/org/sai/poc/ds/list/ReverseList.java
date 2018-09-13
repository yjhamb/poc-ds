package org.sai.poc.ds.list;

public class ReverseList<T> {

	Node<T> head;

	public void add(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> newNode = new Node<T>(data);
			newNode.next = head;
			head = newNode;
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			Node<?> temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	public void printReverse(Node<T> node) {
		if (node == null) {
			node = head;
		}
		if (node.next != null) {
			printReverse(node.next);
		}
		System.out.println(node.data);
	}

	public Node<T> reverseByGroup(Node<T> node, int groupSize) {
		int index = 0;
		Node<T> nextNode = null;
		Node<T> prevNode = null;
		Node<T> currNode = node;
		while (currNode != null && index < groupSize) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
			index++;
		}
		if (nextNode != null) {
			node.next = reverseByGroup(nextNode, groupSize);
		}
		return prevNode;
	}

	public void reverse(Node<T> node, Node<T> previous) {
		if (node == null) {
			node = head;
		}
		if (node.next != null) {
			reverse(node.next, node);
		} else {
			node.next = previous;
			previous.next = null;
		}
	}

	private class Node<T> {
		private T data;
		private Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		ReverseList<Integer> sll = new ReverseList<>();
		for (int i = 1; i <= 10; i++) {
			sll.add(i * 10);
		}
		// sll.print();
		sll.head = sll.reverseByGroup(sll.head, 5);
		sll.print();
	}

}
