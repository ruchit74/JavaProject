package main.java.net.manageproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.net.manageproject.dao.*;
import main.java.net.manageproject.form.LoginForm;
import main.java.net.manageproject.form.PasswordChangeForm;
import main.java.net.manageproject.form.Registration;
import main.java.net.manageproject.model.Users;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	 @Autowired
	 private LoginDAO loginDAO;

	   public void setLoginDAO(LoginDAO loginDAO) {
              this.loginDAO = loginDAO;
       }
      
	   @Override
       public boolean checkLogin(LoginForm loginForm){
              System.out.println("In Service class...Check Login");
              return loginDAO.checkLogin(loginForm);
       }

	@Override
	public Users getLoginData(LoginForm loginForm) {
		 System.out.println("In Service class...Check Login");
         return loginDAO.getLoginData(loginForm);
	}
        
	@Override
	public Users saveLoginData(Registration registration) {
		 System.out.println("In Service class...Check Login");
         return loginDAO.saveLoginData(registration);
	}

	@Override
	public Users updateLoginData(PasswordChangeForm passwordchangeform) {
		System.out.println("In Service class...Check Login");
        return loginDAO.updateLoginData(passwordchangeform);
	}

	@Override
	public boolean checkUserPresent(String userName) {
		 System.out.println("In Service class...Check Login");
         return loginDAO.checkUserPresent(userName);
	}
	
	@Override
	public Users getLoginDataByUser(String userName) {
		 System.out.println("In Service class...Check Login");
         return loginDAO.getLoginDataByUser(userName);
	}
	
	
        
}