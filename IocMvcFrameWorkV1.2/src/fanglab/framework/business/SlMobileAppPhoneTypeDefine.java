package fanglab.framework.business;

/*
 * 电话类型定义
 */
public class SlMobileAppPhoneTypeDefine {
	/*
	 * 获得编号
	 * 
	 * @param String name，名称
	 * 
	 * @return int，结果
	 */
	public static int getID(String name) {
		try {
			return Integer.parseInt(name);
		} catch (Exception e) {

		}
		// 其他
		return -1;
	}
}
