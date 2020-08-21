package fr.diginamic.utils;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.dao.AdditifDaoJdbc;
import fr.diginamic.dao.AllergeneDaoJdbc;
import fr.diginamic.dao.CategorieDaoJdbc;
import fr.diginamic.dao.IngredientDaoJdbc;
import fr.diginamic.dao.MarqueDaoJdbc;
import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Allergene;
import fr.diginamic.entities.Article;
import fr.diginamic.entities.Categorie;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.entities.Marque;
import fr.diginamic.traitementFichier.LectureFichier;
import fr.diginamic.traitementFichier.ParserFichier;

public class Hydrator {

	static List<Article> listArt = AntiDoublons.getListArt();

	public static List<Article> hydrateArticle() {

		CategorieDaoJdbc catDao = new CategorieDaoJdbc();
		List<Categorie> listCat = catDao.findAll();

		MarqueDaoJdbc marDao = new MarqueDaoJdbc();
		List<Marque> listMar = marDao.findAll();
		
		AdditifDaoJdbc addDao = new AdditifDaoJdbc();
		List<Additif> listAdd = addDao.findAll();
		
		AllergeneDaoJdbc allDao = new AllergeneDaoJdbc();
		List<Allergene> listAll= allDao.findAll();
		
		IngredientDaoJdbc ingDao = new IngredientDaoJdbc();
		List<Ingredient> listIng = ingDao.findAll();

		for (Article article : listArt) {

			for (Categorie categorie : listCat) {

				if (categorie.getNom().equals(article.getCategorie().getNom())) {

					article.setCategorie(categorie);

				}

			}

			for (Marque marque : listMar) {

				if (marque.getNom().equals(article.getMarque().getNom())) {

					article.setMarque(marque);
				}

			}
			
			for (Ingredient ingredientArt : article.getListIngredients()) {
				
				for (Ingredient ingredient : listIng) {
					
					if (ingredientArt.getNom().equalsIgnoreCase(ingredient.getNom())) {
						
						ingredientArt.setId(ingredient.getId());
						
					}
					
				}
				
			}
			
			for (Allergene allergeneArt : article.getListAllergenes()) {
				
				for (Allergene allergene : listAll) {
					
					if (allergeneArt.getNom().equals(allergene.getNom())) {
						
						allergeneArt.setId(allergene.getId());
						
					}
					
				}
				
			}
			
			for (Additif additifArt : article.getListAdditifs()) {
				
				for (Additif additif : listAdd) {
					
					if (additifArt.getNom().equals(additif.getNom())) {
						
						additifArt.setId(additif.getId());
						
					}
					
				}
				
			}

		}
		
		List<Article> listArtHydrate = listArt;

		return listArtHydrate;

	}
}
