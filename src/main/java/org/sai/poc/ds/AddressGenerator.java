package com.apple.ist.poc.ds;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressGenerator {

	private static void generateAddressList(List<List<String>> componentList, List<List<String>> addressList,
			int index) {
		index = index + 1;
		List<String> cList = componentList.get(index);
		for (int i = 0; i < cList.size(); i++) {
			String value = cList.get(i);
			if (index == 0) {
				List<String> aList = new ArrayList<>();
				aList.add(value);
				addressList.add(aList);
			} else {
				List<String> lastEntry = addressList.get(addressList.size() - 1);
				if (i > 0) {
					List<String> newEntry = new ArrayList<>(lastEntry);
					newEntry.subList(index, newEntry.size()).clear();
					newEntry.add(index, value);
					addressList.add(newEntry);
				} else {
					lastEntry.add(value);
				}
			}
			// call recursively for next component
			if (index < componentList.size() - 1) {
				generateAddressList(componentList, addressList, index);
			}
		}

	}

	private static void printAddressList(List<List<String>> addressList) {
		for (List<String> list : addressList) {
			StringBuilder sb = new StringBuilder();
			for (String val : list) {
				sb.append(val).append(" ");
			}
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		String streetArr[] = new String[] { "123 Deer Lane", "345 Temple Dr" };
		String cityArr[] = new String[] { "San Jose", "Cupertino" };
		String stateArr[] = new String[] { "CA", "OR" };
		String countryArr[] = new String[] { "USA", "Canada" };

		List<String> streetList = new ArrayList<>(Arrays.asList(streetArr));
		List<String> cityList = new ArrayList<>(Arrays.asList(cityArr));
		List<String> stateList = new ArrayList<>(Arrays.asList(stateArr));
		List<String> countryList = new ArrayList<>(Arrays.asList(countryArr));

		List<List<String>> componentList = new ArrayList<>();
		componentList.add(streetList);
		componentList.add(cityList);
		componentList.add(stateList);
		componentList.add(countryList);
		List<List<String>> addressList = new ArrayList<>();

		// generate addresses
		generateAddressList(componentList, addressList, -1);
		// print addresses
		printAddressList(addressList);
	}

}
