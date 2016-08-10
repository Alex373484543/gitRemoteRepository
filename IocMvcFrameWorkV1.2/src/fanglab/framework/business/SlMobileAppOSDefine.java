package fanglab.framework.business;

/*
 * 移动的操作系统定义
 */
public class SlMobileAppOSDefine {
	/*
	 * 获得编号
	 * 
	 * @param String name，名称
	 * 
	 * @return int，结果
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
			// 其他
			return 99;
		}
	}
}
