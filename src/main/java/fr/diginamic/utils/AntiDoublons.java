package fr.diginamic.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Allergene;
import fr.diginamic.entities.Article;
import fr.diginamic.entities.Categorie;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.entities.Marque;
import fr.diginamic.traitementFichier.LectureFichier;
import fr.diginamic.traitementFichier.ParserFichier;

public class AntiDoublons {

	static List<String> lignesFichier = LectureFichier.lireFichier();

	static List<Article> listArticles = ParserFichier.parseFichier(lignesFichier);

	public static List<Categorie> getListCat() {

		Set<String> setCat = new HashSet<>();
		List<Categorie> listCat = new ArrayList<>();

		for (Article article : listArticles) {

			setCat.add(article.getCategorie().getNom());

		}

		for (String str : setCat) {

			listCat.add(new Categorie(str));

		}

		return listCat;

	}

	public static List<Marque> getListMar() {

		Set<String> setMar = new HashSet<>();
		List<Marque> listMar = new ArrayList<>();

		for (Article article : listArticles) {

			setMar.add(article.getMarque().getNom());

		}

		for (String str : setMar) {

			listMar.add(new Marque(str));

		}

		return listMar;

	}

	public static List<Article> getListArt() {

		Set<Article> setArt = new HashSet<>();
		List<Article> listArt = new ArrayList<>();

		for (Article article : listArticles) {

			setArt.add(article);

		}

		for (Article art : setArt) {

			listArt.add(art);

		}

		return listArt;
	}

	public static List<Ingredient> getListIng() {

		Set<String> setIng = new HashSet<>();
		List<Ingredient> listIng = new ArrayList<>();

		for (Article article : listArticles) {

			List<Ingredient> listIngredientDeArticle = article.getListIngredients();
			
			for (Ingredient ingredient : listIngredientDeArticle) {
				
					setIng.add(ingredient.getNom().toLowerCase());
				
			}

		}

		for (String ing : setIng) {

			listIng.add(new Ingredient(ing));

		}

		return listIng;
	}
	
	public static List<Additif> getListAdd() {

		Set<String> setAdd = new HashSet<>();
		List<Additif> listAdd = new ArrayList<>();

		for (Article article : listArticles) {

			List<Additif> listAdditifsDeArticle = article.getListAdditifs();
			
			for (Additif additif : listAdditifsDeArticle) {
				
					setAdd.add(additif.getNom().toLowerCase());
				
			}

		}

		for (String str : setAdd) {

			listAdd.add(new Additif(str));

		}

		return listAdd;

	}
	
	public static List<Allergene> getListAll() {

		Set<String> setAll = new HashSet<>();
		List<Allergene> listAll = new ArrayList<>();

		for (Article article : listArticles) {

			List<Allergene> listAllergenesDeArticle = article.getListAllergenes();
			
			for (Allergene allergene : listAllergenesDeArticle) {
				
					setAll.add(allergene.getNom().toLowerCase());
				
			}

		}

		for (String str : setAll) {

			listAll.add(new Allergene(str));

		}

		return listAll;

	}

}
