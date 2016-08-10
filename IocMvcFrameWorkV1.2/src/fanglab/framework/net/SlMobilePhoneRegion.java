package fanglab.framework.net;

import java.io.*;
import java.util.zip.*;
import java.util.*;

public class SlMobilePhoneRegion {
	/*
	 * ����
	 */
    public static HashMap<String, SlMobilePhoneRegion> All = new HashMap<String, SlMobilePhoneRegion>();

    /*
	 * ��̬���캯��
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
	 * ���
	 */
    public int ID;

	/*
	 * �ֻ���ǰ׺
	 */
    public String MobileNumber;

	/*
	 * ����
	 */
    public String Country;

	/*
	 * ʡ��
	 */
    public String Province;

	/*
	 * ����
	 */
    public String City;

	/*
	 * ��Ӫ��
	 */
    public String MobileType;

	/*
	 * ����
	 */
    public String AreaCode;

	/*
	 * ��������
	 */
    public String PostCode;

   

	/*
	 * ͨ���ֻ���ȡ��������Ϣ
	 * 
	 * @param String mobilePhone���ֻ���
	 * 
	 * @param SlMobilePhoneRegion�����
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
