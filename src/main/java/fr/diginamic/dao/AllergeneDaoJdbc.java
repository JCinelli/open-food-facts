package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.db.DbConnection;
import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Allergene;
import fr.diginamic.utils.AntiDoublons;

public class AllergeneDaoJdbc {


	List<Allergene> listAll = AntiDoublons.getListAll();

	public void insertAllCsv() {

		Connection connection = null;

		List<Allergene> listAllFromDb = findAll();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requeteInsert = connection.prepareStatement("INSERT INTO allergene (nom) VALUES (?)");

			if (listAllFromDb.size() == 0) {

				for (Allergene all : listAll) {

					requeteInsert.setString(1, all.getNom());
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
	
	public void insert(Allergene allergene) {

	}

	public List<Allergene> findAll() {

		Connection connection = null;
		List<Allergene> listAll = new ArrayList<Allergene>();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requete = connection.prepareStatement("SELECT * FROM allergene");

			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {

				listAll.add(new Allergene(resultat.getInt("id"), resultat.getString("nom")));

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

		return listAll;

	}
	
}
