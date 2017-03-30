package main.java.net.manageproject.controllers;

import java.util.Map;

import javax.validation.Valid;

import main.java.net.manageproject.form.Registration;
import main.java.net.manageproject.model.Users;
import main.java.net.manageproject.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registrationform.html")
public class RegistrationController {
	@Autowired
	private RegistrationValidation registrationValidation;

	@Autowired
	public LoginService loginService;
	
	public void setRegistrationValidation(
			RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) {
		Registration registration = new Registration();
		
		//TODO: add user by admin
		
		model.put("registration", registration);
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid Registration registration,
			BindingResult result,Map model) {
		// set custom Validation by user
		registrationValidation.validate(registration, result);
		boolean userExists = loginService.checkUserPresent(registration.getUserName());
		registration.setIsAlredyExist("0");
		if (result.hasErrors()) {
			return "registrationform";
		}
		if(userExists){
			registration.setIsAlredyExist("1");
			//model.put("registration", registration);
			return "registrationsuccess";
		}
		
		Users user= loginService.saveLoginData(registration);
		
		return "registrationsuccess";
	}
}
