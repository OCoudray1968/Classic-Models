package com.classicModels.tools;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

import java.sql.Date;



public class DateUtils {
	
	public static Date toSQLDate(LocalDate date) {
		return Date.valueOf(date);
	}
 
	public static Date toSQLDate(java.util.Date date) {
		if (date instanceof Date ) {
			return (Date) date;
		}
		return new java.sql.Date(toDate(date).getTime());
	}
 
	public static Date toSQLDate(Date date) {
		return date;
	}
 
	///
 
	public static java.util.Date toDate(LocalDate date) {
		Instant instant = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}
 
	private static final int[] HMS_FIELDS = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
	public static java.util.Date toDate(Date date) {
		if ( date instanceof java.util.Date ) {
			return toDate((java.util.Date)date);
		}
		return date;
	}
 
	public static java.util.Date toDate(java.util.Date date) {
		final boolean sql;
		if ( date instanceof Date ) {
			sql=true;
		}
		else {
			sql=false;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		for(int field : HMS_FIELDS) {
			cal.set(field, 0);
		}
		return sql?new java.sql.Date(cal.getTimeInMillis()):cal.getTime(); // supprime h,m,s
	}
 
	///
 
	public static LocalDate toLocalDate(java.util.Date date) {
		Instant instant = Instant.ofEpochMilli(date.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}
 
	public static LocalDate toLocalDate(java.sql.Date date) {
		return toLocalDate(toDate(date));
	}
 
	public static LocalDate toLocalDate(LocalDate date) {
		return date;
	}
 
	///
 
}


