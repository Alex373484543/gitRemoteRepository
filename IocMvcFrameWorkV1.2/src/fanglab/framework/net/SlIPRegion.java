package fanglab.framework.net;

import java.io.*;
import java.util.zip.*;
import java.util.*;

public class SlIPRegion {

	/*
	 * 所有
	 */
	public static HashMap<Integer, SlIPRegion> All = new HashMap<Integer, SlIPRegion>();

	/*
	 * 静态构造函数
	 */
	static {
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = new SlIPRegion().getClass()
					.getResourceAsStream("/IP.gz");
			GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
			bufferedReader = new BufferedReader(new InputStreamReader(
					gzipInputStream, "utf8"));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				try {
					String[] fileds = line.split("\\^");
					SlIPRegion ipRegion = new SlIPRegion();
					ipRegion.ID = Integer.parseInt(fileds[0]);
					ipRegion.StartValue = Long.parseLong(fileds[1]);
					ipRegion.EndValue = Long.parseLong(fileds[2]);
					ipRegion.Country = fileds[3];
					ipRegion.Province = fileds[4];
					ipRegion.City = fileds[5];
					ipRegion.StartIP = fileds[6];
					ipRegion.EndIP = fileds[7];
					All.put(ipRegion.ID, ipRegion);
				} catch (Exception e) {

				}
			}

			bufferedReader.close();
		} catch (Exception e) {

		}
	}

	/*
	 * 编号
	 */
	public int ID;

	/*
	 * 开始值
	 */
	public long StartValue;

	/*
	 * 结束值
	 */
	public long EndValue;

	/*
	 * 国家
	 */
	public String Country;

	/*
	 * 省份
	 */
	public String Province;

	/*
	 * 城市
	 */
	public String City;

	/*
	 * 开始IP
	 */
	public String StartIP;

	/*
	 * 结束IP
	 */
	public String EndIP;
}
