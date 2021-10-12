package com.musala.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MusalaUtill {

	private static final Pattern PATTERN = Pattern.compile(
	        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	public static boolean validateIp(final String ip) {
	    return PATTERN.matcher(ip).matches();
	}

	public static Date getDateFromString(String paramDate){
		Date date1= null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(paramDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}

	public static boolean isStringNullOrEmpty(String value){
		if (value != null && !value.isEmpty()){
			return true;
		}
		return false;
	}
}
