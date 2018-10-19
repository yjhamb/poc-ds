/**
 * 
 */
package org.sai.poc.ds.misc;

import java.sql.Timestamp;

public class DateUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timestamp startTime = Timestamp.valueOf("2018-09-24" + " 00:00:00");
		System.out.println(startTime.toString());

	}

}
