package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.db.DbConnection;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.utils.AntiDoublons;

public class IngredientDaoJdbc {

	List<Ingredient> listIng = AntiDoublons.getListIng();
	
	public List<Ingredient> findAll() {

		Connection connection = null;
		List<Ingredient> listIng = new ArrayList<Ingredient>();

		try {

			// Jeton de connexion et d'acces a la BDD
			connection = DbConnection.getConnection();

			PreparedStatement canal = connection.prepareStatement("SELECT * FROM ingredient");

			// Resultat retour de la requete
			ResultSet resultat = canal.executeQuery();

			while (resultat.next()) {

				listIng.add(new Ingredient(resultat.getInt("id"), resultat.getString("nom")));

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

		return listIng;

	}
	
	public void insertAllCsv() {

		Connection connection = null;

		List<Ingredient> listIngFromDb = findAll();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requeteInsert = connection.prepareStatement("INSERT INTO ingredient (nom) VALUES (?)");

			if (listIngFromDb.size() == 0) {

				for (Ingredient ing : listIng) {

					if (ing.getNom().length() < 100) {

						requeteInsert.setString(1, ing.getNom());
						requeteInsert.executeUpdate();
						
					}

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
	
	public void insert(Ingredient newIng) {
		
		Connection connection = null;
		
		List<Ingredient> listIngFromDb = findAll();
		
		try {

			// Jeton de connexion et d'acces a la BDD
			connection = DbConnection.getConnection();

			PreparedStatement requeteVerif = connection.prepareStatement("SELECT * FROM ingredient WHERE nom = ?");
			
			PreparedStatement requeteInsert = connection.prepareStatement("INSERT INTO ingredient (nom) VALUES (?)");

			requeteVerif.setString(1, newIng.getNom());
			
			// Resultat retour de la requete
			ResultSet resultat = requeteVerif.executeQuery();

			if (!resultat.next()) {
				
				requeteInsert.setString(1, newIng.getNom().toLowerCase());
				requeteInsert.executeUpdate();
				
				System.out.println("(Insertion effectuée !)");
				
			} else {
				
				System.out.println("(Ingredient deja en base !)");
				
			}

			resultat.close();
			requeteVerif.close();
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
	
	
	public void delete(Ingredient ing) {
		
		Connection connection = null;
				
		try {

			// Jeton de connexion et d'acces a la BDD
			connection = DbConnection.getConnection();
			
			PreparedStatement requeteDel = connection.prepareStatement("DELETE FROM ingredient WHERE nom = ?");
			requeteDel.setString(1, ing.getNom().toLowerCase());
			
			// Resultat retour de la requete
			int resultat = requeteDel.executeUpdate();

			if (resultat > 0) {
				
				System.out.println("(Suppression effectuée !)");
				
			} else {
				
				System.out.println("(Ingredient introuvable en base !)");
				
			}

			requeteDel.close();

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
}
