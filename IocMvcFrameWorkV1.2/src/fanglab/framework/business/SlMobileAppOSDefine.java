package fanglab.framework.business;

/*
 * �ƶ��Ĳ���ϵͳ����
 */
public class SlMobileAppOSDefine {
	/*
	 * ��ñ��
	 * 
	 * @param String name������
	 * 
	 * @return int�����
	 */
	public static int getID(String name) {
		if (name.indexOf("android") >= 0) {
			return 1;
		} else if (name.indexOf("ios") >= 0 || name.indexOf("ipad") >= 0
				|| name.indexOf("iphone") >= 0) {
			return 2;
		} else if (name.indexOf("wp") >= 0) {
			return 3;
		} else if (name.indexOf("symbian") >= 0) {
			return 4;
		} else {
			// ����
			return 99;
		}
	}
}
