package fanglab.framework.business;

/*
 * �绰���Ͷ���
 */
public class SlMobileAppPhoneTypeDefine {
	/*
	 * ��ñ��
	 * 
	 * @param String name������
	 * 
	 * @return int�����
	 */
	public static int getID(String name) {
		try {
			return Integer.parseInt(name);
		} catch (Exception e) {

		}
		// ����
		return -1;
	}
}
