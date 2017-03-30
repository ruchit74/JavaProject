package main.java.net.manageproject.service;

import main.java.net.manageproject.form.LoginForm;
import main.java.net.manageproject.form.PasswordChangeForm;
import main.java.net.manageproject.form.Registration;
/*
 @Author: Viral Mavani
 */
import main.java.net.manageproject.model.Users;

public interface LoginService {
	public boolean checkLogin(LoginForm loginForm);

	Users getLoginData(LoginForm loginForm);

	Users updateLoginData(PasswordChangeForm passwordchangeform);

	Users saveLoginData(Registration registration);

	public boolean checkUserPresent(String userName);

	Users getLoginDataByUser(String userName);
}