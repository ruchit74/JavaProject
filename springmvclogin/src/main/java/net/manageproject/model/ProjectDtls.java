package main.java.net.manageproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projectDtls")
@SuppressWarnings("serial")
public class ProjectDtls implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id", length = 11)
	private Long id;

	@Column(name = "proj_date")
	Date projDate;

	@Column(name = "proj_name")
	String projName;

	@Column(name = "proj_desc")
	String projDesc;

	@Column(name = "proj_status")
	String projStatus;

	@Column(name = "user_name")
	String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}