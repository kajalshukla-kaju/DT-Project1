package org.Controller;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.project")
@EnableTransactionManagement
public class HibernateConfig {
	// data source object
public DataSource getDataSource() {
	DriverManagerDataSource datasource = new DriverManagerDataSource();
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl("jdbc:h2:~/demo");
	datasource.setUsername("name");
	datasource.setPassword("pass");
	return datasource;
}
	// creating session factory bean
	@Bean(name= "sf")
	public SessionFactory getSessionFactory () {
      Properties pro =new Properties();
       pro.put("hibernate.hbmddl2.auto", "update");
       pro.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
       LocalSessionFactoryBuilder sfBuilder = new LocalSessionFactoryBuilder(getDataSource());
       sfBuilder.addProperties(pro);
       SessionFactory sf=sfBuilder.buildSessionFactory();
       return sf;
		
		
	}
	
	
	
	
	
	
	
	
}	


