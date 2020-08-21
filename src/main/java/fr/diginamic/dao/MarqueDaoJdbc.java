package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.db.DbConnection;
import fr.diginamic.entities.Marque;
import fr.diginamic.utils.AntiDoublons;

public class MarqueDaoJdbc {

	List<Marque> listMar = AntiDoublons.getListMar();

	public void insertAllCsv() {

		Connection connection = null;

		List<Marque> listMarFromDb = findAll();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requeteInsert = connection.prepareStatement("INSERT INTO marque (nom) VALUES (?)");

			if (listMarFromDb.size() == 0) {

				for (Marque mar : listMar) {

					requeteInsert.setString(1, mar.getNom());
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

	public void insert(Marque marque) {

	}

	public List<Marque> findAll() {

		Connection connection = null;
		List<Marque> listMar = new ArrayList<Marque>();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requete = connection.prepareStatement("SELECT * FROM marque");

			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {

				listMar.add(new Marque(resultat.getInt("id"), resultat.getString("nom")));

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

		return listMar;

	}

	public Marque find(Marque marque) {

		Connection connection = null;

		Marque marDeRetour = marque;

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requete = connection.prepareStatement("SELECT * FROM marque WHERE nom = ?");

			requete.setString(1, marque.getNom());

			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {

				marDeRetour = new Marque(resultat.getInt("id"), resultat.getString("nom"));

			}

			if (marque.getId() == marDeRetour.getId()) {

				System.err.println("La marque (" + marDeRetour + ") n'existe pas en base ..");
				return null;

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

		return marDeRetour;

	}

	public Marque findById(int IdMarque) {

		Connection connection = null;

		Marque marDeRetour = new Marque(IdMarque, "none");

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requete = connection.prepareStatement("SELECT * FROM marque WHERE id = ?");

			requete.setInt(1, IdMarque);

			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {

				marDeRetour.setId(resultat.getInt("id"));
				marDeRetour.setNom(resultat.getString("nom"));
			}

			if (marDeRetour.getNom().equals("none")) {

				System.err.println("La catégorie en paramètre n'existe pas en base ..");
				return null;

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

		return marDeRetour;

	}
}
