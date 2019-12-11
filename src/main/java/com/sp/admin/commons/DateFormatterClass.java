package com.sp.admin.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sp.admin.exceptions.DateFormateExeption;

public class DateFormatterClass {
	
	private DateFormatterClass() {

	}

	public static String getFormattedDate(final Date date) {
		return getDateFormatter().format(date);
	}

	public static String getFormattedTime(final Date date) {
		String[] split = new SimpleDateFormat("dd-MM-yyyy,kk:mm").format(date).split(",");
		return split[1];
	}

	public static Date getPreviousDate(final Date date) {
		Calendar calendarInstance = getCalInstance();
		calendarInstance.setTime(date);
		calendarInstance.add(Calendar.DAY_OF_YEAR, -15);
		return calendarInstance.getTime();
	}

	public static Date getDate(final String date, final String time){
		Calendar cal = getCalInstance();
		cal.setTime(convertStringToDate(date));
		String[] splitHoursAndSecond = time.split(":");
		cal.set(Calendar.HOUR_OF_DAY, getFormattedTime(splitHoursAndSecond[0]));
		cal.set(Calendar.MINUTE, getFormattedTime(splitHoursAndSecond[1]));
		return cal.getTime();
	}

	public static Date convertStringToDate(final String date) {
		Date formatedDate = null;
		try {
			formatedDate = getDateFormatter().parse(date);
		} catch (ParseException e) {
			throw new DateFormateExeption("exception while converting string to date");
		}
		return formatedDate;
	}
	
	private static int getFormattedTime(final String time) {
        return Integer.parseInt(time);
	}

	private static SimpleDateFormat getDateFormatter() {
		return new SimpleDateFormat("dd-MM-yyyy");
	}

	private static Calendar getCalInstance() {
		return Calendar.getInstance();
	}
}
