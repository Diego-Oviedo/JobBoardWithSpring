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
@Table(name = "C_POSITIONS_EXPERIENCES")
public class CPositionExperience implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Column(name = "EXPERIENCE_NAME")
	private String experienceName;

	@Column(name = "EXPERIENCE_YEARS")
	private String desiredYears;

	@Column(name = "EXPERIENCE_DESCRIPTION")
	private String experienceDescription;
	
	@Id
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "POSITION_ID")
	private CompanyPosition position;

	public CPositionExperience() {
		super();

	}

	public CPositionExperience(CompanyPosition position, String experienceName, String desiredYears,
			String experienceDescription) {
		super();
		this.position = position;
		this.experienceName = experienceName;
		this.desiredYears = desiredYears;
		this.experienceDescription = experienceDescription;
	}

	public CompanyPosition getPosition() {
		return position;
	}

	public String getExperienceName() {
		return experienceName;
	}

	public String getDesiredYears() {
		return desiredYears;
	}

	public String getExperienceDescription() {
		return experienceDescription;
	}

	public void setPosition(CompanyPosition position) {
		this.position = position;
	}

	public void setExperienceName(String experienceName) {
		this.experienceName = experienceName;
	}

	public void setDesiredYears(String desiredYears) {
		this.desiredYears = desiredYears;
	}

	public void setExperienceDescription(String experienceDescription) {
		this.experienceDescription = experienceDescription;
	}

	@Override
	public String toString() {
		return "CPositionExperience [position=" + position + ", experienceName=" + experienceName + ", desiredYears="
				+ desiredYears + ", experienceDescription=" + experienceDescription + "]";
	}

}
