package com.apple.ist.poc.ds;

import java.util.HashMap;
import java.util.Map;

public class Strings {
	
	private static void permute(String str, int left, int right) {
		if (left == right) {
			System.out.println(str);
		} else {
			for (int i = left; i <= right; i++) {
				str = swap(str, left, i);
				permute(str, left + 1, right);
				str = swap(str, left, i);
			}
			
		}
	}
	
	private static String swap(String str, int i, int j) {
		char[] cArr = str.toCharArray();
		char ch = cArr[i];
		cArr[i] = cArr[j];
		cArr[j] = ch;
		return String.valueOf(cArr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC";
		permute(str, 0, str.length() - 1);

	}

}
