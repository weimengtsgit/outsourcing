/**
 * 
 */
package com.company.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author czz
 *
 */
public class DateUtil {

	public static final String YEAR_MONTH_DAY_SIMPLE_FORMAT = "yyyyMMdd";
	public static final String YEAR_MONTH_DAY_FORMAT = "yyyy-MM-dd";
	public static final String DATE_MINUTE_FORMAT = "yyyy/MM/dd HH:mm";
	public static final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
	public static final String MONTH_DAY_ZH_FORMAT = "MM月dd日";
	
	public static String formatDateToSimpleString(Date date) {
		return new SimpleDateFormat(YEAR_MONTH_DAY_SIMPLE_FORMAT).format(date);
	}
	
	public static String formatDateToString(Date date) {
		return new SimpleDateFormat(YEAR_MONTH_DAY_FORMAT).format(date);
	}
}
