package org.sai.poc.ds.misc;

public class Fibo {
	
	public static void printFibo(int n) {
		int[] memArr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			System.out.println(fiboMem(i, memArr));
		}
	}
	
	public static int fibo(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibo(n-1) + fibo(n-2);
	}
	
	public static int fiboMem(int n, int[] memArr) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (memArr[n] > 0) {
			return memArr[n];
		}
		memArr[n] = fiboMem(n-1, memArr) + fiboMem(n-2, memArr);
		return memArr[n];
	}

	public static void main(String[] args) {
		printFibo(7);

	}

}
