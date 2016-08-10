package fanglab.framework.business;

/*
 * 渠道定义
 */
public class SlMobileAppCompanyDefine {
	/*
	 * 获得编号
	 * 
	 * @param String name，名称
	 * 
	 * @return String，结果
	 */
	public static String getID(String name) {
		try {
			Long.parseLong(name);
			return name;
		} catch (Exception e) {

		}
		// 其他
		return "0";
	}
}
