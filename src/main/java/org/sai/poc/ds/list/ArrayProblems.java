package org.sai.poc.ds.list;

public class ArrayProblems {

	private static void pairSum() {
		int arr[] = { 2, 4, 8, 1, 9, 7, 0 };
		int sum = 9;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.println(i + " , " + j);
				}
			}
		}
	}

	public static void main(String[] args) {
		pairSum();
	}
}
