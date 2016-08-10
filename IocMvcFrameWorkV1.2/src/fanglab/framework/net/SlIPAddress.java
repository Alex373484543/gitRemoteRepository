package fanglab.framework.net;

/*
 * IPAddress
 */
public class SlIPAddress {
	/*
	 * IP转换为数字
	 * 
	 * @param String ip，IP地址
	 * 
	 * @param long，结果
	 */
	public static long toNumber(String ip) {
		try {
			String[] ips = ip.split("\\.");
			return Long.parseLong(ips[0]) * 256 * 256 * 256
					+ Long.parseLong(ips[1]) * 256 * 256
					+ Long.parseLong(ips[2]) * 256 + Long.parseLong(ips[3]);
		} catch (Exception e) {
			return -1;
		}
	}

	/*
	 * 数字转换为IP
	 * 
	 * @param String ipValue，ipValue
	 * 
	 * @return String，结果
	 */
	public static String toIP(long ipValue) {
		try {
			String ip = "";

			for (int i = 4; i > 0; i--) {
				ip = String.valueOf(ipValue % 256) + "." + ip;
				ipValue = ipValue / 256;
			}
			return ip.substring(0, ip.length() - 1);
		} catch (Exception e) {
			return "";
		}
	}
}
