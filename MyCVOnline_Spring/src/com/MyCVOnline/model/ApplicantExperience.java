package com.MyCVOnline.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "APPLICANTS_EXPERIENCES")
public class ApplicantExperience implements Serializable{


	private static final long serialVersionUID = 1L;

	@Column(name = "EXPERIENCE_TITLE")
	private String experienceTitle;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "START_DATE", nullable = false)
	@Type(type = "org.hibernate.type.LocalDateTimeTyp")
	private LocalDateTime startDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "END_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	private LocalDateTime endDate;

	@Column(name = "DESCRIPTION")
	private String description;

	@Lob
	@Column(name = "EXP_LOGO", columnDefinition = "BLOB")
	private byte[] expLogo;
	
	@Id
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;

	public ApplicantExperience() {
		super();
	}

	public ApplicantExperience(String experienceTitle, String companyName, LocalDateTime startDate, LocalDateTime endDate,
			String description, byte[] expLogo, Applicant applicant) {
		super();
		this.experienceTitle = experienceTitle;
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.expLogo = expLogo;
		this.applicant = applicant;
	}

	public String getExperienceTitle() {
		return experienceTitle;
	}

	public void setExperienceTitle(String experienceTitle) {
		this.experienceTitle = experienceTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getExpLogo() {
		return expLogo;
	}

	public void setExpLogo(byte[] expLogo) {
		this.expLogo = expLogo;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "ApplicantExperience \nexperienceTitle: " + experienceTitle + "\ncompanyName: " + companyName
				+ "\nstartDate: " + startDate + "\nendDate: " + endDate + "\ndescription: " + description
				+ "\napplicant: " + applicant;
	}

}
