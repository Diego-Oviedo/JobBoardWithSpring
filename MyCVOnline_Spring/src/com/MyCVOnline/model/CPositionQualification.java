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
@Table(name = "C_POSITIONS_QUALIFICATIONS")
public class CPositionQualification implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Column(name = "QUALIFICATION_NAME")
	private String qualificationName;

	@Column(name = "DESIRED_YEARS")
	private String desiredYears;

	@Column(name = "QUALIFICATION_DESCRIPTION")
	private String qualificationDescription;
	
	@Id
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "POSITION_ID")
	private CompanyPosition position;

	public CPositionQualification() {
		super();

	}

	public CPositionQualification(CompanyPosition position, String qualificationName, String desiredYears,
			String qualificationDescription) {
		super();
		this.position = position;
		this.qualificationName = qualificationName;
		this.desiredYears = desiredYears;
		this.qualificationDescription = qualificationDescription;
	}

	public CompanyPosition getPosition() {
		return position;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public String getDesiredYears() {
		return desiredYears;
	}

	public String getQualificationDescription() {
		return qualificationDescription;
	}

	public void setPosition(CompanyPosition position) {
		this.position = position;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public void setDesiredYears(String desiredYears) {
		this.desiredYears = desiredYears;
	}

	public void setQualificationDescription(String qualificationDescription) {
		this.qualificationDescription = qualificationDescription;
	}

	@Override
	public String toString() {
		return "CPositionQualification [position=" + position + ", qualificationName=" + qualificationName
				+ ", desiredYears=" + desiredYears + ", qualificationDescription=" + qualificationDescription + "]";
	}

}
