package fanglab.framework.security;

import java.math.*;
import java.security.*;

public class SlMd5 {
	/*
	 * ��ϣֵ
	 * 
	 * @param String input������
	 * 
	 * @return String�����
	 */
	public static String hashPassword(String input) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			byte[] digest = m.digest(input.getBytes("utf8"));
			String hash = new BigInteger(1, digest).toString(16);
			return hash.toUpperCase();
		} catch (Exception err) {
		}
		return "";
	}
}
