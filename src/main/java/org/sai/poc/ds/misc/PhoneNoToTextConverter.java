package org.sai.poc.ds.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNoToTextConverter {

	private static final Map<String, String> phoneNoMap = new HashMap<>();

	static {
		phoneNoMap.put("0", "");
		phoneNoMap.put("1", "");
		phoneNoMap.put("2", "ABC");
		phoneNoMap.put("3", "DEF");
		phoneNoMap.put("4", "GHI");
		phoneNoMap.put("5", "JKL");
		phoneNoMap.put("6", "MNO");
		phoneNoMap.put("7", "PQR");
		phoneNoMap.put("8", "STUV");
		phoneNoMap.put("9", "WXYZ");
	}

	public static void main(String[] args) {
		String phoneNo = "2340";
		List<String> convertedPhoneNo = new ArrayList<>();
		convertPhoneNo(phoneNo, convertedPhoneNo);
		for (String val : convertedPhoneNo) {
			System.out.println(val);
		}
	}

	private static void convertPhoneNo(String phoneNo, List<String> convertedPhoneNo) {
		if (phoneNo == null || phoneNo == "") {
			return;
		}
		if (phoneNo.charAt(0) == '0' || phoneNo.charAt(0) == '1') {
			return;
		}
		// look up map and merge
		String textVal = phoneNoMap.get(String.valueOf(phoneNo.charAt(0)));
		if (convertedPhoneNo.isEmpty()) {
			for (int i = 0; i < textVal.length(); i++) {
				String textChar = String.valueOf(textVal.charAt(i));
				convertedPhoneNo.add(textChar);
			}
		} else {
			List<String> phoneNoList = new ArrayList<>();
			for (String val : convertedPhoneNo) {
				phoneNoList.add(val);
			}
			convertedPhoneNo.clear();
			for (int i = 0; i < textVal.length(); i++) {
				String textChar = String.valueOf(textVal.charAt(i));
				for (String val : phoneNoList) {
					convertedPhoneNo.add(val + textChar);
				}
			}
		}
		// call recursively
		if (phoneNo.length() > 1) {
			convertPhoneNo(phoneNo.substring(1), convertedPhoneNo);
		}
	}

}
