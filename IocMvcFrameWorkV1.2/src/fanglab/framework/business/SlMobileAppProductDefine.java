package fanglab.framework.business;

/*
 * ��Ʒ����
 */
public class SlMobileAppProductDefine {
	/*
	 * ��ñ��
	 * 
	 * @param String name������
	 * 
	 * @return int�����
	 */
	public static int getID(String name) {
		if (name.endsWith("soufun")) {
			return 1;
		}
		if (name.endsWith("soufunbang")) {
			return 2;
		}
		if (name.endsWith("soufunrent")) {
			return 3;
		}
		if (name.endsWith("ipad_soufun")) {
			return 4;
		}
		if (name.endsWith("xfbang")) {
			return 5;
		}
		if (name.endsWith("tudi")) {
			return 6;
		}
		if (name.endsWith("shequ")) {
			return 7;
		}
		if (name.endsWith("pinggu")) {
			return 8;
		}
		if (name.endsWith("ipadhd_soufun")) {
			return 9;
		}
		if (name.endsWith("home")) {
			return 10;
		}
		if (name.endsWith("jiancai")) {
			return 11;
		}
		if (name.endsWith("sfhome")) {
			return 12;
		}
		if (name.endsWith("xfbang_jjr")) {
			return 13;
		}
		// ����
		return 99;
	}
}
