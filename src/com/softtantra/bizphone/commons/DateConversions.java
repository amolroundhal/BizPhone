package com.softtantra.bizphone.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateConversions {
	public static final String SIMPLE_DATE = "dd/MM/yyyy";
	public static final String SIMPLE_DATE_TIME = "dd/MM/yyyy h:mm a";
	public static final String SQL_DATE = "yyyy-MM-dd";
	public static final String SQL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	
	public static String parseDateToString(Date date,String format) {
		String formattedDate = null;
		Date d1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format); // the
			return sdf.format(date)	;																// format
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date parseStringToDate(String stringDate,String dformat) {
		Date d1 = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(dformat);
			d1 = format.parse(stringDate);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return d1;
	}
	
	public static Date getCurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");
		DateTimeZone timezone = DateTimeZone.forID("Asia/Kolkata");
		DateTime dateTime = new DateTime(timezone);
		try {
			Date date = sdf.parse(dtf.print(dateTime));
			return sdf.parse(dtf.print(dateTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
}
