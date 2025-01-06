package eCommerce.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import eCommerce.model.Board;
import eCommerce.model.CartItem;
import eCommerce.model.Category;
import eCommerce.model.Comment;
import eCommerce.model.OrderDetail;
import eCommerce.model.Product;
import eCommerce.model.Supplier;
import eCommerce.model.UserDetail;
import eCommerce.model.WishItem;

@Configuration
@EnableTransactionManagement
@ComponentScan("eCommerce")

public class DBConfig {
	
	
	@Bean(name="dataSource")
	
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db01");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		System.out.println("-------DataSource Object is Created-------");
		
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		
		LocalSessionFactoryBuilder localFactory = new LocalSessionFactoryBuilder(getH2DataSource());
		
		localFactory.addProperties(hibernateProp);
		
		localFactory.addAnnotatedClass(Category.class);
		localFactory.addAnnotatedClass(Product.class);
		localFactory.addAnnotatedClass(Supplier.class);
		localFactory.addAnnotatedClass(UserDetail.class);
		localFactory.addAnnotatedClass(CartItem.class);
		localFactory.addAnnotatedClass(WishItem.class);
		localFactory.addAnnotatedClass(OrderDetail.class);
		localFactory.addAnnotatedClass(Board.class);
		localFactory.addAnnotatedClass(Comment.class);
		System.out.println("-------SessionFactory Obejct is Created-------");
		
		return localFactory.buildSessionFactory();
		
 	}
	
	@Bean(name="txManager")
	
	public HibernateTransactionManager getTransactionManger(SessionFactory sessionFactory)
	{
		System.out.println("--------Transaction Manager Obejct Created--------");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
	
	

}