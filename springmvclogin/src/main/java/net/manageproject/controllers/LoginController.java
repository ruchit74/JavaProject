package main.java.net.manageproject.controllers;


import java.util.Map;

import javax.validation.Valid;

import main.java.net.manageproject.form.LoginForm;
import main.java.net.manageproject.form.Registration;
import main.java.net.manageproject.form.PasswordChangeForm;
import main.java.net.manageproject.model.Users;
import main.java.net.manageproject.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	public LoginService loginService;

	@RequestMapping(value = "loginform.html", method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(value = "loginform.html", method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model) {

		if (result.hasErrors()) {
			return "loginform";
		}

		boolean userExists = loginService.checkLogin(loginForm);
		if (userExists) {

			Users users = loginService.getLoginData(loginForm);
			loginForm.setUserType(users.getUserType());
			loginForm.setUserFirstTime(users.getUserFirstTime());

			if (loginForm.getUserType().equals("admin")) {
				Registration registration = new Registration();
				model.put("loginForm", loginForm);
				return "registrationform";
			} else if (loginForm.getUserType().equals("user")) {
				model.put("loginForm", loginForm);
				return "loginsuccess";
			} else {
				result.rejectValue("userName", "invaliduser");
				return "loginform";
			}

		} else {
			result.rejectValue("userName", "invaliduser");
			return "loginform";
		}

	}

	/*@RequestMapping(value = "passwordchange1.html", method = RequestMethod.GET)
	public ModelAndView getPasswordJsp(@RequestParam("userName") String userName) {
		System.out.println("--inside getPasswordJsp : " + userName);
		PasswordChangeForm passwordChangeForm = new PasswordChangeForm();
		passwordChangeForm.setUserName(userName);
		return new ModelAndView("passwordchangeform", "passwordChangeForm",
				passwordChangeForm);
	}

	@RequestMapping(value = "passwordchangeform.html", method = RequestMethod.POST)
	public String updatePassword(@Valid PasswordChangeForm passwordchangeform,
			BindingResult result, Map model) {

		LoginForm loginForm = new LoginForm();
		loginForm.setUserName(passwordchangeform.getUserName());
		loginForm.setPassword(passwordchangeform.getPassword());
		loginForm.setUserType("user");
		
		if (result.hasErrors()) {
			result.rejectValue("passwprd", "invalidoldpassword");
			return "passwordchange";
		}

		boolean userExists = loginService.checkLogin(loginForm);
		if (userExists) {

			Users users1 = loginService.getLoginDataByUser(passwordchangeform
					.getUserName());
			if (!users1.getUserPassword().equals(
					passwordchangeform.getPassword())) {
				result.rejectValue("passwprd", "invalidoldpassword");
				return "passwordchange";
			}

			Users users = loginService.updateLoginData(passwordchangeform);
			// ---
			if (loginForm.getUserType().equals("user")) {
				model.put("passwordchangeform", passwordchangeform);
				return "passwordchange";
			} else {
				result.rejectValue("userName", "invaliduser");
				return "passwordchange";
			}

		} else {
			result.rejectValue("userName", "invaliduser");
			return "passwordchange";
		}

	}
	*/
}
