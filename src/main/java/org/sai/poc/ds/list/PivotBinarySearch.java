/**
 * Performs binary search on list that has peak or pivot. 
 */
package org.sai.poc.ds.list;

public class PivotBinarySearch {

	private int numArr[] = null;

	public PivotBinarySearch(int[] arr) {
		this.numArr = arr;
	}

	public boolean exists(int key) {
		int index = findPivot(0, numArr.length);
		boolean result = searchIncreasing(0, index, key);
		if (!result) {
			result = searchDecreasing(index + 1, numArr.length, key);
		}
		return result;
	}

	private int findPivot(int start, int end) {
		int mid = (start + end) / 2;
		if (numArr[mid - 1] <= numArr[mid] && numArr[mid] >= numArr[mid + 1]) {
			return mid;

		} else if (numArr[mid - 1] <= numArr[mid] && numArr[mid] <= numArr[mid + 1]) {
			return findPivot(mid, end);

		} else if (numArr[mid - 1] >= numArr[mid] && numArr[mid] >= numArr[mid + 1]) {
			return findPivot(start, mid);

		} else {
			return 0;
		}
	}

	private boolean searchIncreasing(int start, int end, int key) {
		if (end > start) {
			int mid = (start + end) / 2;
			if (numArr[mid] == key) {
				return true;

			} else if (numArr[mid] <= key) {
				return searchIncreasing(start, mid, key);

			} else {
				return searchIncreasing(mid + 1, end, key);
			}
		} else {
			return false;
		}
	}

	private boolean searchDecreasing(int start, int end, int key) {
		if (end > start) {	
			int mid = (start + end) / 2;
			if (numArr[mid] == key) {
				return true;

			} else if (numArr[mid] <= key) {
				return searchDecreasing(mid + 1, end, key);

			} else {
				return searchDecreasing(start, mid, key);
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 12, 27, 20, 14, 5, 4 };
		PivotBinarySearch pbs = new PivotBinarySearch(arr);
		System.out.println(pbs.exists(1));
	}

}
