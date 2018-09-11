package org.sai.poc.ds.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Contacts {
	private static Map<String, Integer> contactCountMap = new HashMap<>();

	private static class ContactOp {
		String op;
		String contact;

		private ContactOp(String op, String contact) {
			this.op = op;
			this.contact = contact;
		}

		public String getOp() {
			return this.op;
		}

		public String getContact() {
			return this.contact;
		}
	}

	public static void main(String[] args) {
		Set<ContactOp> contacts = new HashSet<>();
		List<Integer> counts = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			ContactOp cOp = new ContactOp(op, contact);
			contacts.add(cOp);
		}
		for (ContactOp cOp : contacts) {
			if (cOp.getOp().equalsIgnoreCase("add")) {
				addContact(cOp.getContact());
			}
		}
		for (ContactOp cOp : contacts) {
			if (cOp.getOp().equalsIgnoreCase("find")) {
				int count = findContact(cOp.getContact());
				counts.add(count);
			}
		}
		for (int i : counts) {
			System.out.println(i);
		}
	}

	private static void addContact(String contact) {
		for (int i = 1; i <= contact.length(); i++) {
			String index = contact.substring(0, i);
			Integer count = contactCountMap.get(index);
			if (count == null) {
				count = 0;
			}
			count++;
			contactCountMap.put(index, count);
		}
	}

	private static int findContact(String contact) {
		int count = 0;
		Integer cnt = contactCountMap.get(contact);
		if (cnt != null) {
			count = cnt.intValue();
		}
		return count;
	}
}
