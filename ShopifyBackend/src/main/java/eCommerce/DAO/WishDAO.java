package eCommerce.DAO;

import java.util.List;

import eCommerce.model.WishItem;

public interface WishDAO 
{
	public boolean addWishItem(WishItem cartItem);
	public boolean deleteWishItem(WishItem cartItem);
	public boolean updateWishItem(WishItem cartItem);
	
	public WishItem getWishItem(int wishItemId);
	
	public List<WishItem> listWishItems(String username);
	
	public List<WishItem> ConfirmWishItems(String username);


}