package main.java.net.manageproject.form;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
public class LoginForm {
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;
	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;

	private String userFirstTime;
	
	
	public String getUserFirstTime() {
		return userFirstTime;
	}
	public void setUserFirstTime(String userFirstTime) {
		this.userFirstTime = userFirstTime;
	}
	@Size(min = 1, max = 20)
	private String userType;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
}
