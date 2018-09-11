package com.apple.ist.poc.ds;

public class BinarySearch {
	
	private static void findSmallestIndex(String alert) {
		int index = findSmallestIndex(alert, 0, alert.length() - 1);
		if (index > 0) {
			System.out.println(index + 1);
		} else {
			System.out.println(index);
		}
	}

	private static int findSmallestIndex(String alert, int start, int end) {
		if (end > start) {
			int mid = (start + end) / 2;
			if (alert.charAt(mid) == 'F') {
				return findSmallestIndex(alert, start, mid);
			} else {
				return findSmallestIndex(alert, mid + 1, end);
			}
		} else {
			if (alert.charAt(start) == 'F') {
				return start;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		findSmallestIndex("");

	}

}
