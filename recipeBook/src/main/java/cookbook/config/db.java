package cookbook.config;

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

import cookbook.model.recipes;

@Configuration
@EnableTransactionManagement
@ComponentScan("cookbook")
public class db 
{
	@Bean(name="dataSource")
	public DataSource getDatasource()
	{
	DriverManagerDataSource  datasource=new DriverManagerDataSource();
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl(" jdbc:h2:tcp://localhost/~/recipebook");
    datasource.setUsername("sa");
	datasource.setPassword("sa");

    System.out.println("===Creating DataSource Bean==");
	return datasource;
}
		
	@Bean(name="SessionFactory")
	public SessionFactory getsessionFactory() 
	{
	Properties hibernateproperties=new Properties();
	hibernateproperties.put("hibernate.hbm2ddl.auto","update");
	hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	hibernateproperties.put("hibernate.show_sql", true);
	hibernateproperties.put("hibernate.format_sql", true);
	LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder
					(this.getDatasource());
	factory1.addProperties(hibernateproperties)	;
	factory1.addAnnotatedClass(recipes.class);
	SessionFactory sessionFactory=factory1.buildSessionFactory();
	System.out.println("Session is created");
    return sessionFactory;
		
		}
		
		
	  @Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager
		(SessionFactory sessionFactory)
		{
			System.out.println("Creating the TransactionManager Bean");
			return new HibernateTransactionManager(sessionFactory);
			
		}
	

}
