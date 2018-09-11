package org.sai.poc.ds.list;

public class Palindrome {
	private static String inputString = "rabcar";
	private static char[] input = inputString.toCharArray();

	private static boolean checkPalindrome() {
		int start = 0;
		int end = input.length - 1;

		boolean palindrome = true;
		for (int i = start, j = end; i <= j; i++, j--) {
			if (input[i] != input[j]) {
				palindrome = false;
				break;
			}
		}
		if (palindrome) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String args[]) {

	}

}
