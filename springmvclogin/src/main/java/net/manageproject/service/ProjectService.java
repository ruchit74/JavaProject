package main.java.net.manageproject.service;

import java.util.List;

import main.java.net.manageproject.form.ProjectForm;
import main.java.net.manageproject.model.ProjectDtls;

/*
 @Author: Viral Mavani
 */

public interface ProjectService {

	ProjectDtls getProjectData(String userName);

	ProjectDtls saveProjectData(ProjectDtls projectDtls);

	List<ProjectForm> getAllProjectData();

	List<ProjectForm> getAllUserOfProject(String projectName);

	List<ProjectForm> getProjectDataOfUser(String userName);

	List<ProjectForm> getlast10DaysAllProjectData();

	List<ProjectForm> getlast10ProjectDataOfUser(String userName);

	List<String> getUniqueProjectName();

}