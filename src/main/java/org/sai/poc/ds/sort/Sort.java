package org.sai.poc.ds.sort;

public class Sort {

	private static void insertionSort(int arr[]) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;
			boolean shifted = false;
			while (i >= 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
				i--;
				shifted = true;
			}
			if (shifted) {
				arr[++i] = key;
			}
		}
	}

	private static void bubbleSort(int arr[]) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
					sorted = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 3, 6, 1, 9, 4, 12, 7, 5 };
		// insertionSort(arr);
		// mergeSort(arr, 0, arr.length - 1);
		bubbleSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
