package fanglab.framework.net;

/*
 * IPAddress
 */
public class SlIPAddress {
	/*
	 * IPת��Ϊ����
	 * 
	 * @param String ip��IP��ַ
	 * 
	 * @param long�����
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
	 * ����ת��ΪIP
	 * 
	 * @param String ipValue��ipValue
	 * 
	 * @return String�����
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
