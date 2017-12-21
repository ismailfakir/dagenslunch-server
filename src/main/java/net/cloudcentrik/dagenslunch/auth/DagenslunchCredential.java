package net.cloudcentrik.dagenslunch.auth;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;

public final class DagenslunchCredential {

	public static final String USER_ROLE = "DAGENSLUNCH_CUSTOMER";
	public static final String USER_NAME = "customer";
	public static final String USER_PASSWORD = "secret";
	
	public static final String API_KEY = "api_key";
	public static final String API_SECRET = "api_secret";

	// user credential
	private static final HashMap<String, String> customerApiKeyMap = new HashMap<String, String>();

	// create access token
	/*public static AccessToken getAccessToken(int len) {

		AccessToken token = new AccessToken();
		try {
			token.setApiKey(generateApiKey(len));
			token.setApiSecret(generateApiSecret(len));

			customerApiKeyMap.put(token.getApiKey(), token.getApiSecret());
			return token;

		} catch (Exception e) {

		}

		return token;
	}*/

	public static String getSecretKeyFromApiKey(String apiKey) {

		return customerApiKeyMap.get(apiKey);
	}
	
	public static void removeAccessToken() {
		
	}

	private static void addApiKey() {
		customerApiKeyMap.put("apikey", "secret");
		customerApiKeyMap.put("admin", "123456789");
		customerApiKeyMap.put("user", "987654321");
	}

	private static String genPassword(int length) throws NoSuchAlgorithmException {
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

	private static String generateApiKey(int length) throws NoSuchAlgorithmException {
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

	private static String generateApiSecret(int length) throws NoSuchAlgorithmException {
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

	private static void keyPairGenerator() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");

			// Initialize KeyPairGenerator.
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			keyGen.initialize(1024, random);

			// Generate Key Pairs, a private key and a public key.
			KeyPair keyPair = keyGen.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();

			Base64.Encoder encoder = Base64.getEncoder();
			System.out.println("privateKey: " + encoder.encodeToString(privateKey.getEncoded()));
			System.out.println("publicKey: " + encoder.encodeToString(publicKey.getEncoded()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// keyPairGenerator();
		try {
			System.out.println(generateApiSecret(12));

		} catch (Exception e) {

		}

	}

}
