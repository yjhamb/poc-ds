package com.apple.ist.poc.ds;

public class Mergesort {

	private static void mergeSort(int arr[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int lsize = mid - start + 1;
		int rsize = end - mid;
		int leftArr[] = new int[lsize];
		int rightArr[] = new int[rsize];
		// copy data into temp arrays
		for (int c = 0; c < lsize; c++) {
			leftArr[c] = arr[start + c];
		}
		for (int c = 0; c < rsize; c++) {
			rightArr[c] = arr[mid + 1 + c];
		}

		// merge the arrays
		int i = 0, j = 0;
		int k = start;
		while (i < lsize && j < rsize) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		if (i < lsize) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		if (j < rsize) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
