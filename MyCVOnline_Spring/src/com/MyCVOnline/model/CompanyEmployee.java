package com.MyCVOnline.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANIES_EMPLOYEES")
public class CompanyEmployee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMPLOYEE_FULL_NAME")
	private String fullName;
	
	@Id
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	public CompanyEmployee() {
		super();

	}

	public CompanyEmployee(Company company, String username, String password, String fullName) {
		super();
		this.company = company;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
	}

	public Company getCompany() {
		return company;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "CompanyEmployee [company=" + company + ", username=" + username + ", password=" + password
				+ ", fullName=" + fullName + "]";
	}

}
