package fanglab.framework.security;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import fanglab.framework.text.*;

/*
 * DES安全
 */
public class SlDes {
	/*
	 * 加密方法
	 * 
	 * @param String input，待加密的字符串
	 * 
	 * @param String password，加密的密码（只能为8位长）
	 * 
	 * @return String，加密之后的文本
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
	 * 加密方法
	 * 
	 * @param String input，待加密的字符串
	 * 
	 * @param String password，加密的密码（只能为8位长）
	 * 
	 * @return String，加密之后的文本
	 */
	public static String encrypt(String input, String password) {
		return encrypt(input, password, "utf8");
	}

	/*
	 * 解密方法
	 * 
	 * @param String input，待解密的字符串
	 * 
	 * @param String password，解密的密码（只能为8位长）
	 * 
	 * @return String，解密之后的文本
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
	 * 解密方法
	 * 
	 * @param String input，待解密的字符串
	 * 
	 * @param String password，解密的密码（只能为8位长）
	 * 
	 * @return String，解密之后的文本
	 */
	public static String decrypt(String input, String password) {
		return decrypt(input, password, "utf8");
	}
}
