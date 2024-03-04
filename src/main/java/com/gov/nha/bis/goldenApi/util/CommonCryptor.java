package com.gov.nha.bis.goldenApi.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Ankur Kaushik
 */
public class CommonCryptor {
	private static final String key = "0123456789012345";
	private static final String initVector = "0000000000000000";

	public static String encrypt(String value) {
		try {
			
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			System.out.println(key.length());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			return new String(Base64.getEncoder().encode(encrypted));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String encrypted) throws Exception {

		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] base64decoded = Base64.getDecoder().decode(encrypted.getBytes());
		byte[] original = cipher.doFinal(base64decoded);

		return new String(original);

	}
	public static String encryptForAadhaar(String value,String keyvalue) {
		try {
			
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(keyvalue.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			return new String(Base64.getEncoder().encode(encrypted));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String decryptForAadhaar(String encrypted,String keyvalue) throws Exception {

		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
		SecretKeySpec skeySpec = new SecretKeySpec(keyvalue.getBytes("UTF-8"), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] base64decoded = Base64.getDecoder().decode(encrypted.getBytes());
		byte[] original = cipher.doFinal(base64decoded);

		return new String(original);

	}
	
//	public static void main(String args[]) {
//		try {
//			String str=encrypt("528145925931");
//			System.out.println(str);
//			System.out.println(decrypt(str));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
