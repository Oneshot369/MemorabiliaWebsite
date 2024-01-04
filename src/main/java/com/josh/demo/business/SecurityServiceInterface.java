package com.josh.demo.business;

import com.josh.model.LoginModel;
import com.josh.model.NewUserModel;

public interface SecurityServiceInterface {
	public boolean isAuthenticated(LoginModel loginModel);
	public void addUser(NewUserModel us);
}
