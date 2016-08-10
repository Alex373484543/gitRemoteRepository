package fanglab.framework;

import java.text.*;
import java.util.*;

public class SlDateTime {
	/*
	 * 当前时间
	 */
	public static String nowTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

		return simpleDateFormat.format(new Date());
	}

	/*
	 * 当前日期时间
	 */
	public static String now() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");

		return simpleDateFormat.format(new Date());
	}

	/*
	 * 当前日期
	 */
	public static String nowDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return simpleDateFormat.format(new Date());
	}

	/*
	 * 当前年
	 */
	public static String nowYear() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

		return simpleDateFormat.format(new Date());
	}

	/*
	 * 当前月
	 */
	public static String nowMonth() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");

		return simpleDateFormat.format(new Date());
	}

	/*
	 * 当前天
	 */
	public static String nowDay() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");

		return simpleDateFormat.format(new Date());
	}

	/*
	 * JavaScript最小时间
	 */
	public static final Date JavaScriptMinTime = new Date(
			new GregorianCalendar(1970, 1, 1, 8, 0, 0).getTimeInMillis());

	/*
	 * 格式化字符串
	 */
	public static final String FormatString = "yyyy-MM-dd HH:mm:ss.SSS";

	/*
	 * 日期格式化字符串
	 */
	public static final String DateFormatString = "yyyy-MM-dd";

	/*
	 * 解析配置
	 * 
	 * @param String value，值
	 * 
	 * @param String regioneSplit，区域分割线
	 * 
	 * @param String partSplit，部分分割线
	 * 
	 * @return Date[]，结果
	 */
	public static Date[] parseConfig(String value) {
		return parseConfig(value, "\\|");
	}

	/*
	 * 解析配置
	 * 
	 * @param String value，值
	 * 
	 * @param String regioneSplit，区域分割线
	 * 
	 * @param String partSplit，部分分割线
	 * 
	 * @return Date[]，结果
	 */
	public static Date[] parseConfig(String value, String regioneSplit) {
		return parseConfig(value, regioneSplit, "\\~");
	}

	/*
	 * 解析配置
	 * 
	 * @param String value，值
	 * 
	 * @param String regioneSplit，区域分割线
	 * 
	 * @param String partSplit，部分分割线
	 * 
	 * @return Date[]，结果
	 */
	public static Date[] parseConfig(String value, String regioneSplit,
			String partSplit) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String[] regiones = value.split(regioneSplit);
		ArrayList<Date> dataDates = new ArrayList<Date>();
		for (int i = 0; i < regiones.length; i++) {
			String region = regiones[i];
			String[] parts = region.split(partSplit);
			if (parts.length == 2) {
				// 说明是范围
				Date left = new Date();
				try {
					left = simpleDateFormat.parse(parts[0]);
				} catch (ParseException e) {

				}
				Date right = new Date();
				try {
					right = simpleDateFormat.parse(parts[1]);
				} catch (ParseException e) {

				}

				if (left.before(right)) {
					for (Date now = (Date) left.clone(); (now.before(right) || now
							.equals(right)); now.setTime(now.getTime() + 1
							* 1000 * 60 * 60 * 24)) {
						if (!dataDates.contains((Date) now.clone())) {
							dataDates.add((Date) now.clone());
						}
					}
				} else if (left.after(right)) {
					for (Date now = (Date) left.clone(); (now.after(right) || now
							.equals(right)); now.setTime(now.getTime() - 1
							* 1000 * 60 * 60 * 24)) {
						if (!dataDates.contains((Date) now.clone())) {
							dataDates.add((Date) now.clone());
						}
					}
				} else {
					if (!dataDates.contains((Date) left.clone())) {
						dataDates.add((Date) left.clone());
					}
				}
			} else {
				try {
					if (!dataDates.contains((Date) (simpleDateFormat
							.parse(region).clone()))) {
						dataDates.add((Date) (simpleDateFormat.parse(region)
								.clone()));
					}
				} catch (ParseException e) {

				}
			}
		}

		return dataDates.toArray(new Date[dataDates.size()]);
	}

	/*
	 * 获得月间隔
	 * 
	 * @param Date start，开始时间
	 * 
	 * @param Date end，结束时间
	 * 
	 * @return ArrayList<Date>，结果
	 */
	public static ArrayList<Date> getMonthInterval(Date start, Date end)
			throws Exception {
		if (start.after(end)) {
			throw new Exception("开始时间必须小于等于结束时间！");
		}
		ArrayList<Date> result = new ArrayList<Date>();
		SimpleDateFormat yearSimpleDateFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthSimpleDateFormat = new SimpleDateFormat("M");
		SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat("yyyy-M-d");
		for (int y = Integer.parseInt(yearSimpleDateFormat.format(start)); y <= Integer
				.parseInt(yearSimpleDateFormat.format(end)); y++) {
			if (yearSimpleDateFormat.format(start).equals(
					yearSimpleDateFormat.format(end))) {
				for (int m = Integer.parseInt(monthSimpleDateFormat
						.format(start)); m <= Integer
						.parseInt(monthSimpleDateFormat.format(end)); m++) {
					try {
						result.add(daySimpleDateFormat.parse(String.valueOf(y)
								+ "-" + String.valueOf(m) + "-1"));
					} catch (ParseException e) {

					}
				}
			} else if (String.valueOf(y).equals(
					yearSimpleDateFormat.format(start))) {
				for (int m = Integer.parseInt(monthSimpleDateFormat
						.format(start)); m <= 12; m++) {
					try {
						result.add(daySimpleDateFormat.parse(String.valueOf(y)
								+ "-" + String.valueOf(m) + "-1"));
					} catch (ParseException e) {

					}
				}
			} else if (String.valueOf(y).equals(
					yearSimpleDateFormat.format(end))) {
				for (int m = 1; m <= Integer.parseInt(monthSimpleDateFormat
						.format(end)); m++) {
					try {
						result.add(daySimpleDateFormat.parse(String.valueOf(y)
								+ "-" + String.valueOf(m) + "-1"));
					} catch (ParseException e) {

					}
				}
			} else {
				for (int m = 1; m <= 12; m++) {
					try {
						result.add(daySimpleDateFormat.parse(String.valueOf(y)
								+ "-" + String.valueOf(m) + "-1"));
					} catch (ParseException e) {

					}
				}
			}
		}

		return result;
	}
}
