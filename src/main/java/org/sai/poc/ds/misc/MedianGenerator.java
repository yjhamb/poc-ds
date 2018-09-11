package org.sai.poc.ds.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.io.IOUtils;

public class MedianGenerator {

	public static void main(String args[]) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("# of elements:");
			int noOfElements = Integer.valueOf(br.readLine().trim());
			List<Integer> numList = new ArrayList<>();
			for (int index = 0; index < noOfElements; index++) {
				System.out.println("Element:");
				String element = br.readLine().trim();
				numList.add(Integer.valueOf(element));
				numList.sort(null);
				int median = 0;
				int mid = (int) Math.ceil(numList.size() / 2);
				if (numList.size() == 1) {
					median = numList.get(0);
				} else {
					if (numList.size() % 2 == 0) {
						median = (numList.get(mid - 1) + numList.get(mid)) / 2;
					} else {
						median = numList.get(mid);
					}
				}
				System.out.println("List: " + numList);
				System.out.println("Median: " + median);
			}
		} catch (Exception e) {
			System.out.println("Error while computing median");
		} finally {
			//IOUtils.closeQuietly(br);
		}
	}
}
