package com.sp.admin.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatterClass {

	private DateFormatterClass() {
		
	}
	
	public static String getFormattedDate(final Date date) {
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}

	public static String getFormattedTime(final Date date) {
		String[] split = new SimpleDateFormat("dd-MM-yyyy,hh:mm").format(date).split(",");
		return split[1];
	}
}
