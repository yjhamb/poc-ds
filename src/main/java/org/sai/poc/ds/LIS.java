package com.apple.ist.poc.ds;

public class LIS {

	private static final int[] seqArray = { 10, 2, 9, 5, 9, 63, 92 };
	private static int[] lisArray = new int[7];

	public static void main(String[] args) {
		for (int i = 0; i < seqArray.length; i++) {
			lis(i);
		}
		int len = 1;
		StringBuilder sb = new StringBuilder();
		StringBuilder seq = new StringBuilder();
		for (int i = 0; i < lisArray.length; i++) {
			sb.append(lisArray[i]).append(" ");
			if (lisArray[i] != 0) {
				seq.append(seqArray[i]).append(" ");
			}
			if (lisArray[i] > len) {
				len = lisArray[i];
			}
		}
		System.out.println("Subsequence Length:" + len);
		System.out.println("Subsequence Indices:" + sb.toString());
		System.out.println("Subsequence Indices:" + seq.toString());
	}

	private static void lis(int index) {
		if (index == 0) {
			lisArray[index] = 1;
		} else {
			int max = 0;
			boolean increasing = true;
			for (int j = 0; j < index; j++) {
				if (seqArray[index] < seqArray[j]) {
					increasing = false;
					break;
				}
			}
			for (int j = 0; j < index; j++) {
				if (lisArray[j] > max) {
					max = lisArray[j];
				}
			}
			if (increasing) {
				lisArray[index] = max + 1;
			} else {
				lisArray[index] = 0;
			}
		}
	}

}
