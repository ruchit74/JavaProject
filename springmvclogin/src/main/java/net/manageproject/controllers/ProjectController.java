package main.java.net.manageproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import main.java.net.manageproject.form.LoginForm;
import main.java.net.manageproject.form.PasswordChangeForm;
import main.java.net.manageproject.form.ProjectForm;
import main.java.net.manageproject.form.Registration;
import main.java.net.manageproject.model.ProjectDtls;
import main.java.net.manageproject.model.Users;
import main.java.net.manageproject.service.LoginService;
import main.java.net.manageproject.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

	@Autowired
	public LoginService loginService;
	@Autowired
	public ProjectService projectService;

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	@RequestMapping(value = "addProjectchange1.html", method = RequestMethod.GET)
	public ModelAndView getPasswordJsp(@RequestParam("userName") String userName) {
		System.out.println("--inside getPasswordJsp : " + userName);
		ProjectForm projectForm = new ProjectForm();
		projectForm.setUserName(userName);
		return new ModelAndView("projectform", "projectForm", projectForm);
	}

	@RequestMapping(value = "projectform.html", method = RequestMethod.POST)
	public String updatePassword(@Valid ProjectForm projectform,
			BindingResult result, Map model) {

		//if (result.hasErrors()) {
			//result.rejectValue("passwprd", "invalidoldpassword");
			//return "projectaddsuccess";
		//}

		Users users1 = loginService.getLoginDataByUser(projectform
				.getUserName());
		if (!(users1 == null)) {
			ProjectDtls projectDtls = new ProjectDtls();

			projectDtls.setProjDate(projectform.getProjDate());
			projectDtls.setProjDesc(projectform.getProjDesc());
			projectDtls.setProjName(projectform.getProjName());
			projectDtls.setProjStatus(projectform.getProjStatus());
			projectDtls.setUserName(projectform.getUserName());

			projectDtls=projectService.saveProjectData(projectDtls);
			model.put("projectform", projectDtls);
			return "projectaddsuccess";
		} else {
			result.rejectValue("userName", "invaliduser");
			return "projectaddsuccess";
		}

	}

}
