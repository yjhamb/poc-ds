package com.apple.ist.poc.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ExpressionEvaluator {

	private static List<String> postfixExp = new ArrayList<>();
	private static Deque<String> stack = new ArrayDeque<>();

	private static void evaluateExpression(String expression) {
		final char[] expArray = expression.toCharArray();
		for (char c : expArray) {
			if (Character.isDigit(c)) {
				postfixExp.add(String.valueOf(c));
			} else {
				if (stack.isEmpty() || hasHigherPrecedence(c, stack.peekFirst().charAt(0))) {
					stack.push(String.valueOf(c));
				} else {
					String op = stack.pop();
					postfixExp.add(op);
					stack.push(String.valueOf(c));
				}
			}
		}
		while (!stack.isEmpty()) {
			postfixExp.add(stack.pop());
		}
	}

	private static boolean hasHigherPrecedence(char op, char stackOp) {
		return precedenceLevel(op) > precedenceLevel(stackOp);
	}

	private static int precedenceLevel(char op) {
		switch (op) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		case '^':
			return 2;
		default:
			throw new IllegalArgumentException("Operator unknown: " + op);
		}
	}

	public static void main(String[] args) {
		final String expression = "5*4+2";
		evaluateExpression(expression);
		for (String st : postfixExp) {
			System.out.print(st);
		}
	}
}
