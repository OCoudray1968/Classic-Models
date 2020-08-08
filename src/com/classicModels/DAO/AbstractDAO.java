package com.classicModels.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.classicModels.DTO.AbstractDTO;
import com.classicModels.bdd.Connexion;
import com.classicModels.tools.StringTools;

/**
 * Méthodes génériques d'accès à la base de données
 * 
 *
 *
 */
public abstract class AbstractDAO implements iDAO {

	/*
	 * Insertion d'enregistrement On part du principe que tous les champs sont à
	 * enregistrer.
	 * 
	 * Insérer une ligne en spécifiant toutes les colonnes La requête sql est INSERT
	 * INTO table VALUES ('valeur 1', 'valeur 2', ...)
	 */
	public void create(AbstractDTO bean) {

		// Nom de la table
		String tableName = StringTools.getNameFromClass(bean);

		// GENERATION DE LA REQUETE
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ").append(tableName).append(" VALUES (");

		sb.append(generateINSERTquery(bean));

		sb.append(")");
		System.out.println("requete dans Create :" + sb);
		// On envoie la sauce
		Connection con = Connexion.getInstance();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			try {
				stmt.execute(sb.toString());
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Mise à jour d'un enregistrement. On part du principe que l'identifiant de la
	 * table est donné pour la clause where et que tout le reste sont les valeurs à
	 * mettre à jour.
	 * 
	 * La requête sql est UPDATE table SET colonne_1 = 'valeur 1', colonne_2 =
	 * 'valeur 2', colonne_3 = 'valeur 3' WHERE condition
	 */
	public void update(AbstractDTO bean) {
		// Nom de la table
		String tableName = StringTools.getNameFromClass(bean);

		// GENERATION DE LA REQUETE
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ").append(tableName).append(" SET ");

		sb.append(generateUPDATEquery(bean));
		System.out.println("requete MAJ :" + sb);
		// On lance l'execution
		Connection con = Connexion.getInstance();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			try {
				stmt.execute(sb.toString());
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Suppression d'un enregistrement.
	 * 
	 * DELETE FROM table WHERE condition
	 */

	/**
	 * Retourne un seul enregistrement
	 * 
	 * @param bean
	 * @return
	 */
	public AbstractDTO getRecord(AbstractDTO bean) {
		List<AbstractDTO> l = listAll(bean);
		return l.get(0);
	}

	/**
	 * Retourne une collection d'enregistrements
	 * 
	 * @param bean
	 * @return
	 */
	public List<AbstractDTO> listAll(AbstractDTO bean) {
		// Récupération du nom de la table
		String tableName = StringTools.getNameFromClass(bean);

		// GENERATION DE LA REQUETE
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(tableName).append(" ");

		sb.append(generateWHEREquery(bean));
		System.out.println("Requete list All :" + sb);
		// On lance l'execution
		Statement stmt = null;
		Connection con = Connexion.getInstance();
		List<AbstractDTO> liste = new ArrayList<AbstractDTO>();
		try {
			stmt = con.createStatement();
			try {
				liste = makeList(stmt.executeQuery(sb.toString()));
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public void delete(AbstractDTO bean) {
		// Récupération du nom de la table
		String tableName = StringTools.getNameFromClass(bean);

		// GENERATION DE LA REQUETE
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ").append(tableName).append(" ");

		sb.append(generateDeletequery(bean));
		System.out.println("requete delete: " + sb);

		// On lance l'execution
		Statement stmt = null;
		Connection con = Connexion.getInstance();

		try {
			stmt = con.createStatement();
			try {
				stmt.executeUpdate(sb.toString());
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<AbstractDTO> commandeATraiter(AbstractDTO bean) {
		// Récupération du nom de la table
		String tableName = StringTools.getNameFromClass(bean);

		// GENERATION DE LA REQUETE
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT o.*,c.* FROM ").append(tableName).append(" c JOIN orders o ");

		sb.append(generateUnionQuery(bean));

		// On lance l'execution
		Statement stmt = null;
		Connection con = Connexion.getInstance();
		List<AbstractDTO> liste = new ArrayList<AbstractDTO>();
		try {
			stmt = con.createStatement();
			try {
				liste = makeListOrdersInProcess(stmt.executeQuery(sb.toString()));
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public List<AbstractDTO> listOrderDetail(AbstractDTO bean) {
		// Récupération du nom de la table
		String tableName = StringTools.getNameFromClass(bean);

		// GENERATION DE LA REQUETE
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT orderNumber, orderdetails.productCode,quantityOrdered,priceEach,orderLineNumber FROM ")
				.append(tableName).append(" ");

		sb.append(generateWHEREquery(bean));

		// On lance l'execution
		Statement stmt = null;
		Connection con = Connexion.getInstance();
		List<AbstractDTO> liste = new ArrayList<AbstractDTO>();
		try {
			stmt = con.createStatement();
			try {
				liste = makeList(stmt.executeQuery(sb.toString()));
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public List<AbstractDTO> listLast(AbstractDTO bean) {
		// Récupération du nom de la table
		String tableName = StringTools.getNameFromClass(bean);

		// GENERATION DE LA REQUETE
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(tableName).append(" ");

		sb.append(generateLASTquery(bean));

		System.out.println("Requete de Listlast :" + sb);
		// On lance l'execution
		Statement stmt = null;
		Connection con = Connexion.getInstance();
		List<AbstractDTO> liste = new ArrayList<AbstractDTO>();
		try {
			stmt = con.createStatement();
			try {
				liste = makeList(stmt.executeQuery(sb.toString()));
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}
