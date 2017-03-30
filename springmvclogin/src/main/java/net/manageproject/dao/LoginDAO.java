package main.java.net.manageproject.dao;

import main.java.net.manageproject.form.LoginForm;
import main.java.net.manageproject.form.PasswordChangeForm;
import main.java.net.manageproject.form.Registration;
/*
 @Author: @Author: Viral Mavani
 */
import main.java.net.manageproject.model.Users;

public interface LoginDAO {
	public boolean checkLogin(LoginForm loginForm);

	Users getLoginData(LoginForm loginForm);

	public Users saveLoginData(Registration registration);

	public Users updateLoginData(PasswordChangeForm passwordchangeform);

	public boolean checkUserPresent(String userName);

	Users getLoginDataByUser(String userName);
}