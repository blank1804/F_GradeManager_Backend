package  com.bk.GradeManager.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bk.GradeManager.utils.configurer.DateUtilsConfigurer;

public class DateUtils {
	private static DateUtilsConfigurer DATE_UTILS_CONFIGURER;
	public static final long MILLISECONDS_PER_MIN = 60 * 1000;
	public static final long MILLISECONDS_PER_HOUR = 60 * 60 * 1000;
	public static final long MILLISECONDS_PER_DAY = 24 * MILLISECONDS_PER_HOUR;
	public static final Map<String, DateFormat> DATE_FORMAT_MAP = new HashMap<String, DateFormat>();

	public static boolean after(final Date date1, final Date date2) {
		return date1.compareTo(date2) > 0;
	}

	public static boolean before(final Date date1, final Date date2) {
		return date1.compareTo(date2) < 0;
	}

	public static boolean between(final Date date, final Date start, final Date end) {
		if (DateUtils.before(date, start)) {
			return false;
		} else if (DateUtils.after(date, end)) {
			return false;
		} else {
			return true;
		}
	}

	public static int compare(final Date date1, final Date date2) {
		return date1.compareTo(date2);
	}

	public static int diffDate(final Date date1, final Date date2) {
		final long millisecond1 = date1.getTime();
		final long millisecond2 = date2.getTime();
		final long diffMilliseconds = millisecond2 - millisecond1;
		return (int) (diffMilliseconds / DateUtils.MILLISECONDS_PER_DAY);
	}

	public static float  diffDateToMinite(final Date date1, final Date date2) {
		final float  millisecond1 = date1.getTime();
		final float  millisecond2 = date2.getTime();
		final float  diffMilliseconds = millisecond2 - millisecond1;
		return (diffMilliseconds / DateUtils.MILLISECONDS_PER_MIN );
	}

	private static void removeTime(final Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	public static Date addDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	public static Date toEndOfDay(final Date date) {
		final Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static Date toStartOfDay(final Date date) {
		final Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.setTime(date);
		DateUtils.removeTime(calendar);
		return calendar.getTime();
	}

	public static Date getStartDateOfMonth(Date current) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.setTime(current);
		removeTime(calendar);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
		return calendar.getTime();
	}

	public static Date getEndDateOfMonth(Date current) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.setTime(current);
		removeTime(calendar);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return calendar.getTime();
	}
	
	public static Date getStartDateOfYear(Date current) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
	
		calendar.set(Calendar.YEAR,DateUtils.getCurrentFullYear());
		calendar.set(Calendar.MONTH,0);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		
		return calendar.getTime();
	}
	
	public static Date getEndDateOfYear(Date current) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
	
		calendar.set(Calendar.YEAR,DateUtils.getCurrentFullYear());
		calendar.set(Calendar.MONTH,11);
		calendar.set(Calendar.DAY_OF_MONTH,31);
		return calendar.getTime();
	}
	

	public static SimpleDateFormat getDateFormat() {
		return DateUtils.DATE_UTILS_CONFIGURER.getShortSimpleDateFormat();
	}

	public static SimpleDateFormat getTimeFormat() {
		return DateUtils.DATE_UTILS_CONFIGURER.getShortSimpleTimeFormat();
	}

	public static Date getFirstTimeOfYear(Integer year) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.set(year,0,1,0,0,0);
		return calendar.getTime();
	}

	public static Date getLastTimeOfYear(Integer year) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.set(year,11,31,23,59,59);
		return calendar.getTime();
	}

	public static Date getFirstTimeOfMonth(Integer year ,Integer month) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.set(year,month,1,0,0,0);
		return calendar.getTime();
	}

	public static Date getLastTimeOfMonth(Integer year ,Integer month) {
		Calendar calendar = Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale());
		calendar.set(year,month,1,23,59,59);
		Integer days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(year,month,days,23,59,59);
		return calendar.getTime();
	}

	public static Integer getCurrentFullYear(){
		return Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale()).get(Calendar.YEAR);
	}

	public static Integer getCurrentMonth(){
		return Calendar.getInstance(DATE_UTILS_CONFIGURER.getDefaultLocale()).get(Calendar.MONTH) + 1;
	}

	public static Date addMinutes(Date date, int amount) {
		 if (date != null) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add( Calendar.MINUTE, amount);
	        return c.getTime();
        }
		 return null;
    }
}
