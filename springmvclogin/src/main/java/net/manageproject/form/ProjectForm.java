package main.java.net.manageproject.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ProjectForm {
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd.MM.yyyy")
	private Date projDate;

	private String projName;

	private String projDesc;

	private String projStatus;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getProjDate() {
		return projDate;
	}

	public void setProjDate(Date projDate) {
		this.projDate = projDate;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjDesc() {
		return projDesc;
	}

	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}

	public String getProjStatus() {
		return projStatus;
	}

	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}

}
