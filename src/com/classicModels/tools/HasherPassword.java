package com.classicModels.tools;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;

public class HasherPassword {
	public final Integer DEFAULT_ITERATIONS = 10000;
	public final String algorithm = "pbkdf2_sha256";

	public HasherPassword() {
	}

	public String getEncodedHash(String password, String salt, int iterations) {
		// Retourne seulement la derniere partie du password encodé
		SecretKeyFactory keyFactory = null;
		try {
			keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Could NOT retrieve PBKDF2WithHmacSHA256 algorithm");
			System.exit(1);
		}
		KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(Charset.forName("UTF-8")), iterations,
				256);
		SecretKey secret = null;
		try {
			secret = keyFactory.generateSecret(keySpec);
		} catch (InvalidKeySpecException e) {
			System.out.println("Could NOT generate secret key");
			e.printStackTrace();
		}

		byte[] rawHash = secret.getEncoded();
		byte[] hashBase64 = Base64.getEncoder().encode(rawHash);
		System.out.println(new String(hashBase64));
		return new String(hashBase64);
	}

	public String encode(String password, String salt, int iterations) {
		// retouren le mot de passe crypté, obtenu avec l'algorythme, le nombre
		// d'itération, et la clé

		String hash = getEncodedHash(password, salt, iterations);
		System.out.println("string encode :" + hash);
		return String.format("%s$%d$%s$%s", algorithm, iterations, salt, hash);
	}

	public String encode(String password, String salt) {
		return this.encode(password, salt, this.DEFAULT_ITERATIONS);
	}

	public boolean checkPassword(String password, String hashedPassword) {
		// password Hashé contient : l'agorythme, nombre d'itération, la clé
		// la partie crypté est jointe avec le caractere ("$")

		String[] parts = hashedPassword.split("\\$");
		if (parts.length != 4) {
			// wrong hash format
			return false;
		}
		Integer iterations = Integer.parseInt(parts[1]);
		String salt = parts[2];
		String hash = encode(password, salt, iterations);
		System.out.println("password :" + password + " HashedPassword :" + hashedPassword);

		return hash.equals(hashedPassword);
	}

	public static void hasherBdd() {
		String password = "";
		// Définition de la clé d'encryptage
		String salt = "19680626";

		LoginsDTO login = ManagerFactory.getlogins();
		LoginsDTO loginsource = ManagerFactory.getlogins();
		// Modification des passwords de la base de données
		List<AbstractDTO> logins = LoginsManager.listAll();
		for (int i = 0; i < logins.size(); i++) {
			loginsource = (LoginsDTO) logins.get(i);
			login = (LoginsDTO) logins.get(i);
			password = login.getPasswordLogin();
			HasherPassword hasher = new HasherPassword();
			hasher.getEncodedHash(password, salt, 16);
			String resultHash = hasher.encode(password, salt);
			login.setPasswordLogin(resultHash);
			System.out.println("resultat :" + login.getPasswordLogin());

			System.out.println("password :" + password);
			LoginsManager.update(loginsource, login);

		}
	}

}