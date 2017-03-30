package main.java.net.manageproject.form; 
public class User {
	   private String userName;
	   private String email;	   
	   private String userType;
	   
	   public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setUserName(String userName){
		      this.userName=userName;
		  }
	   public String getUserName(){
		      return userName;
	   }	   
	   public void setEmail(String email){
		      this.email=email;
		  }
	   public String getEmail(){
		      return email;
	   }
	}
