package com.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.configuration"})
@PropertySource(value= {"classpath:ApplicationResource.properties"})
public class HibernateConfiguiration {

	@Autowired
	private Environment env;
	
	
	public  LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sessionFactoryBean= new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(DataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperites());
		return sessionFactoryBean;
	}


	private Properties hibernateProperites() {
		Properties properties= new Properties();
		properties.put("hibernate.dialect", env.getProperties().getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperties().getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperties().getProperty("hibernate.format_sql"));
		return properties;
	}


	public DataSource DataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperties().getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperties().getProperty("jdbc.url"));
		return dataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s)
	{
		HibernateTransactionManager tx= new HibernateTransactionManager();
		tx.setSessionFactory(s);		
		return tx;
	}
}
