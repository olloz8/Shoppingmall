package eCommerce.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eCommerce.model.WishItem;

@Repository("wishDAO")
@Transactional
public class WishDAOImpl implements WishDAO 
{
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public boolean addWishItem(WishItem wishItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(wishItem);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public boolean deleteWishItem(WishItem wishItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(wishItem);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public boolean updateWishItem(WishItem wishItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(wishItem);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public WishItem getWishItem(int wishItemId) 
	{
	    Session session = sessionFactory.openSession();
	    WishItem wishItem = session.get(WishItem.class, wishItemId);
	    session.close();
		return wishItem;
	}

	@Override
	public List<WishItem> listWishItems(String username) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from WishItem where username=:username and paymentStatus='NP'");
		query.setParameter("username", username);
		List<WishItem> wishItemList = query.list();
		session.close();
		
		return wishItemList;
	}
	
	@Override
	public List<WishItem> ConfirmWishItems(String username) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from WishItem where username=:username and paymentStatus='P'");
		query.setParameter("username", username);
		List<WishItem> paidItemList = query.list();
		session.close();
		
		return paidItemList;
	}

}