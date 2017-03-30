package main.java.net.manageproject.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Registration {
	private String userName;
	@NotEmpty
	@Size(min = 4, max = 20)
	private String password;
	@NotEmpty
	private String confirmPassword;
	private String isAlredyExist; 
	
	public String getIsAlredyExist() {
		return isAlredyExist;
	}

	public void setIsAlredyExist(String isAlredyExist) {
		this.isAlredyExist = isAlredyExist;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

}