package cookbook.controller;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cookbook.dao.recipeDao;
import cookbook.model.recipes;

@Controller
public class recipeController
{

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	@Autowired
	recipeDao service;
	
	@RequestMapping("/Recipes")
	public String Recipes(Model m)
	{
		recipes R=new recipes();
		m.addAttribute("recipe",R);
		List <recipes> reclist=service.listRecipe();
		m.addAttribute("lists",reclist);
    	return "Recipes";
	}
	
	@RequestMapping("/addRecipe")
	public String AddRecipe(@Valid @ModelAttribute("recipe") recipes R,Model m)
	{
		System.out.println("From Controller");
		service.addRecipe(R);
		List <recipes> reclist=service.listRecipe();
		m.addAttribute("lists",reclist);
		System.out.println("Inserted Successfullyt");
		return "addrecipe";
	}
	@RequestMapping("/deleteRecipe/{id}")
	public String deleteRecipe(@PathVariable("id") int id,Model m)
	{
		System.out.println("Deletion is in progress");
		recipes R=service.getid(id);
		service.deletRecipe(R);
		List <recipes> reclist=service.listRecipe();
		m.addAttribute("lists",reclist);
		return "Recipes";
	}
	
	@RequestMapping(value="/editRecipe/{id}")
	public String editRecipe(@PathVariable("id")int id,Model m)
	{
		recipes rec=service.getid(id);
		m.addAttribute("recipe",rec);
		return "updaterecipe";
	}
	
	@RequestMapping(value="/updateRecipe",method=RequestMethod.POST)
	 public String updateRecipe(@Valid @ModelAttribute("recipe") recipes R,Model m)
	 {
		 recipes rec=service.getid(R.getId());
		 
		 service.updateRecipe(rec);
		 
		 List<recipes> reclist=service.listRecipe();
		 m.addAttribute("lists",reclist);
		 return "Recipes";
	 }
	
	@RequestMapping("/searchbycategory")
	public String selectByCategory(@RequestParam String searchCondition,Model model) {
		model.addAttribute("lists", service.getAll());
		if(searchCondition.equals("All"))
			model.addAttribute("searchCondition", "");
		else
			model.addAttribute("searchCondition", searchCondition);
		return "Recipes";
	}
}
