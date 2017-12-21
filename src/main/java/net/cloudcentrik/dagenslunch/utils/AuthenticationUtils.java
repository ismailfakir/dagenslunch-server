package net.cloudcentrik.dagenslunch.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import net.cloudcentrik.dagenslunch.core.Token;

public class AuthenticationUtils {

	// crient basic authentication crendientials
	private final static String SUPER_SECRET = "dagens_lunch:cloudcentrik_2015";

	private static String getMD5HashFromString(String passwordToHash) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();

			return generatedPassword;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	public static boolean isValidUserCrediential(String suppliedCrediantials) {

		String realCredialtials = getMD5HashFromString(SUPER_SECRET);
		if (realCredialtials.equals(suppliedCrediantials)) {
			return true;
		} else {
			return false;
		}

	}

	public static String generateApiKey(int length) throws NoSuchAlgorithmException {
		StringBuffer buffer = new StringBuffer();
		char[] characterMap = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

		for (int i = 0; i <= length; i++) {
			byte[] bytes = new byte[512];
			secureRandom.nextBytes(bytes);
			double number = secureRandom.nextDouble();
			int b = ((int) (number * characterMap.length));
			buffer.append(characterMap[b]);
		}
		return buffer.toString();
	}

	public static String generateApiSecret(int length) throws NoSuchAlgorithmException {
		StringBuffer buffer = new StringBuffer();
		char[] characterMap = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

		for (int i = 0; i <= length; i++) {
			byte[] bytes = new byte[512];
			secureRandom.nextBytes(bytes);
			double number = secureRandom.nextDouble();
			int b = ((int) (number * characterMap.length));
			buffer.append(characterMap[b]);
		}
		return buffer.toString();
	}

	public static Token getToken(int len) {
		try {
			String key = generateApiKey(len);
			String secret = generateApiSecret(len);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			int randomNum = ThreadLocalRandom.current().nextInt(1001, 100000 + 1);

			return new Token(randomNum, encode(key), encode(secret), time);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Token();
	}

	// Basic Base64 decoding
	private static String encode(String value) throws Exception {
		return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
	}

	// Basic Base64 decoding
	private static String decode(String value) throws Exception {
		byte[] decodedValue = Base64.getDecoder().decode(value); 
		return new String(decodedValue, StandardCharsets.UTF_8);
	}

	public static void main(String[] args) {
		String us = getMD5HashFromString(SUPER_SECRET);
		System.out.println(getMD5HashFromString(SUPER_SECRET));

	}
	
	public static String hash256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
}

}
