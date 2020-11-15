package com.MyCVOnline.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "APPLICANTS_EDUCATION")
public class ApplicantEducation implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Column(name = "EDUCATION_TITLE")
	private String educationTitle;

	@Column(name = "SCHOOL_NAME")
	private String schoolName;

	@NotNull
	@DateTimeFormat(pattern = "DD/MM/YYYY")
	@Column(name = "START_DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private String startDate;

	@DateTimeFormat(pattern = "DD/MM/YYYY")
	@Column(name = "END_DATE")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private String endDate;

	@Column(name = "DESCRIPTION")
	private String description;

	@Lob
	@Column(name = "EDU_LOGO", columnDefinition = "BLOB")
	private byte[] eduLogo;

	@Id
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;

	public ApplicantEducation() {
		super();

	}

	public ApplicantEducation(String educationTitle, String schoolName, String startDate, String endDate,
			String description, byte[] eduLogo, Applicant applicant) {
		super();
		this.educationTitle = educationTitle;
		this.schoolName = schoolName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.eduLogo = eduLogo;
		this.applicant = applicant;
	}

	public String getEducationTitle() {
		return educationTitle;
	}

	public void setEducationTitle(String educationTitle) {
		this.educationTitle = educationTitle;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getEduLogo() {
		return eduLogo;
	}

	public void setEduLogo(byte[] eduLogo) {
		this.eduLogo = eduLogo;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "ApplicantEducation \neducationTitle: " + educationTitle + "\nschoolName: " + schoolName
				+ "\nstartDate: " + startDate + "\nendDate: " + endDate + "\ndescription: " + description
				+ "\napplicant: " + applicant;
	}

}
