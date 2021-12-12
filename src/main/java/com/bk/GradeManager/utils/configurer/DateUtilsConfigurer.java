package com.bk.GradeManager.utils.configurer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;

public class DateUtilsConfigurer implements InitializingBean {
	private Locale defaultLocale;
	private String shortDateFormat;
	private String shortTimeFormat;
	private String shortYearFormat;
	private String shortSystemStartDate;
	private String shortSystemEndDate;
	private Date systemStartDate;
	private Date systemEndDate;

	public DateUtilsConfigurer() {
		defaultLocale = Locale.US;
		thLocale = new Locale("th", "TH");
		shortDateFormat = "dd/MM/yyyy";
		shortTimeFormat = "HH:mm";
		shortSystemStartDate = "01/01/1970";
		shortSystemEndDate = "31/12/2449";
		shortYearFormat = "yy";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		SimpleDateFormat shortSimpleDateFormat = new SimpleDateFormat(shortDateFormat, defaultLocale);
		systemStartDate = shortSimpleDateFormat.parse(shortSystemStartDate);
		systemEndDate = shortSimpleDateFormat.parse(shortSystemEndDate);
	}

	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	public Locale getThLocale() {
		return thLocale;
	}

	public void setThLocale(Locale thLocale) {
		this.thLocale = thLocale;
	}

	private Locale thLocale;
	public void setShortDateFormat(String shortDateFormat) {
		this.shortDateFormat = shortDateFormat;
	}

	public String getShortDateFormat() {
		return shortDateFormat;
	}

	public String getShortTimeFormat() {
		return shortTimeFormat;
	}

	public SimpleDateFormat getShortSimpleDateFormat() {
		return new SimpleDateFormat(shortDateFormat, defaultLocale);
	}

	public String getShortSystemStartDate() {
		return shortSystemStartDate;
	}
	
	public void setShortSystemStartDate(String shortSystemStartDate) {
		this.shortSystemStartDate = shortSystemStartDate;
	}

	public String getShortSystemEndDate() {
		return shortSystemEndDate;
	}

	public void setShortSystemEndDate(String shortSystemEndDate) {
		this.shortSystemEndDate = shortSystemEndDate;
	}
	
	public Date getSystemStartDate() {
		return systemStartDate;
	}

	public Date getSystemEndDate() {
		return systemEndDate;
	}

	public SimpleDateFormat getShortSimpleTimeFormat() {
		return new SimpleDateFormat(shortTimeFormat, defaultLocale);
	}

	public SimpleDateFormat getShortSimpleYearFormat() {
		return new SimpleDateFormat(shortYearFormat, defaultLocale);
	}
}
