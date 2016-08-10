package fanglab.framework.data;

import java.text.*;
import java.util.*;

/*
 * 数据类型
 */
public class SlDbType {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	static {
		try {
			StartDateTime = simpleDateFormat.parse("1900-01-01 12:00:00");
			EndDateTime = simpleDateFormat.parse("2099-12-31 11:59:59");
			StartDate = simpleDateFormat.parse("1900-01-01 00:00:00");
			EndDate = simpleDateFormat.parse("2099-12-31 00:00:00");
		} catch (ParseException e) {

		}
	}

	/*
	 * 开始时间
	 */
	public static Date StartDateTime;

	/*
	 * 结束时间
	 */
	public static Date EndDateTime;

	/*
	 * 开始日期
	 */
	public static Date StartDate;

	/*
	 * 结束日期
	 */
	public static Date EndDate;

	/*
	 * 是否合法的时间
	 * 
	 * @param Date dateTime，时间
	 * 
	 * @return boolean，结果
	 */
	public static boolean isLegalDateTime(Date dateTime) {
		if (dateTime.before(StartDateTime) || dateTime.after(EndDateTime)) {
			return false;
		}

		return true;
	}
}
