package com.apple.ist.poc.ds;

public class Heapsort {

	private static void maxHeapify(int arr[], int index, int heapSize) {
		int lindex = index * 2 - 1;
		int rindex = index * 2;
		int largest = 0;
		if (lindex < heapSize && arr[lindex] > arr[index]) {
			largest = lindex;
		} else {
			largest = index;
		}
		if (rindex < heapSize && arr[rindex] > arr[largest]) {
			largest = rindex;
		}
		if (largest != index) {
			// swap
			int temp = arr[largest];
			arr[largest] = arr[index];
			arr[index] = temp;
			maxHeapify(arr, largest, heapSize);
		}
	}

	private static void buildMaxHeap(int arr[]) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, i + 1, arr.length);
		}
	}

	private static void heapSort(int arr[]) {
		buildMaxHeap(arr);
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = arr[1];
			arr[1] = temp;
			count++;
			maxHeapify(arr, 1, arr.length - count);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 3, 6, 1, 9, 4, 12, 7, 5 };
		heapSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}

	}

}
