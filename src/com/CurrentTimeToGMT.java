package com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentTimeToGMT {

	public static void main(String args[]) throws ParseException {

		String d = "09/19/2019 20:00:00";
		convertTimeZone(d, "MM/dd/yyyy HH:mm:ss","MM/dd/yyyy HH:mm:ss", "Asia/Shanghai", "Asia/Calcutta");
		
	}

	public static String convertTimeZone(String d, String sourceDateFormate, String destinationDateFormate,
			String sourceTimeZone, String destinationTimeZone) throws ParseException {
		DateFormat sourceDateTimeFormatter = new SimpleDateFormat(sourceDateFormate);
		TimeZone t = TimeZone.getTimeZone(sourceTimeZone);
		sourceDateTimeFormatter.setTimeZone(t);
		Date date = sourceDateTimeFormatter.parse(d);

		System.out.println("Source Time Zone: " + t.getDisplayName() + " : " + sourceDateTimeFormatter.format(date));

		//date = sourceDateTimeFormatter.parse(d);
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		sourceDateTimeFormatter.setTimeZone(gmtTime);
		
		System.out.println("London Time: " + sourceDateTimeFormatter.format(date));
		
		
		DateFormat destinatonDateFormator = new SimpleDateFormat(destinationDateFormate);
		TimeZone destinationTime = TimeZone.getTimeZone(destinationTimeZone);
		destinatonDateFormator.setTimeZone(destinationTime);

		System.out.println("Destination Time Zone: " + destinationTime.getDisplayName() +" : " + destinatonDateFormator.format(date));
		
		return destinatonDateFormator.format(date);
	}
	
}
