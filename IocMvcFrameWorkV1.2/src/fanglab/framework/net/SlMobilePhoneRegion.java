package fanglab.framework.net;

import java.io.*;
import java.util.zip.*;
import java.util.*;

public class SlMobilePhoneRegion {
	/*
	 * 所有
	 */
    public static HashMap<String, SlMobilePhoneRegion> All = new HashMap<String, SlMobilePhoneRegion>();

    /*
	 * 静态构造函数
	 */
	static {
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = new SlIPRegion().getClass()
					.getResourceAsStream("/MobilePhone.gz");
			GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
			bufferedReader = new BufferedReader(new InputStreamReader(
					gzipInputStream, "utf8"));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				try {
					String[] fileds = line.split("\\^");
					SlMobilePhoneRegion mobilePhoneRegion = new SlMobilePhoneRegion();
					mobilePhoneRegion.ID =Integer.parseInt(fileds[0]);
					mobilePhoneRegion.MobileNumber = fileds[1];
					mobilePhoneRegion.Country = fileds[2];
					mobilePhoneRegion.Province = fileds[3];
					mobilePhoneRegion.City = fileds[4];
					mobilePhoneRegion.MobileType = fileds[5];
					mobilePhoneRegion.AreaCode = fileds[6];
					mobilePhoneRegion.PostCode = fileds[7];
					All.put(mobilePhoneRegion.MobileNumber, mobilePhoneRegion);
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
	 * 手机号前缀
	 */
    public String MobileNumber;

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
	 * 运营商
	 */
    public String MobileType;

	/*
	 * 区号
	 */
    public String AreaCode;

	/*
	 * 邮政编码
	 */
    public String PostCode;

   

	/*
	 * 通过手机号取归属地信息
	 * 
	 * @param String mobilePhone，手机号
	 * 
	 * @param SlMobilePhoneRegion，结果
	 */
    public static SlMobilePhoneRegion Find(String mobilePhone)
    {
        try
        {
        	String mobileNumber=mobilePhone.substring(0,7);
            return All.get(mobileNumber);
        }
        catch(Exception e) { }
        return null;
    }

}
