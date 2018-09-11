package org.sai.poc.ds.misc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaApp {

	public static void main(String[] args) {
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (int a, int b) -> a - b;

		System.out.println("10 + 5 = " + operate(10, 5, addition));

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		for (Integer number : numbers) {
			System.out.println("Number: " + number);
		}

		// numbers.forEach((Integer val) -> System.out.println(val));

		// numbers.forEach(val -> System.out.println(val));

		// using method reference - also known as eta expansion
		// numbers.forEach(System.out::println);

		System.out.println("Printing All...");
		System.out.println(sumAll(numbers, n -> true));

		System.out.println("Printing Event...");
		System.out.println(sumAll(numbers, n -> n % 2 == 0));

		System.out.println("Printing > 3...");
		System.out.println(sumAll(numbers, n -> n > 3));
	}

	public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
		int total = 0;
		for (int number : numbers) {
			if (p.test(number)) {
				total += number;
			}
		}
		return total;
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	private static int operate(int a, int b, MathOperation operation) {
		return operation.operation(a, b);
	}

}
