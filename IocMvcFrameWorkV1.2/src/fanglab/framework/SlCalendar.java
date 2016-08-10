package fanglab.framework;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 日历
 */
public class SlCalendar {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static SimpleDateFormat yearSimpleDateFormat = new SimpleDateFormat(
			"yyyy");

	/*
	 * 获得一项
	 * 
	 * @param Date dateTime，日期
	 * 
	 * @return，结果
	 */
	@SuppressWarnings("deprecation")
	public static SlCalendarItem getItem(Date dateTime) {
		try {
			DecimalFormat decimalFormat = new DecimalFormat("00");
			Date dataTime = simpleDateFormat.parse(simpleDateFormat
					.format(dateTime));

			Date currentYearStartTime = simpleDateFormat.parse(String.format(
					"%s-01-01", String.valueOf(Integer
							.parseInt(yearSimpleDateFormat.format(dataTime)))));

			// 周定义：周五（1）、周六（2）、周日（3）、周一（4）、周二（5）、周三（6）、周四（7）
			int dayOfKpiWeek = 1;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataTime);
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			switch (dayOfWeek) {
			case 6:
				dayOfKpiWeek = 1;
				break;
			case 7:
				dayOfKpiWeek = 2;
				break;
			case 1:
				dayOfKpiWeek = 3;
				break;
			case 2:
				dayOfKpiWeek = 4;
				break;
			case 3:
				dayOfKpiWeek = 5;
				break;
			case 4:
				dayOfKpiWeek = 6;
				break;
			case 5:
				dayOfKpiWeek = 7;
				break;
			}

			int currentDayOfKpiWeek = 1;
			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.setTime(currentYearStartTime);
			int currentDayOfWeek = currentCalendar.get(Calendar.DAY_OF_WEEK);
			switch (currentDayOfWeek) {
			case 6:
				currentDayOfKpiWeek = 1;
				break;
			case 7:
				currentDayOfKpiWeek = 2;
				break;
			case 1:
				currentDayOfKpiWeek = 3;
				break;
			case 2:
				currentDayOfKpiWeek = 4;
				break;
			case 3:
				currentDayOfKpiWeek = 5;
				break;
			case 4:
				currentDayOfKpiWeek = 6;
				break;
			case 5:
				currentDayOfKpiWeek = 7;
				break;
			}

			currentYearStartTime.setTime(currentYearStartTime.getTime()
					- (currentDayOfKpiWeek - 1) * 24 * 60 * 60 * 1000);

			if (Integer.parseInt(yearSimpleDateFormat
					.format(currentYearStartTime)) == Integer
					.parseInt(yearSimpleDateFormat.format(dataTime)) - 1) {
				currentYearStartTime.setTime(currentYearStartTime.getTime() + 7
						* 24 * 60 * 60 * 1000);
			}

			// 最后一周如果跨年，算上一年的最后一周
			int currentKpiWeek = (int) Math
					.floor((dataTime.getTime() - currentYearStartTime.getTime())
							/ (24 * 60 * 60 * 1000 * 7.0)) + 1;
			int yearKpiWeek = 0;

			if (currentKpiWeek == 0) {
				Date lastYearEndTime = simpleDateFormat.parse(String.format(
						"%s-01-01",
						String.valueOf(Integer.parseInt(yearSimpleDateFormat
								.format(dataTime)))));
				lastYearEndTime.setTime(lastYearEndTime.getTime() - 24 * 60
						* 60 * 1000);
				yearKpiWeek = getItem(lastYearEndTime).getKpiYearWeek();
			} else {
				yearKpiWeek = Integer.parseInt(Integer
						.parseInt(yearSimpleDateFormat.format(dataTime))
						+ decimalFormat.format(currentKpiWeek));
			}

			int yearQuarter = 0;
			int dayOfQuarter = 0;

			if (dataTime.getMonth() == 1 || dataTime.getMonth() == 2
					|| dataTime.getMonth() == 3) {
				yearQuarter = Integer
						.parseInt(Integer.parseInt(yearSimpleDateFormat
								.format(dataTime)) + "01");

				int totalDays = (int) ((dataTime.getTime() - simpleDateFormat
						.parse(String.format("%s-01-01",
								String.valueOf(Integer
										.parseInt(yearSimpleDateFormat
												.format(dataTime))))).getTime()) / (24 * 60 * 60 * 1000 * 1.0));

				dayOfQuarter = totalDays + 1;
			} else if (dataTime.getMonth() == 4 || dataTime.getMonth() == 5
					|| dataTime.getMonth() == 6) {
				yearQuarter = Integer
						.parseInt(Integer.parseInt(yearSimpleDateFormat
								.format(dataTime)) + "02");

				int totalDays = (int) ((dataTime.getTime() - simpleDateFormat
						.parse(String.format("%s-04-01",
								String.valueOf(Integer
										.parseInt(yearSimpleDateFormat
												.format(dataTime))))).getTime()) / (24 * 60 * 60 * 1000 * 1.0));

				dayOfQuarter = totalDays + 1;
			} else if (dataTime.getMonth() == 7 || dataTime.getMonth() == 8
					|| dataTime.getMonth() == 9) {
				yearQuarter = Integer
						.parseInt(Integer.parseInt(yearSimpleDateFormat
								.format(dataTime)) + "03");

				int totalDays = (int) ((dataTime.getTime() - simpleDateFormat
						.parse(String.format("%s-07-01",
								String.valueOf(Integer
										.parseInt(yearSimpleDateFormat
												.format(dataTime))))).getTime()) / (24 * 60 * 60 * 1000 * 1.0));

				dayOfQuarter = totalDays + 1;
			} else {
				yearQuarter = Integer
						.parseInt(Integer.parseInt(yearSimpleDateFormat
								.format(dataTime)) + "04");

				int totalDays = (int) ((dataTime.getTime() - simpleDateFormat
						.parse(String.format("%s-10-01",
								String.valueOf(Integer
										.parseInt(yearSimpleDateFormat
												.format(dataTime))))).getTime()) / (24 * 60 * 60 * 1000 * 1.0));

				dayOfQuarter = totalDays + 1;
			}

			SlCalendarItem result = new SlCalendarItem();

			result.setDate(dataTime);
			result.setYear(Integer.parseInt(yearSimpleDateFormat
					.format(dataTime)));
			result.setYearMonth(Integer.parseInt(new SimpleDateFormat("yyyyMM")
					.format(dataTime)));
			result.setYearMonthDay(Integer.parseInt(new SimpleDateFormat(
					"yyyyMMdd").format(dataTime)));

			result.setKpiYearWeek(yearKpiWeek);

			result.setKpiYearWeekDay(Integer.parseInt(yearKpiWeek
					+ decimalFormat.format(dayOfKpiWeek)));

			{
				Calendar c = Calendar.getInstance();
				c.setTime(dateTime);
				int w = c.get(Calendar.WEEK_OF_YEAR);
				result.setYearWeek(Integer.parseInt(Integer
						.parseInt(yearSimpleDateFormat.format(dateTime))
						+ decimalFormat.format(w)));
			}

			{
				Calendar c = Calendar.getInstance();
				c.setTime(dateTime);
				int w = c.get(Calendar.WEEK_OF_YEAR);
				int d = c.get(Calendar.DAY_OF_YEAR);
				result.setYearWeekDay(Integer.parseInt(Integer
						.parseInt(yearSimpleDateFormat.format(dateTime))
						+ decimalFormat.format(w) + decimalFormat.format(d + 1)));
			}

			result.setYearQuarter(yearQuarter);
			result.setYearQuarterDay(Integer.parseInt(yearQuarter
					+ decimalFormat.format(dayOfQuarter)));

			return result;
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}
}
