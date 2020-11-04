package cookbook.dao;

import java.util.List;

import cookbook.model.recipes;

public interface recipeDao {
	public boolean addRecipe(recipes R);
	 public List<recipes> listRecipe();
		public boolean deletRecipe(recipes R);
		public recipes getid(int id);
		public boolean updateRecipe(recipes R);
		public List<recipes> getAll();
	

}
