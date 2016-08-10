package fanglab.framework;

import java.util.Date;

/*
 * 日历项
 */
public class SlCalendarItem {
	// 日期
	public Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(int yearMonth) {
		this.yearMonth = yearMonth;
	}

	public int getYearMonthDay() {
		return yearMonthDay;
	}

	public void setYearMonthDay(int yearMonthDay) {
		this.yearMonthDay = yearMonthDay;
	}

	public int getKpiYearWeek() {
		return kpiYearWeek;
	}

	public void setKpiYearWeek(int kpiYearWeek) {
		this.kpiYearWeek = kpiYearWeek;
	}

	public int getKpiYearWeekDay() {
		return kpiYearWeekDay;
	}

	public void setKpiYearWeekDay(int kpiYearWeekDay) {
		this.kpiYearWeekDay = kpiYearWeekDay;
	}

	public int getYearWeek() {
		return yearWeek;
	}

	public void setYearWeek(int yearWeek) {
		this.yearWeek = yearWeek;
	}

	public int getYearWeekDay() {
		return yearWeekDay;
	}

	public void setYearWeekDay(int yearWeekDay) {
		this.yearWeekDay = yearWeekDay;
	}

	public int getYearQuarter() {
		return yearQuarter;
	}

	public void setYearQuarter(int yearQuarter) {
		this.yearQuarter = yearQuarter;
	}

	public int getYearQuarterDay() {
		return yearQuarterDay;
	}

	public void setYearQuarterDay(int yearQuarterDay) {
		this.yearQuarterDay = yearQuarterDay;
	}

	// 年
	public int year;

	// 年月
	public int yearMonth;

	// 年月日
	public int yearMonthDay;

	// Kpi年周
	public int kpiYearWeek;

	// Kpi年周日
	public int kpiYearWeekDay;

	// 年周
	public int yearWeek;

	// 年周日
	public int yearWeekDay;

	// 年季
	public int yearQuarter;

	// 年季日
	public int yearQuarterDay;
}
