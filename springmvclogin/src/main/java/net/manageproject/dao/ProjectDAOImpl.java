package main.java.net.manageproject.dao;

/*
 @Author: @Author: Viral Mavani
 */
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import main.java.net.manageproject.form.ProjectForm;
import main.java.net.manageproject.model.ProjectDtls;
import main.java.net.manageproject.model.Users;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public ProjectDtls getProjectData(String userName) {
		ProjectDtls projectDtls = null;
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();

		// Query using Hibernate Query Language
		final Criteria crit = session.createCriteria(ProjectDtls.class);
		crit.add(Restrictions.eq("userName", userName));
		List<ProjectDtls> lstProjectDtls = crit.list();
		Users users = null;
		if ((lstProjectDtls != null) && (lstProjectDtls.size() > 0)) {
			projectDtls = lstProjectDtls.get(0);
		}
		session.close();
		return projectDtls;
	}

	@Override
	public ProjectDtls saveProjectData(ProjectDtls projectDtls) {
		Session session = sessionFactory.openSession();

		session.save(projectDtls);
		session.close();
		return projectDtls;
	}

	@Override
	public List<ProjectDtls> getAllProjectData() {
		Session session = sessionFactory.openSession();
		final Criteria crit = session.createCriteria(ProjectDtls.class);
		List<ProjectDtls> lstProjectDtls = crit.list();
		session.close();
		return lstProjectDtls;
	}

	@Override
	public List<ProjectDtls> getlast10DaysAllProjectData() {
		Date eDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		Date sDate = cal.getTime();
		Session session = sessionFactory.openSession();
		final Criteria crit = session.createCriteria(ProjectDtls.class);
		crit.add(Restrictions.between("projDate", sDate, eDate));
		List<ProjectDtls> lstProjectDtls = crit.list();
		session.close();
		return lstProjectDtls;
	}
	@Override
	public List<String> getUniqueProjectName() {
		Session session = sessionFactory.openSession();
		final Criteria crit = session.createCriteria(ProjectDtls.class);
		crit.setProjection(Projections.distinct(Projections
				.property("projName")));
		List<String> lstProjectName = crit.list();
		session.close();
		return lstProjectName;
	}

	@Override
	public List<ProjectDtls> getAllUserOfProject(String projectName) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();

		// Query using Hibernate Query Language
		final Criteria crit = session.createCriteria(ProjectDtls.class);
		crit.add(Restrictions.eq("projName", projectName));
		List<ProjectDtls> lstProjectDtls = crit.list();
		session.close();
		return lstProjectDtls;
	}

	@Override
	public List<ProjectDtls> getlast10ProjectDataOfUser(String userName) {
		Date eDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		Date sDate = cal.getTime();
		Session session = sessionFactory.openSession();
		final Criteria crit = session.createCriteria(ProjectDtls.class);
		crit.add(Restrictions.eq("userName", userName));
		crit.add(Restrictions.between("projDate", sDate, eDate));
		List<ProjectDtls> lstProjectDtls = crit.list();
		session.close();
		return lstProjectDtls;
	}
	@Override
	public List<ProjectDtls> getProjectDataOfUser(String userName) {
		Session session = sessionFactory.openSession();
		final Criteria crit = session.createCriteria(ProjectDtls.class);
		crit.add(Restrictions.eq("userName", userName));
		List<ProjectDtls> lstProjectDtls = crit.list();
		session.close();
		return lstProjectDtls;
	}
}