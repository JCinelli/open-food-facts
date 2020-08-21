package fr.diginamic.traitementFichier;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.entities.Additif;
import fr.diginamic.entities.Allergene;
import fr.diginamic.entities.Ingredient;

public class Splitter {

	public static List<Ingredient> splitIngredients(String ingredients) {

		List<Ingredient> listIngredients = new ArrayList<Ingredient>();

		String ligneIngredientNet = ingredients.replaceAll("[0-9]*\\s*%", "").trim();
		ligneIngredientNet = ligneIngredientNet.replaceAll("\\(.*\\)", "").trim();
		ligneIngredientNet = ligneIngredientNet.replaceAll("[0-9]*\\s*\\.", "").trim();
		ligneIngredientNet = ligneIngredientNet.replaceAll(" et de ", ",");
		
		String[] ingredientNet = ligneIngredientNet.split("[\\-,;]");
		
		for(String ing : ingredientNet) {

			ing = ing.replaceAll("_", " ").trim();
			
			listIngredients.add(new Ingredient(ing));
		}	

		return listIngredients;
	}
	
	public static List<Allergene> splitAllergenes(String allergenes) {
		
		List<Allergene> listAllergenes = new ArrayList<Allergene>();
		
		if (allergenes.indexOf(",") != -1) {

			String[] allergenesTab = allergenes.split(",");

			for (int i = 0; i < allergenesTab.length; i++) {

				listAllergenes.add(new Allergene(allergenesTab[i]));

			}

		} else {
			
			listAllergenes.add(new Allergene(allergenes));
			
		}
		
		return listAllergenes;
		
	}
	
	public static List<Additif> splitAdditifs(String additifs) {
		
		List<Additif> listAdditifs = new ArrayList<Additif>();
		
		if (additifs.indexOf("-") != -1) {

			String[] additifsTab = additifs.split(",");

			for (int i = 0; i < additifsTab.length; i++) {

				listAdditifs.add(new Additif(additifsTab[i]));

			}

		} else {
			
			listAdditifs.add(new Additif(additifs));
			
		}
		
		return listAdditifs;
		
	}

}
