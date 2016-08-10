package fanglab.framework.security;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import fanglab.framework.text.*;

/*
 * DES��ȫ
 */
public class SlDes {
	/*
	 * ���ܷ���
	 * 
	 * @param String input�������ܵ��ַ���
	 * 
	 * @param String password�����ܵ����루ֻ��Ϊ8λ����
	 * 
	 * @return String������֮����ı�
	 */
	public static String encrypt(String input, String password, String encoding) {
		try {
			SecureRandom secureRandom = new SecureRandom();
			DESKeySpec desKeySpec = new DESKeySpec(password.getBytes());
			SecretKeyFactory secretKeyFactory = SecretKeyFactory
					.getInstance("DES");
			SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, secureRandom);
			byte[] output = cipher.doFinal(input.getBytes(encoding));
			return new String(SlHex.toHex(output), "UTF8");
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * ���ܷ���
	 * 
	 * @param String input�������ܵ��ַ���
	 * 
	 * @param String password�����ܵ����루ֻ��Ϊ8λ����
	 * 
	 * @return String������֮����ı�
	 */
	public static String encrypt(String input, String password) {
		return encrypt(input, password, "utf8");
	}

	/*
	 * ���ܷ���
	 * 
	 * @param String input�������ܵ��ַ���
	 * 
	 * @param String password�����ܵ����루ֻ��Ϊ8λ����
	 * 
	 * @return String������֮����ı�
	 */
	public static String decrypt(String input, String password, String encoding) {
		try {
			SecureRandom secureRandom = new SecureRandom();
			DESKeySpec desKeySpec = new DESKeySpec(password.getBytes());
			SecretKeyFactory secretKeyFactory = SecretKeyFactory
					.getInstance("DES");
			SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, secureRandom);
			byte[] output = cipher
					.doFinal(SlHex.fromHex(input.getBytes("UTF8")));
			return new String(output, encoding);
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * ���ܷ���
	 * 
	 * @param String input�������ܵ��ַ���
	 * 
	 * @param String password�����ܵ����루ֻ��Ϊ8λ����
	 * 
	 * @return String������֮����ı�
	 */
	public static String decrypt(String input, String password) {
		return decrypt(input, password, "utf8");
	}
}
