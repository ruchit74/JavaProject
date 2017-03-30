package main.java.net.manageproject.dao;


import java.util.List;

import javax.annotation.Resource;

import main.java.net.manageproject.form.LoginForm;
import main.java.net.manageproject.form.PasswordChangeForm;
import main.java.net.manageproject.form.Registration;
import main.java.net.manageproject.model.Users;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public boolean checkLogin(LoginForm loginForm) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		// Query using Hibernate Query Language
		final Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("userName", loginForm.getUserName()));
		crit.add(Restrictions.eq("userPassword", loginForm.getPassword()));
		crit.add(Restrictions.eq("userType", loginForm.getUserType()));
		List<Users> lstUser = crit.list();

		if ((lstUser != null) && (lstUser.size() > 0)) {
			userFound = true;
		}

		session.close();
		return userFound;
	}

	@Override
	public Users getLoginData(LoginForm loginForm) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		// Query using Hibernate Query Language
		final Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("userName", loginForm.getUserName()));
		crit.add(Restrictions.eq("userPassword", loginForm.getPassword()));
		crit.add(Restrictions.eq("userType", loginForm.getUserType()));
		List<Users> lstUser = crit.list();
		Users users = null;
		if ((lstUser != null) && (lstUser.size() > 0)) {
			users = lstUser.get(0);
		}
		session.close();
		return users;
	}

	public boolean checkLogin(String userName, String userPassword) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		// Query using Hibernate Query Language
		String SQL_QUERY = " from Users as o where o.userName=? and o.userPassword=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}

		session.close();
		return userFound;
	}

	@Override
	public Users saveLoginData(Registration registration) {

		Session session = sessionFactory.openSession();

		Users users = new Users();
		users.setUserType("user");
		users.setUserFirstTime("0");
		users.setUserName(registration.getUserName());
		users.setUserPassword(registration.getPassword());
		session.save(users);
		session.close();
		return users;
	}

	@Override
	public Users updateLoginData(PasswordChangeForm passwordchangeform) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		// Query using Hibernate Query Language
		final Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("userName", passwordchangeform.getUserName()));
		Users users = (Users) crit.uniqueResult();
		if (users != null) {
			users.setUserFirstTime("1");
			users.setUserPassword(passwordchangeform.getPassword());
		} else {
			users = new Users();
		}

		session.close();
		return users;
	}

	@Override
	public boolean checkUserPresent(String userName) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		// Query using Hibernate Query Language
		final Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("userName", userName));
		List<Users> lstUser = crit.list();

		if ((lstUser != null) && (lstUser.size() > 0)) {
			userFound = true;
		}

		session.close();
		return userFound;
	}
	
	@Override
	public Users getLoginDataByUser(String userName) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		// Query using Hibernate Query Language
		final Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("userName", userName));
		List<Users> lstUser = crit.list();
		Users users = null;
		if ((lstUser != null) && (lstUser.size() > 0)) {
			users = lstUser.get(0);
		}
		session.close();
		return users;
	}

}