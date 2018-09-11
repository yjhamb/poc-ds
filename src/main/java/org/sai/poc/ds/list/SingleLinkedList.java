package org.sai.poc.ds.list;

public class SingleLinkedList<T> {

	private class Node {
		private T data;
		private Node next;

		private Node(T data) {
			this.data = data;
			this.next = null;
		}

		private T getData() {
			return this.data;
		}

		private Node getNext() {
			return this.next;
		}
	}

	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void add(T data) {
		Node node = new Node(data);
		if (head != null) {
			node.next = head;
			head = node;
		} else {
			head = node;
		}
	}

	public void print() {
		Node node = head;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}

	public void printReverse(Node node) {
		if (node.getNext() != null) {
			printReverse(node.getNext());
		}
		System.out.println(node.getData());
	}

	public void reverse() {
		Node current = head;
		Node previous = null;
		Node forward = null;
		while (current != null) {
			forward = current.next;
			current.next = previous;
			previous = current;
			current = forward;
		}
		head = previous;
	}

	public Node reverseByGroup(Node node, int n) {
		Node current = node;
		Node previous = null;
		Node forward = null;
		int size = 0;
		while (current != null && size < n) {
			forward = current.next;
			current.next = previous;
			previous = current;
			current = forward;
			size++;
		}
		if (forward != null) {
			node.next = reverseByGroup(forward, n);
		}
		return previous;
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> llist = new SingleLinkedList<>();
		llist.add(1);
		llist.add(2);
		llist.add(3);
		llist.add(4);
		llist.add(5);
		llist.print();
		// llist.printReverse(llist.getHead());
		llist.setHead(llist.reverseByGroup(llist.getHead(), 2));
		llist.print();
	}

}
