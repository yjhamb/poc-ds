package com.apple.ist.poc.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BracketMatching {

	private static class Stack {
		static int top = 0;
		static List<Character> stack = new ArrayList<>();

		static void push(Character ch) {
			stack.add(top++, ch);
		}

		static Character pop() {
			if (top > 0) {
				return stack.get(--top);
			} else {
				return null;
			}
		}

		static boolean isEmpty() {
			return top == 0;
		}
	}

	public static boolean isBalanced(String expression) {
		if (expression.equals("")) {
			if (Stack.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
		if (expression.charAt(0) == '{' || expression.charAt(0) == '[' || expression.charAt(0) == '(') {
			Stack.push(expression.charAt(0));
			return isBalanced(expression.substring(1));
		} else if (expression.charAt(0) == '}' || expression.charAt(0) == ']' || expression.charAt(0) == ')') {
			Character ch = Stack.pop();
			if (ch == null) {
				return false;
			} else if ((expression.charAt(0) == '}' && ch == '{') || (expression.charAt(0) == ']' && ch == '[')
					|| (expression.charAt(0) == ')' && ch == '(')) {
				return isBalanced(expression.substring(1));
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}

}
