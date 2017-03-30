package main.java.net.manageproject.dao;

import java.util.List;

import main.java.net.manageproject.form.ProjectForm;
import main.java.net.manageproject.model.ProjectDtls;
/*
 @Author: @Author: Viral Mavani
 */

public interface ProjectDAO {
	ProjectDtls getProjectData(String userName);

	ProjectDtls saveProjectData(ProjectDtls projectDtls);

	List<ProjectDtls> getAllProjectData();

	List<String> getUniqueProjectName();

	List<ProjectDtls> getAllUserOfProject(String projectName);

	List<ProjectDtls> getProjectDataOfUser(String userName);

	List<ProjectDtls> getlast10DaysAllProjectData();

	List<ProjectDtls> getlast10ProjectDataOfUser(String userName);
}