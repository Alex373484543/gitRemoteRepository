package fanglab.framework.business;

/*
 * ��������
 */
public class SlMobileAppCompanyDefine {
	/*
	 * ��ñ��
	 * 
	 * @param String name������
	 * 
	 * @return String�����
	 */
	public static String getID(String name) {
		try {
			Long.parseLong(name);
			return name;
		} catch (Exception e) {

		}
		// ����
		return "0";
	}
}
