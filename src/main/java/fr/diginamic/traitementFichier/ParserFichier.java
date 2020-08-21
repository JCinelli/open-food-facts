package fr.diginamic.traitementFichier;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Allergene;
import fr.diginamic.entities.Categorie;
import fr.diginamic.entities.Ingredient;
import fr.diginamic.entities.Marque;
import fr.diginamic.entities.Article;

public class ParserFichier {

	public static List<Article> parseFichier(List<String> lignesFichier) {
		
		List<Article> listProduits = new ArrayList<Article>();
		
//		Suppression de la premiere ligne car inutile
		lignesFichier.remove(0);
		
//		Parcours de chaque lignes du fichier
		for (String ligne : lignesFichier) {
			
			String ligneNet = ligne.replaceAll("'", " ");

			
//			Decoupages de la ligne en plusieurs morceaux correspondant aux attributs d'un produit
			String[] morceaux = ligneNet.split("\\|", -1);
			
			
			
			Categorie categorie = new Categorie(morceaux[0]);
			Marque marque = new Marque(morceaux[1]);
			String nom = morceaux[2];
			String grade = morceaux[3];
			List<Ingredient> listIngredients = Splitter.splitIngredients(morceaux[4]);
			double energie100g =  tryIfIsEmpty(morceaux[5]);
			double graisse100g =  tryIfIsEmpty(morceaux[6]);
			double sucres100g =  tryIfIsEmpty(morceaux[7]);
			double fibres100g =  tryIfIsEmpty(morceaux[8]);
			double proteines100g =  tryIfIsEmpty(morceaux[9]);
			double sel100g =  tryIfIsEmpty(morceaux[10]);
			double vitA100g =  tryIfIsEmpty(morceaux[11]);
			double vitD100g =  tryIfIsEmpty(morceaux[12]);
			double vitE100g =  tryIfIsEmpty(morceaux[13]);
			double vitK100g =  tryIfIsEmpty(morceaux[14]);
			double vitC100g =  tryIfIsEmpty(morceaux[15]);
			double vitB1100g =  tryIfIsEmpty(morceaux[16]);
			double vitB2100g =  tryIfIsEmpty(morceaux[17]);
			double vitPP100g =  tryIfIsEmpty(morceaux[18]);
			double vitB6100g =  tryIfIsEmpty(morceaux[19]);
			double vitB9100g =  tryIfIsEmpty(morceaux[20]);
			double vitB12100g =  tryIfIsEmpty(morceaux[21]);
			double calcium100g =  tryIfIsEmpty(morceaux[22]);
			double magnesium100g =  tryIfIsEmpty(morceaux[23]);
			double iron100g =  tryIfIsEmpty(morceaux[24]);
			double fer100g =  tryIfIsEmpty(morceaux[25]);
			double betaCarotene100g =  tryIfIsEmpty(morceaux[26]);
			double presenceHuilePalme =  tryIfIsEmpty(morceaux[27]);
			List<Allergene> listAllergenes = Splitter.splitAllergenes(morceaux[28]);
			List<Additif> listAdditifs = Splitter.splitAdditifs(morceaux[29]);
			
			Article produit = new Article(categorie, marque, nom, grade, listIngredients, energie100g, graisse100g, sucres100g, 
					fibres100g, proteines100g, sel100g, vitA100g, vitD100g, vitE100g, vitK100g, vitC100g, vitB1100g, vitB2100g, 
					vitPP100g, vitB6100g, vitB9100g, vitB12100g, calcium100g, magnesium100g, iron100g, fer100g, betaCarotene100g, 
					presenceHuilePalme, listAllergenes, listAdditifs);
			
			listProduits.add(produit);
			
		}
		
		return listProduits;
		
	}
	
	public static double tryIfIsEmpty(String str) {
		
		
		if (str.isEmpty() || str.isBlank()) {
			
			return 0.0;
			
		} else {
			
			return Double.parseDouble(str);
			
		}
		
	}
	
}
