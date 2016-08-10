package fanglab.framework.data;

import java.text.*;
import java.util.*;

/*
 * ��������
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
	 * ��ʼʱ��
	 */
	public static Date StartDateTime;

	/*
	 * ����ʱ��
	 */
	public static Date EndDateTime;

	/*
	 * ��ʼ����
	 */
	public static Date StartDate;

	/*
	 * ��������
	 */
	public static Date EndDate;

	/*
	 * �Ƿ�Ϸ���ʱ��
	 * 
	 * @param Date dateTime��ʱ��
	 * 
	 * @return boolean�����
	 */
	public static boolean isLegalDateTime(Date dateTime) {
		if (dateTime.before(StartDateTime) || dateTime.after(EndDateTime)) {
			return false;
		}

		return true;
	}
}
