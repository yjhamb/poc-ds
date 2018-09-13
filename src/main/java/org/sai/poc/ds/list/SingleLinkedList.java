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
	private Node tail;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void addFront(T data) {
		Node node = new Node(data);
		if (head != null) {
			node.next = head;
			tail = head;
			head = node;
		} else {
			head = node;
			tail = node;
		}
	}

	public void addEnd(T data, boolean cycle) {
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
			tail = node;
		} else {
			head = node;
			tail = node;
		}
		if (cycle) {
			tail.next = head;
		}
	}

	public void print() {
		Node node = head;
		while (node != tail) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}

	private boolean isCyclic() {
		Node forward = head;
		Node trail = head;
		do  {
			// take 2 steps
			for (int i = 0; i < 2; i++) {
				if (forward != null) {
					forward = forward.getNext();
				}
			}
			if (trail != null) {
				trail = trail.getNext();
			}
		} while (forward != trail);
		if (forward == null) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> llist = new SingleLinkedList<>();
		llist.addEnd(1, false);
		llist.addEnd(2, false);
		llist.addEnd(3, false);
		llist.addEnd(4, false);
		llist.addEnd(5, true);
		System.out.println(llist.isCyclic());
		
	}

}
