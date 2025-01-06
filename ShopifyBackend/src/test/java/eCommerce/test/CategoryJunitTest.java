package eCommerce.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.DAO.CategoryDAO;
import eCommerce.model.Category;

public class CategoryJunitTest {

	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("eCommerce");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	
	@Test
	public void addCategoryTest() 
	{
		Category category = new Category();
		category.setCategoryName("T-Shirts with Coler");
		category.setCategoryDesc("All Round neck variety of Tshirts");

		assertTrue("Problem in adding Category", categoryDAO.addCategory(category));
	}

	@Ignore
	@Test
	public void deleteCategoryTest() {
		Category category = categoryDAO.getCategory(11);
		assertTrue("Problem in Deleting Category", categoryDAO.deleteCategory(category));
	}

	@Ignore
	@Test
	public void updateCategory() {
		Category category = categoryDAO.getCategory(11);
		category.setCategoryDesc("Pencil cut Jeans with Chain");
		assertTrue("Problem in Updating Category", categoryDAO.updateCategory(category));
	}

	/*
	 * @Test public void listCategoriesTest() { List<Category> listCategories =
	 * categoryDAO.listCategories(); assertTrue("Problem in Listing Categories",
	 * listCategories.size()>0);
	 * 
	 * 
	 * for(Category category:listCategories) { System.out.println("Category Id: " +
	 * category.getCategoryId()); System.out.println("Category Name: " +
	 * category.getCategoryName()); System.out.println("Category Description: " +
	 * category.getCategoryDesc());
	 * System.out.println("------------------------------------"); }
	 * 
	 * }
	 */

}