package eCommerce.DAO;

import java.util.List;

import eCommerce.model.CartItem;

public interface CartDAO 
{
	public boolean addCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	
	public CartItem getCartItem(int cartItemId);
	
	public List<CartItem> listCartItems(String username);
	
	public List<CartItem> ConfirmCartItems(String username);

}