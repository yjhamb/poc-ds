/**
 * Basic implementation of a Min-Max Heap.
 */
package org.sai.poc.ds.tree;

public class Heap {
	private static final int SIZE = 100;
	private int[] data = new int[SIZE];
	private int pos = 0;

	private int getParent(int index) {
		return (index - 1) / 2;
	}

	private int getLeftChild(int index) {
		return index * 2 + 1;
	}

	private int getRightChild(int index) {
		return index * 2 + 2;
	}

	private void minHeapify(int index) {
		int left = getLeftChild(index);
		int right = getRightChild(index);
		int smallest = index;
		
		if (left < pos && data[left] < data[index]) {
			smallest = left;
		}
		
		if (right < pos && data[right] < data[smallest]) {
			smallest = right;
		}
		
		if (smallest != index) {
			// swap
			int temp = data[smallest];
			data[smallest] = data[index];
			data[index] = temp;
			// call recursively
			minHeapify(smallest);
		}
	}

	public void add(int value) {
		data[pos] = value;
		minHeapify(getParent(pos));
		pos++;
	}

	public void print() {
		for (int i = 0; i < pos; i++) {
			System.out.println(data[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.add(1);
		heap.add(10);
		heap.add(7);
		heap.add(9);
		heap.add(5);
		heap.add(2);
		heap.print();
	}

}
