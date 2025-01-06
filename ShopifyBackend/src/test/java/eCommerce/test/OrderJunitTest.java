package eCommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.DAO.CartDAO;
import eCommerce.DAO.OrderDAO;
import eCommerce.model.OrderDetail;

public class OrderJunitTest 
{
	static OrderDAO orderDAO;

	@BeforeClass
	public static void executeFirst() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("eCommerce");
		context.refresh();
		
		orderDAO = (OrderDAO)context.getBean("orderDAO");
	}
	
	@Ignore
	@Test
	public void saveOrderTest() 
	{
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setCartId(101);
		orderDetail.setShippingAddr("Sant Nagar");
		orderDetail.setTotalAmount(6999);
		orderDetail.setTranType("COD");
		orderDetail.setUserName("Sumit");
		
		assertTrue("Problem in Saving Product", orderDAO.saveOrder(orderDetail));
		
	}
	
	
	@Test
	public void updateCart() 
	{
		assertTrue("Problem in Updating Cart", orderDAO.updateCart("sumit"));
	}

}