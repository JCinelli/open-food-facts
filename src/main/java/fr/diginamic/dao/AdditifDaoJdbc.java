package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.db.DbConnection;
import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Marque;
import fr.diginamic.utils.AntiDoublons;

public class AdditifDaoJdbc {

	List<Additif> listAdd = AntiDoublons.getListAdd();

	public void insertAllCsv() {

		Connection connection = null;

		List<Additif> listAddFromDb = findAll();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requeteInsert = connection.prepareStatement("INSERT INTO additif (nom) VALUES (?)");

			if (listAddFromDb.size() == 0) {

				for (Additif add : listAdd) {

					requeteInsert.setString(1, add.getNom());
					requeteInsert.executeUpdate();

				}
			}

			requeteInsert.close();

		} catch (Exception e) {

			System.err.println("Erreur d'execution : " + e.getMessage());

		} finally {

			try {

				if (connection != null) {

					connection.close();

				}

			} catch (SQLException e2) {

				System.err.println("Problème de connection close : " + e2.getMessage());

			}
		}

	}
	
	public void insert(Additif additif) {

	}

	public List<Additif> findAll() {

		Connection connection = null;
		List<Additif> listAdd = new ArrayList<Additif>();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requete = connection.prepareStatement("SELECT * FROM additif");

			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {

				listAdd.add(new Additif(resultat.getInt("id"), resultat.getString("nom")));

			}

			requete.close();
			resultat.close();

		} catch (Exception e) {

			System.err.println("Erreur d'execution : " + e.getMessage());

		} finally {

			try {

				if (connection != null) {

					connection.close();

				}

			} catch (SQLException e2) {

				System.err.println("Problème de connection close : " + e2.getMessage());

			}

		}

		return listAdd;

	}
	
}
