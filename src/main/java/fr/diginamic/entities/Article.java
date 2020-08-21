package fr.diginamic.entities;

import java.util.List;

public class Article {

	private int id;
	private Categorie categorie;
	private int id_categorie;
	private Marque marque;
	private int id_marque;
	private String nom;
	private String nutritionGradeFr;
	private List<Ingredient> listIngredients;
	private double energie100g;
	private double graisse100g;
	private double sucres100g;
	private double fibres100g;
	private double proteines100g;
	private double sel100g;
	private double vitA100g;
	private double vitD100g;
	private double vitE100g;
	private double vitK100g;
	private double vitC100g;
	private double vitB1100g;
	private double vitB2100g;
	private double vitPP100g;
	private double vitB6100g;
	private double vitB9100g;
	private double vitB12100g;
	private double calcium100g;
	private double magnesium100g;
	private double iron100g;
	private double fer100g;
	private double betaCarotene100g;
	private double presenceHuilePalme;
	private List<Allergene> listAllergenes;
	private List<Additif> listAdditifs;

//	CONSTRUCTOR
	public Article(Categorie categorie, Marque marque, String nom, String nutritionGradeFr,
			List<Ingredient> listIngredients, double energie100g, double graisse100g, double sucres100g,
			double fibres100g, double proteines100g, double sel100g, double vitA100g, double vitD100g, double vitE100g,
			double vitK100g, double vitC100g, double vitB1100g, double vitB2100g, double vitPP100g, double vitB6100g,
			double vitB9100g, double vitB12100g, double calcium100g, double magnesium100g, double iron100g,
			double fer100g, double betaCarotene100g, double presenceHuilePalme, List<Allergene> listAllergenes,
			List<Additif> listAdditifs) {
		this.categorie = categorie;
		this.marque = marque;
		this.nom = nom;
		this.nutritionGradeFr = nutritionGradeFr;
		this.listIngredients = listIngredients;
		this.energie100g = energie100g;
		this.graisse100g = graisse100g;
		this.sucres100g = sucres100g;
		this.fibres100g = fibres100g;
		this.proteines100g = proteines100g;
		this.sel100g = sel100g;
		this.vitA100g = vitA100g;
		this.vitD100g = vitD100g;
		this.vitE100g = vitE100g;
		this.vitK100g = vitK100g;
		this.vitC100g = vitC100g;
		this.vitB1100g = vitB1100g;
		this.vitB2100g = vitB2100g;
		this.vitPP100g = vitPP100g;
		this.vitB6100g = vitB6100g;
		this.vitB9100g = vitB9100g;
		this.vitB12100g = vitB12100g;
		this.calcium100g = calcium100g;
		this.magnesium100g = magnesium100g;
		this.iron100g = iron100g;
		this.fer100g = fer100g;
		this.betaCarotene100g = betaCarotene100g;
		this.presenceHuilePalme = presenceHuilePalme;
		this.listAllergenes = listAllergenes;
		this.listAdditifs = listAdditifs;
	}

	public Article(int id, int id_categorie, int id_marque, String nom, String nutritionGradeFr, 
			double energie100g, double graisse100g, double sucres100g,
			double fibres100g, double proteines100g, double sel100g, double vitA100g, double vitD100g, double vitE100g,
			double vitK100g, double vitC100g, double vitB1100g, double vitB2100g, double vitPP100g, double vitB6100g,
			double vitB9100g, double vitB12100g, double calcium100g, double magnesium100g, double iron100g,
			double fer100g, double betaCarotene100g, double presenceHuilePalme) {
		super();
		this.id = id;
		this.id_categorie = id_categorie;
		this.id_marque = id_marque;
		this.nom = nom;
		this.nutritionGradeFr = nutritionGradeFr;
		this.energie100g = energie100g;
		this.graisse100g = graisse100g;
		this.sucres100g = sucres100g;
		this.fibres100g = fibres100g;
		this.proteines100g = proteines100g;
		this.sel100g = sel100g;
		this.vitA100g = vitA100g;
		this.vitD100g = vitD100g;
		this.vitE100g = vitE100g;
		this.vitK100g = vitK100g;
		this.vitC100g = vitC100g;
		this.vitB1100g = vitB1100g;
		this.vitB2100g = vitB2100g;
		this.vitPP100g = vitPP100g;
		this.vitB6100g = vitB6100g;
		this.vitB9100g = vitB9100g;
		this.vitB12100g = vitB12100g;
		this.calcium100g = calcium100g;
		this.magnesium100g = magnesium100g;
		this.iron100g = iron100g;
		this.fer100g = fer100g;
		this.betaCarotene100g = betaCarotene100g;
		this.presenceHuilePalme = presenceHuilePalme;
	}


	// METHODS
	@Override
	public String toString() {
		return "Produit :\r ID : " + id + "\r Id categorie : " + id_categorie + "\r Id marque : " + id_marque + "\r Nom : "
				+ nom + "\r Grade : " + nutritionGradeFr + "\r Energie100g : "
				+ energie100g + "\r Graisse100g : " + graisse100g + "\r Sucres100g : " + sucres100g + "\r Fibres100g : "
				+ fibres100g + "\r Proteines100g : " + proteines100g + "\r Sel100g : " + sel100g + "\r VitA100g : "
				+ vitA100g + "\r VitD100g : " + vitD100g + "\r VitE100g : " + vitE100g + "\r VitK100g : " + vitK100g
				+ "\r VitC100g : " + vitC100g + "\r VitB1100g : " + vitB1100g + "\r VitB2100g : " + vitB2100g
				+ "\r VitPP100g : " + vitPP100g + "\r VitB6100g : " + vitB6100g + "\r VitB9100g : " + vitB9100g
				+ "\r VitB12100g : " + vitB12100g + "\r Calcium100g : " + calcium100g + "\r Magnesium100g : "
				+ magnesium100g + "\r Iron100g : " + iron100g + "\r Fer100g : " + fer100g + "\r BetaCarotene100g : "
				+ betaCarotene100g + "\r PresenceHuilePalme : " + presenceHuilePalme;
	}

//	GETTERS & SETTERS
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the nutritionGradeFr
	 */
	public String getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	/**
	 * @param nutritionGradeFr the nutritionGradeFr to set
	 */
	public void setNutritionGradeFr(String nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}

	/**
	 * @return the listIngredients
	 */
	public List<Ingredient> getListIngredients() {
		return listIngredients;
	}

	/**
	 * @param listIngredients the listIngredients to set
	 */
	public void setListIngredients(List<Ingredient> listIngredients) {
		this.listIngredients = listIngredients;
	}

	/**
	 * @return the energie100g
	 */
	public double getEnergie100g() {
		return energie100g;
	}

	/**
	 * @param energie100g the energie100g to set
	 */
	public void setEnergie100g(double energie100g) {
		this.energie100g = energie100g;
	}

	/**
	 * @return the graisse100g
	 */
	public double getGraisse100g() {
		return graisse100g;
	}

	/**
	 * @param graisse100g the graisse100g to set
	 */
	public void setGraisse100g(double graisse100g) {
		this.graisse100g = graisse100g;
	}

	/**
	 * @return the sucres100g
	 */
	public double getSucres100g() {
		return sucres100g;
	}

	/**
	 * @param sucres100g the sucres100g to set
	 */
	public void setSucres100g(double sucres100g) {
		this.sucres100g = sucres100g;
	}

	/**
	 * @return the fibres100g
	 */
	public double getFibres100g() {
		return fibres100g;
	}

	/**
	 * @param fibres100g the fibres100g to set
	 */
	public void setFibres100g(double fibres100g) {
		this.fibres100g = fibres100g;
	}

	/**
	 * @return the proteines100g
	 */
	public double getProteines100g() {
		return proteines100g;
	}

	/**
	 * @param proteines100g the proteines100g to set
	 */
	public void setProteines100g(double proteines100g) {
		this.proteines100g = proteines100g;
	}

	/**
	 * @return the sel100g
	 */
	public double getSel100g() {
		return sel100g;
	}

	/**
	 * @param sel100g the sel100g to set
	 */
	public void setSel100g(double sel100g) {
		this.sel100g = sel100g;
	}

	/**
	 * @return the vitA100g
	 */
	public double getVitA100g() {
		return vitA100g;
	}

	/**
	 * @param vitA100g the vitA100g to set
	 */
	public void setVitA100g(double vitA100g) {
		this.vitA100g = vitA100g;
	}

	/**
	 * @return the vitD100g
	 */
	public double getVitD100g() {
		return vitD100g;
	}

	/**
	 * @param vitD100g the vitD100g to set
	 */
	public void setVitD100g(double vitD100g) {
		this.vitD100g = vitD100g;
	}

	/**
	 * @return the vitE100g
	 */
	public double getVitE100g() {
		return vitE100g;
	}

	/**
	 * @param vitE100g the vitE100g to set
	 */
	public void setVitE100g(double vitE100g) {
		this.vitE100g = vitE100g;
	}

	/**
	 * @return the vitK100g
	 */
	public double getVitK100g() {
		return vitK100g;
	}

	/**
	 * @param vitK100g the vitK100g to set
	 */
	public void setVitK100g(double vitK100g) {
		this.vitK100g = vitK100g;
	}

	/**
	 * @return the vitC100g
	 */
	public double getVitC100g() {
		return vitC100g;
	}

	/**
	 * @param vitC100g the vitC100g to set
	 */
	public void setVitC100g(double vitC100g) {
		this.vitC100g = vitC100g;
	}

	/**
	 * @return the vitB1100g
	 */
	public double getVitB1100g() {
		return vitB1100g;
	}

	/**
	 * @param vitB1100g the vitB1100g to set
	 */
	public void setVitB1100g(double vitB1100g) {
		this.vitB1100g = vitB1100g;
	}

	/**
	 * @return the vitB2100g
	 */
	public double getVitB2100g() {
		return vitB2100g;
	}

	/**
	 * @param vitB2100g the vitB2100g to set
	 */
	public void setVitB2100g(double vitB2100g) {
		this.vitB2100g = vitB2100g;
	}

	/**
	 * @return the vitPP100g
	 */
	public double getVitPP100g() {
		return vitPP100g;
	}

	/**
	 * @param vitPP100g the vitPP100g to set
	 */
	public void setVitPP100g(double vitPP100g) {
		this.vitPP100g = vitPP100g;
	}

	/**
	 * @return the vitB6100g
	 */
	public double getVitB6100g() {
		return vitB6100g;
	}

	/**
	 * @param vitB6100g the vitB6100g to set
	 */
	public void setVitB6100g(double vitB6100g) {
		this.vitB6100g = vitB6100g;
	}

	/**
	 * @return the vitB9100g
	 */
	public double getVitB9100g() {
		return vitB9100g;
	}

	/**
	 * @param vitB9100g the vitB9100g to set
	 */
	public void setVitB9100g(double vitB9100g) {
		this.vitB9100g = vitB9100g;
	}

	/**
	 * @return the vitB12100g
	 */
	public double getVitB12100g() {
		return vitB12100g;
	}

	/**
	 * @param vitB12100g the vitB12100g to set
	 */
	public void setVitB12100g(double vitB12100g) {
		this.vitB12100g = vitB12100g;
	}

	/**
	 * @return the calcium100g
	 */
	public double getCalcium100g() {
		return calcium100g;
	}

	/**
	 * @param calcium100g the calcium100g to set
	 */
	public void setCalcium100g(double calcium100g) {
		this.calcium100g = calcium100g;
	}

	/**
	 * @return the magnesium100g
	 */
	public double getMagnesium100g() {
		return magnesium100g;
	}

	/**
	 * @param magnesium100g the magnesium100g to set
	 */
	public void setMagnesium100g(double magnesium100g) {
		this.magnesium100g = magnesium100g;
	}

	/**
	 * @return the iron100g
	 */
	public double getIron100g() {
		return iron100g;
	}

	/**
	 * @param iron100g the iron100g to set
	 */
	public void setIron100g(double iron100g) {
		this.iron100g = iron100g;
	}

	/**
	 * @return the fer100g
	 */
	public double getFer100g() {
		return fer100g;
	}

	/**
	 * @param fer100g the fer100g to set
	 */
	public void setFer100g(double fer100g) {
		this.fer100g = fer100g;
	}

	/**
	 * @return the betaCarotene100g
	 */
	public double getBetaCarotene100g() {
		return betaCarotene100g;
	}

	/**
	 * @param betaCarotene100g the betaCarotene100g to set
	 */
	public void setBetaCarotene100g(double betaCarotene100g) {
		this.betaCarotene100g = betaCarotene100g;
	}

	/**
	 * @return the presenceHuilePalme
	 */
	public double getPresenceHuilePalme() {
		return presenceHuilePalme;
	}

	/**
	 * @param presenceHuilePalme the presenceHuilePalme to set
	 */
	public void setPresenceHuilePalme(double presenceHuilePalme) {
		this.presenceHuilePalme = presenceHuilePalme;
	}

	/**
	 * @return the listAllergenes
	 */
	public List<Allergene> getListAllergenes() {
		return listAllergenes;
	}

	/**
	 * @param listAllergenes the listAllergenes to set
	 */
	public void setListAllergenes(List<Allergene> listAllergenes) {
		this.listAllergenes = listAllergenes;
	}

	/**
	 * @return the listAdditifs
	 */
	public List<Additif> getListAdditifs() {
		return listAdditifs;
	}

	/**
	 * @param listAdditifs the listAdditifs to set
	 */
	public void setListAdditifs(List<Additif> listAdditifs) {
		this.listAdditifs = listAdditifs;
	}

}
