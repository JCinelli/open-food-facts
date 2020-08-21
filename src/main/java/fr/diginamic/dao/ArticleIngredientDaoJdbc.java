package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entities.Article;

public class ArticleIngredientDaoJdbc {

	public void insertAticleIngredient() {
		
		ArticleDaoJdbc artDao = new ArticleDaoJdbc();
		List<Article> artFromDb = artDao.findAll();

	}
	
}
