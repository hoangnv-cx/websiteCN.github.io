package com.javaweb.springmvc.config;



import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.javaweb.springmvc.Constants.Constants;
import com.javaweb.springmvc.Validator.UserValidator;
@Component
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.javaweb.springmvc")
@PropertySource(value = { "classpath:db.properties" })
@EnableJpaRepositories(basePackages = {"com.javaweb.springmvc.Repository"})
@EnableTransactionManagement
public class SpringConfig {
	
	
//    @Bean(name = "viewResolver")
//    public InternalResourceViewResolver getViewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
// 
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
// 
//        return viewResolver;
//    }

	
	@Autowired
	Environment environment;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();

	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("driver"));
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername(environment.getProperty("user"));
		dataSource.setPassword(environment.getProperty("pass"));
		
		return dataSource;
	}
//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());
//		return jdbcTemplate;
//	}
//	@Bean(name = "transactionManager")
//	public DataSourceTransactionManager dataSourceTransactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	} 
	

	
	  @Bean 
	  public LocalSessionFactoryBean localSessionFactoryBean() {
		  LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		  bean.setDataSource(dataSource());
		  bean.setPackagesToScan("com.javaweb.springmvc.Entity"); 
		  Properties hibernateProperties= new Properties(); 
		  hibernateProperties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
		  hibernateProperties.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
		  bean.setHibernateProperties(hibernateProperties); 
		  return bean; 
	}
	  
	  @Bean(name = "transactionManager")
	  
	  @Autowired 
	  public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
	  HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
	  hibernateTransactionManager.setSessionFactory(sessionFactory);
	  return hibernateTransactionManager; 
	  }
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource=new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}
	@Bean 
	public UserValidator validator() {
		return new UserValidator();
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("persistence-data");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(-1);
		return commonsMultipartResolver;
	}
	
	
	
	  @Bean 
	  public TilesConfigurer configurer() { 
		  TilesConfigurer configurer=new TilesConfigurer(); 
		  configurer.setDefinitions("classpath:tiles.xml"); 
		  configurer.setCheckRefresh(true); 
		  return configurer; 
	} 
	  @Bean 
	  public ViewResolver resolver() { 
		  TilesViewResolver resolver=new  TilesViewResolver(); 
		  return resolver;
	  }
	  @Bean
	  public JavaMailSender getMailSender() {
		  JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		  mailSender.setHost("smtp.gmail.com");
		  mailSender.setPort(587);
		  mailSender.setUsername(Constants.MY_EMAIL);
		  mailSender.setPassword("H0@nghuong");
		  
		  Properties properties=mailSender.getJavaMailProperties();
		  properties.put("mail.smtp.starttls.enable", "true");
		  properties.put("mail.smtp.auth", "true");
		  properties.put("mail.transport.protocol", "smtp");
		  properties.put("mail.debug", "true");
		  
		  return mailSender;
	  }
	 	 
	  Properties additionalProperties() {
			Properties properties = new Properties();
			//properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
			//properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.setProperty("hibernate.hbm2ddl.auto", "none");
			properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
			return properties;
		}
	
}
