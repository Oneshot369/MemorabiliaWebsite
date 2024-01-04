package com.josh.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.josh.demo.database.UserSQLDatabase;
import com.josh.model.LoginModel;
import com.josh.model.NewUserModel;

public class ValidLogins implements SecurityServiceInterface{

	@Autowired
	UserSQLDatabase userSQL;

	@Override
	public boolean isAuthenticated(LoginModel loginModel) 
	{
		List<NewUserModel> validLogins = userSQL.getLogins();
		System.out.println(validLogins.get(0).toString());
		System.out.println(loginModel.toString());
			//CHeck to see if the login matches our users list
			boolean success = false;
			for(int i =0; i < validLogins.size(); i++)
			{
				if(loginModel.getUsername().equals(validLogins.get(i).getUsername()) && loginModel.getPassword().equals(validLogins.get(i).getPassword()))
				{
					System.out.println("Loged In");
					success = true;
				}
			}
		return success;
	}

	public void addUser(NewUserModel us){
		userSQL.addUser(us);
	}
}
