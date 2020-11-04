package cookbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cookbook.model.recipes;


@Repository("recipeDao")
@Transactional
public class recipeImpl implements recipeDao 
{

	@Autowired
	SessionFactory sessionfactory;
	
	public boolean addRecipe(recipes R) {
		System.out.println("Adding recipe details");
	  	sessionfactory.getCurrentSession().save(R);
	  	System.out.println("Success");
	  	return true;
	}

	public List<recipes> listRecipe() {
		Session session=sessionfactory.openSession();
		System.out.println("getting records");
		Query query=session.createQuery("from recipes");
		List<recipes> reclist=query.list();
		System.out.println("All Records");
		session.close();
		return reclist;
	}

	public boolean deletRecipe(recipes R) {
		try
		{
		sessionfactory.getCurrentSession().delete(R);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public recipes getid(int id) {
		Session session=sessionfactory.openSession();
		recipes rec=session.get(recipes.class, id);
		System.out.println("getting record");
		session.close();
		return rec;
	}

	public boolean updateRecipe(recipes R) {
		try
		{
		sessionfactory.getCurrentSession().update(R);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public List<recipes> getAll() {
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("from recipes");
		return query.list();
	}
	
	

}
