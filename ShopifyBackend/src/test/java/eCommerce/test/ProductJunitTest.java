package eCommerce.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.DAO.ProductDAO;
import eCommerce.model.Product;



public class ProductJunitTest {

	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("eCommerce");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}

	@Test
	public void addProductTest() 
	{
		Product product = new Product();
		product.setProductName("TShirt");
		product.setProductDesc("United Colours of Benetton");
		product.setPrice(800);
		product.setStock(45);
		product.setCategoryId(18);
		product.setSupplierId(15);
		
		assertTrue("Problem in adding Product", productDAO.addProduct(product));
			
	}

}