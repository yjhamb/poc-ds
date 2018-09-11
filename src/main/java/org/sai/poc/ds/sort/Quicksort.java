package org.sai.poc.ds.sort;

public class Quicksort {

	private static void quickSort(int arr[], int left, int right) {
		if (left < right) {
			int p = partition(arr, left, right);
			quickSort(arr, left, p - 1);
			quickSort(arr, p + 1, right);
		}
	}

	private static int partition(int arr[], int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 6, 1, 9, 4, 12, 7, 5 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.println(i);
		}

	}

}
