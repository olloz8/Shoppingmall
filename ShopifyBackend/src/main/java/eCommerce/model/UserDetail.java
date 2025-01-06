package eCommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class UserDetail 
{
	@Id
    
	String username;
	String password;
	String role;
	boolean enabled;
	String customerName;
	String customerAddr;
	String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() 
	{
		return username;
	}
	
	public void setUserName(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getRole() 
	{
		return role;
	}
	
	public void setRole(String role) 
	{
		this.role = role;
	}
	
	public boolean isEnabled() 
	{
		return enabled;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	
	public String getCustomerName() 
	{
		return customerName;
	}
	
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	
	public String getCustomerAddr() 
	{
		return customerAddr;
	}
	
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	
	
	

}