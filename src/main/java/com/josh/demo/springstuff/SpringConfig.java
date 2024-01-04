package com.josh.demo.springstuff;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.josh.demo.business.ValidLogins;
import com.josh.demo.database.MemSQLDatabase;
import com.josh.demo.database.UserSQLDatabase;
import com.josh.demo.business.MemBusinessService;
import com.josh.demo.business.MemBusinessServiceInterface;
import com.josh.demo.business.MemBusinessServiceSQL;
import com.josh.demo.business.SecurityServiceInterface;

@Configuration
public class SpringConfig 
{
	@Bean(name = "ordersBusinessService", initMethod="init", destroyMethod="destroy")
	@SessionScope
	public MemBusinessServiceInterface getOrdersBusiness()
	{
		//This is our hard coded list
		//return new MemBusinessService();

		//This is our SQL
		return new MemBusinessServiceSQL();
	}
	@Bean(name="securityService")
	public SecurityServiceInterface getSecurityService()
	{
		return new ValidLogins();
	}

	@Autowired
	private DataSource dataSource;

	@Bean(name="mySQLData")
	public MemSQLDatabase getSQLDatabase(){
		//This is our SQL Database
		return new MemSQLDatabase(dataSource);
	}
	@Bean(name="userSQL")
	public UserSQLDatabase getUsersData(){
		return new UserSQLDatabase(dataSource);
	}
}
