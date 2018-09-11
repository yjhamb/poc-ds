package org.sai.poc.ds.misc;

public class FibonacciGenerator {

	static final int MAX = 100;
	static final int NIL = -1;

	static int lookup[] = new int[MAX];

	/* Function to initialize NIL values in lookup table */
	static void _initialize() {
		for (int i = 0; i < MAX; i++)
			lookup[i] = NIL;
	}

	/* function for nth Fibonacci number */
	static int fib(int n) {
		if (lookup[n] == NIL) {
			if (n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fib(n - 1) + fib(n - 2);
		}
		return lookup[n];
	}

	static int fib2(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return fib2(n - 1) + fib2(n - 2);
		}
	}

	public static void main(String[] args) {
		int n = 5;
		FibonacciGenerator._initialize();
		System.out.println("Fibonacci - 1 number is" + " " + FibonacciGenerator.fib(n));
		System.out.println("Fibonacci - 2 number is" + " " + FibonacciGenerator.fib2(n));
	}

}
