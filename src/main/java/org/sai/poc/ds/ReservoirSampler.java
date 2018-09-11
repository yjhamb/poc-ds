package com.apple.ist.poc.ds;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ReservoirSampler {

	private static class LL<T> {
		private Node<T> head;
		private Node<T> tail;

		public void add(T data) {
			if (head == null) {
				head = new Node<T>(data);
				tail = head;
			} else {
				tail.next = new Node<T>(data);
				tail = tail.next;
			}
		}

		private class Node<T> {
			private T data;
			private Node<T> next;

			Node(T data) {
				this.data = data;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3, 5, 6, 9, 2, 4, 7, 8, 0));

		System.out.println("Random #: " + getRandom(list));
	}

	private static Integer getRandom(LinkedList<Integer> LL) {
		if (LL == null) {
			return null;
		}
		int count = 0;
		Integer randomValue = LL.getFirst();
		Random rand = new Random();
		Iterator<Integer> iter = LL.iterator();
		while (iter.hasNext()) {
			Integer value = iter.next();
			count++;
			int randomIndex = rand.nextInt(count);
			if (randomIndex == 0) {
				randomValue = value;
			}
		}
		return randomValue;
	}

}
