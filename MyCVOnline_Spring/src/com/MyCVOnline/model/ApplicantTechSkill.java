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
@Table(name = "APPLICANTS_TECH_SKILLS")
public class ApplicantTechSkill implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;

	@Column(name = "SKILL_NAME")
	private String skillName;

	public ApplicantTechSkill() {
		super();
	}

	public ApplicantTechSkill(Applicant applicant, String skillName) {
		super();
		this.applicant = applicant;
		this.skillName = skillName;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "ApplicantTechSkill [applicant=" + applicant + ", skillName=" + skillName + "]";
	}

}
