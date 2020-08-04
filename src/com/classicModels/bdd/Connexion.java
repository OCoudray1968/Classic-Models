package com.classicModels.bdd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Retourne une instance de connexion.
 * 
 * @author Olivier
 *
 */
public class Connexion {
	// Propriétés de l'objet
	private static String URL = null;
	private static String URL_BD = null;
	private static String LOGIN = null;
	private static String PASSWORD = null;

	/** Objet Connection */
	private static Connection connect;

	/** Constructeur privé */
	private Connexion() {
	}

	/**
	 * Retourne une instance de connexion ou la créer si elle n'existe pas...
	 * 
	 * @return
	 */
	public static Connection getInstance() {
		if (connect == null) {
			loadProperties();
			setURL();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {

				connect = DriverManager.getConnection(URL, LOGIN, PASSWORD);
				connect.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connect;
	}

	public static void closeConnection() {
		try {
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Charge la liste des propriétés contenues dans le fichier properties
	 * <code>connexion.properties</code>.
	 */
	public static void loadProperties() {
		Properties props = new Properties();

		String myFileSeparator = System.getProperty("file.separator");
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("user.dir")).append(myFileSeparator).append("connexion.properties");

		try (InputStream input = new FileInputStream(sb.toString())) {
			props.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		URL_BD = props.getProperty("URL_BD");
		LOGIN = props.getProperty("LOGIN");
		PASSWORD = props.getProperty("PASSWORD");
	}

	/**
	 * Accesseur
	 */
	private static void setURL() {
		StringBuilder sb = new StringBuilder();

		sb.append(URL_BD);

		URL = sb.toString();
	}
}
