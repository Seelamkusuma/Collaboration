package com.niit.collaborate.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborate.DAO.BlogDAO;
import com.niit.collaborate.DAO.BlogDAOImpl;
import com.niit.collaborate.DAO.ForumDAO;
import com.niit.collaborate.DAO.ForumDAOImpl;
import com.niit.collaborate.DAO.FriendDAO;
import com.niit.collaborate.DAO.FriendDAOImpl;
import com.niit.collaborate.DAO.JobDAO;
import com.niit.collaborate.DAO.JobDAOImpl;
import com.niit.collaborate.DAO.UserDAO;
import com.niit.collaborate.DAO.UserDAOImpl;
import com.niit.collaborate.model.Blog;
import com.niit.collaborate.model.BlogComment;
import com.niit.collaborate.model.Forum;
import com.niit.collaborate.model.Friend;
import com.niit.collaborate.model.Job;
import com.niit.collaborate.model.ProfilePicture;
import com.niit.collaborate.model.User;

@Configuration
@ComponentScan("com.niit.collaborate")
@EnableTransactionManagement
public class DBConfig {
// 1.creating a DataSource object which is used for local session factory
 
public	DataSource getOracleDataSource()
{
	DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
	driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	driverManagerDataSource.setUsername("kusuma");
	driverManagerDataSource.setPassword("5678");
	return driverManagerDataSource;
}
//2.Creating Hibernate properties which is used by LocalSessionFactory

public Properties getHibernateProperties()
{
	Properties properties=new Properties();
	properties.setProperty("hibernate.hbm2ddl.auto","update");
	properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
	return properties;
}
//3. creating the SessionFactoryBean using LocalsessionFactory

@Bean
public SessionFactory getSessionFactory()
{
	LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
	localSessionFactoryBuilder.addProperties(getHibernateProperties());
	localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
	localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
	localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
	localSessionFactoryBuilder.addAnnotatedClass(Job.class);
	localSessionFactoryBuilder.addAnnotatedClass(User.class);
	localSessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
	localSessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
	System.out.println("SessionFactory Bean Created");
	return localSessionFactoryBuilder.buildSessionFactory();
}
//4.HibernateTransaction Bean
@Bean
public HibernateTransactionManager getHibernatTransactionManager(SessionFactory sessionFactory)
{
	return new HibernateTransactionManager(sessionFactory);
}
//5.Application Specific DAO bean
@Bean
public BlogDAO getBlogDAO(SessionFactory sessionFactory)
{
	return new BlogDAOImpl(sessionFactory);
}

@Bean
public ForumDAO getForumDAO(SessionFactory sessionFactory)
{
	return new ForumDAOImpl(sessionFactory);
}

@Bean
public FriendDAO getFriendDAO(SessionFactory sessionFactory)
{
	return new FriendDAOImpl(sessionFactory);
}
@Bean
public JobDAO getJobDAO(SessionFactory sessionFactory)
{
	return new JobDAOImpl(sessionFactory);
}
@Bean
public UserDAO getUserDAO(SessionFactory sessionFactory)
{
	return new UserDAOImpl(sessionFactory);
}
}
