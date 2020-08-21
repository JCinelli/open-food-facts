package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.db.DbConnection;
import fr.diginamic.entities.Article;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.utils.Hydrator;

public class ArticleDaoJdbc {

	List<Article> listArtHydrate = Hydrator.hydrateArticle();

	public void insertAllCsv() {

		Connection connection = null;

		List<Article> listArtFromDb = findAll();
		
		try {

			connection = DbConnection.getConnection();

			PreparedStatement requeteInsert = connection
					.prepareStatement("INSERT INTO article (`id_cat`, `id_mar`, `nom`, `grade`, `energie100g`, "
							+ "`graisse100g`, `sucres100g`, `fibres100g`, `proteines100g`, `sel100g`, `vitA100g`, `vitD100g`, `vitE100g`, `vitK100g`, "
							+ "`vitC100g`, `vitB1100g`, `vitB2100g`, `vitPP100g`, `vitB6100g`, `vitB9100g`, `vitB12100g`, `calcium100g`, `magnesium100g`, "
							+ "`iron100g`, `fer100g`, `betaCarotene100g`, `presenceHuilePalme`) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			PreparedStatement requeteVerifActicleIngredient = connection.prepareStatement("SELECT * FROM article_ingredient WHERE "
					 + "id_art = ? AND id_ing = ?");
			
			PreparedStatement requeteInsertActicleIngredient = connection.prepareStatement("INSERT INTO article_ingredient (`id_art`, `id_ing`)"
																						 + "VALUES (?, ?)"); 

			if (listArtFromDb.size() == 0) {

				for (Article article : listArtHydrate) {

					requeteInsert.setInt(1, article.getCategorie().getId());
					requeteInsert.setInt(2, article.getMarque().getId());
					requeteInsert.setString(3, article.getNom());
					requeteInsert.setString(4, article.getNutritionGradeFr());
					requeteInsert.setDouble(5, article.getEnergie100g());
					requeteInsert.setDouble(6, article.getGraisse100g());
					requeteInsert.setDouble(7, article.getSucres100g());
					requeteInsert.setDouble(8, article.getFibres100g());
					requeteInsert.setDouble(9, article.getProteines100g());
					requeteInsert.setDouble(10, article.getSel100g());
					requeteInsert.setDouble(11, article.getVitA100g());
					requeteInsert.setDouble(12, article.getVitD100g());
					requeteInsert.setDouble(13, article.getVitE100g());
					requeteInsert.setDouble(14, article.getVitK100g());
					requeteInsert.setDouble(15, article.getVitC100g());
					requeteInsert.setDouble(16, article.getVitB1100g());
					requeteInsert.setDouble(17, article.getVitB2100g());
					requeteInsert.setDouble(18, article.getVitPP100g());
					requeteInsert.setDouble(19, article.getVitB6100g());
					requeteInsert.setDouble(20, article.getVitB9100g());
					requeteInsert.setDouble(21, article.getVitB12100g());
					requeteInsert.setDouble(22, article.getCalcium100g());
					requeteInsert.setDouble(23, article.getMagnesium100g());
					requeteInsert.setDouble(24, article.getIron100g());
					requeteInsert.setDouble(25, article.getFer100g());
					requeteInsert.setDouble(26, article.getBetaCarotene100g());
					requeteInsert.setDouble(27, article.getPresenceHuilePalme());
					requeteInsert.executeUpdate();
					
					ResultSet rs = requeteInsert.getGeneratedKeys();
					
					while (rs.next()) {

						article.setId(rs.getInt(1));
						
					}
					
					
					
					for (Ingredient ingredient : article.getListIngredients()) {
					
						requeteVerifActicleIngredient.setInt(1, article.getId());
						requeteVerifActicleIngredient.setInt(2, ingredient.getId());
						ResultSet rs2 = requeteVerifActicleIngredient.executeQuery();
						
						if (!rs2.next()) {
						
							requeteInsertActicleIngredient.setInt(1, article.getId());
							requeteInsertActicleIngredient.setInt(2, ingredient.getId());
							
							if (ingredient.getId() != 0) {
								requeteInsertActicleIngredient.executeUpdate();	
							}
							
							
						}
						
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

	public List<Article> findAll() {

		CategorieDaoJdbc catDao = new CategorieDaoJdbc();
		MarqueDaoJdbc marDao = new MarqueDaoJdbc();

		Connection connection = null;
		List<Article> listArt = new ArrayList<Article>();

		try {

			connection = DbConnection.getConnection();

			PreparedStatement requete = connection.prepareStatement("SELECT * FROM article");

			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {

				listArt.add(new Article(resultat.getInt("id"), resultat.getInt("id_cat"),
						resultat.getInt("id_mar"), resultat.getString("nom"),
						resultat.getString("grade"), resultat.getDouble("energie100g"),
						resultat.getDouble("graisse100g"), resultat.getDouble("sucres100g"),
						resultat.getDouble("fibres100g"), resultat.getDouble("proteines100g"),
						resultat.getDouble("sel100g"), resultat.getDouble("vitA100g"), resultat.getDouble("vitD100g"),
						resultat.getDouble("vitE100g"), resultat.getDouble("vitK100g"), resultat.getDouble("vitC100g"),
						resultat.getDouble("vitB1100g"), resultat.getDouble("vitB2100g"),
						resultat.getDouble("vitPP100g"), resultat.getDouble("vitB6100g"),
						resultat.getDouble("vitB9100g"), resultat.getDouble("vitB12100g"),
						resultat.getDouble("calcium100g"), resultat.getDouble("magnesium100g"),
						resultat.getDouble("iron100g"), resultat.getDouble("fer100g"),
						resultat.getDouble("betaCarotene100g"), resultat.getDouble("presenceHuilePalme")));

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

		return listArt;
	}

}
