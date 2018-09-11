package com.apple.ist.poc.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestString {

	private static void closestString() {
		String strings[] = { "Hello", "World", "Bye", "For", "Now", "Bye", "Again" };
		String str1 = "Bye";
		String str2 = "Bye";
		Map<String, List<Integer>> strMap = new HashMap<>();

		for (int i = 0; i < strings.length; i++) {
			List<Integer> locList = strMap.get(strings[i]);
			if (locList == null) {
				locList = new ArrayList<Integer>();
				strMap.put(strings[i], locList);
			}
			locList.add(i + 1);
		}
		List<Integer> locList1 = strMap.get(str1);
		List<Integer> locList2 = strMap.get(str2);
		int distance = 100;
		for (int i : locList1) {
			for (int j : locList2) {
				if (Math.abs(i - j) < distance) {
					distance = Math.abs(i - j);
				}
			}
		}
		System.out.println("Distance: " + distance);
	}

	private static boolean isSubString(String mainString, String findString) {
		boolean found = false;
		if (mainString == null || findString == null || findString.length() > mainString.length()) {
			return false;
		}
		for (int i = 0; i < mainString.length(); i++) {
			for (int k = i, j = 0; k < mainString.length() && j < findString.length(); k++, j++) {
				if (mainString.charAt(k) == findString.charAt(j)) {
					found = true;
				} else {
					found = false;
				}
			}
			if (found) {
				break;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		boolean found = isSubString("Hello", "ff");
		System.out.println("Substring: " + found);
	}
}
