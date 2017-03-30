package main.java.net.manageproject.service;

/*
 @Author: Viral Mavani
 */
import java.util.ArrayList;
import java.util.List;

import main.java.net.manageproject.dao.ProjectDAO;
import main.java.net.manageproject.form.ProjectForm;
import main.java.net.manageproject.model.ProjectDtls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rojectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	public void setLoginDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public ProjectDtls getProjectData(String userName) {
		return projectDAO.getProjectData(userName);
	}

	@Override
	public ProjectDtls saveProjectData(ProjectDtls projectDtls) {
		return projectDAO.saveProjectData(projectDtls);
	}

	@Override
	public List<String> getUniqueProjectName() {
		return projectDAO.getUniqueProjectName();
	}

	
	@Override
	public List<ProjectForm> getAllProjectData() {
		List<ProjectForm> lstProjectForm = new ArrayList<ProjectForm>();
		List<ProjectDtls> lstProjectDtls = projectDAO.getAllProjectData();
		for (ProjectDtls projectDtls : lstProjectDtls) {
			ProjectForm projectForm = new ProjectForm();
			projectForm.setProjDate(projectDtls.getProjDate());
			projectForm.setProjDesc(projectDtls.getProjDesc());
			projectForm.setProjName(projectDtls.getProjName());
			projectForm.setProjStatus(projectDtls.getProjStatus());
			projectForm.setUserName(projectDtls.getUserName());

			lstProjectForm.add(projectForm);
		}
		return lstProjectForm;

	}

	@Override
	public List<ProjectForm> getAllUserOfProject(String projectName) {
		List<ProjectForm> lstProjectForm = new ArrayList<ProjectForm>();
		List<ProjectDtls> lstProjectDtls = projectDAO.getAllUserOfProject(projectName);
		for (ProjectDtls projectDtls : lstProjectDtls) {
			ProjectForm projectForm = new ProjectForm();
			projectForm.setProjDate(projectDtls.getProjDate());
			projectForm.setProjDesc(projectDtls.getProjDesc());
			projectForm.setProjName(projectDtls.getProjName());
			projectForm.setProjStatus(projectDtls.getProjStatus());
			projectForm.setUserName(projectDtls.getUserName());

			lstProjectForm.add(projectForm);
		}
		return lstProjectForm;

	}
	
	@Override
	public List<ProjectForm> getProjectDataOfUser(String userName) {
		List<ProjectForm> lstProjectForm = new ArrayList<ProjectForm>();
		List<ProjectDtls> lstProjectDtls = projectDAO.getProjectDataOfUser(userName);
		for (ProjectDtls projectDtls : lstProjectDtls) {
			ProjectForm projectForm = new ProjectForm();
			projectForm.setProjDate(projectDtls.getProjDate());
			projectForm.setProjDesc(projectDtls.getProjDesc());
			projectForm.setProjName(projectDtls.getProjName());
			projectForm.setProjStatus(projectDtls.getProjStatus());
			projectForm.setUserName(projectDtls.getUserName());

			lstProjectForm.add(projectForm);
		}
		return lstProjectForm;
	}

	@Override
	public List<ProjectForm> getlast10DaysAllProjectData() {
		List<ProjectForm> lstProjectForm = new ArrayList<ProjectForm>();
		List<ProjectDtls> lstProjectDtls = projectDAO.getlast10DaysAllProjectData();
		for (ProjectDtls projectDtls : lstProjectDtls) {
			ProjectForm projectForm = new ProjectForm();
			projectForm.setProjDate(projectDtls.getProjDate());
			projectForm.setProjDesc(projectDtls.getProjDesc());
			projectForm.setProjName(projectDtls.getProjName());
			projectForm.setProjStatus(projectDtls.getProjStatus());
			projectForm.setUserName(projectDtls.getUserName());

			lstProjectForm.add(projectForm);
		}
		return lstProjectForm;

	}

	@Override
	public List<ProjectForm> getlast10ProjectDataOfUser(String userName) {
		List<ProjectForm> lstProjectForm = new ArrayList<ProjectForm>();
		List<ProjectDtls> lstProjectDtls = projectDAO.getlast10ProjectDataOfUser(userName);
		for (ProjectDtls projectDtls : lstProjectDtls) {
			ProjectForm projectForm = new ProjectForm();
			projectForm.setProjDate(projectDtls.getProjDate());
			projectForm.setProjDesc(projectDtls.getProjDesc());
			projectForm.setProjName(projectDtls.getProjName());
			projectForm.setProjStatus(projectDtls.getProjStatus());
			projectForm.setUserName(projectDtls.getUserName());

			lstProjectForm.add(projectForm);
		}
		return lstProjectForm;
	}
	
	
}