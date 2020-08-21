package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.db.DbConnection;
import fr.diginamic.entities.Categorie;
import fr.diginamic.utils.AntiDoublons;

public class CategorieDaoJdbc {

	List<Categorie> listCat = AntiDoublons.getListCat();

	public void insertAllCsv() {

		Connection connection = null;

		List<Categorie> listCatFromDb = findAll();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requeteInsert = connection.prepareStatement("INSERT INTO categorie (nom) VALUES (?)");

			if (listCatFromDb.size() == 0) {
				
				for (Categorie cat : listCat) {

					requeteInsert.setString(1, cat.getNom());
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

	public void insert(Categorie categorie) {

	}

	public List<Categorie> findAll() {

		Connection connection = null;
		List<Categorie> listCat = new ArrayList<Categorie>();

		try {

			// Jeton de connexion et d'acces a la BDD
			connection = DbConnection.getConnection();

			PreparedStatement canal = connection.prepareStatement("SELECT * FROM categorie");

			// Resultat retour de la requete
			ResultSet resultat = canal.executeQuery();

			while (resultat.next()) {

				listCat.add(new Categorie(resultat.getInt("id"), resultat.getString("nom")));

			}

			resultat.close();
			canal.close();

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

		return listCat;

	}

	public Categorie find(String nomCategorie) {

		Connection connection = null;

		Categorie catDeRetour = new Categorie(nomCategorie);

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requete = connection.prepareStatement("SELECT * FROM categorie WHERE nom = ?");

			requete.setString(1, nomCategorie);

			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {

				catDeRetour.setId(resultat.getInt("id"));
				catDeRetour.setNom(resultat.getString("nom"));
			}

			if (!resultat.next()) {

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

		return catDeRetour;

	}

	public Categorie findById(int IdCategorie) {

		Connection connection = null;

		Categorie catDeRetour = new Categorie(IdCategorie, "none");

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requete = connection.prepareStatement("SELECT * FROM categorie WHERE id = ?");

			requete.setInt(1, IdCategorie);

			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {

				catDeRetour.setId(resultat.getInt("id"));
				catDeRetour.setNom(resultat.getString("nom"));
			}

			if (catDeRetour.getNom().equals("none")) {

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

		return catDeRetour;

	}

}
