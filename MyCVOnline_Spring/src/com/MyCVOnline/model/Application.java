package com.MyCVOnline.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import com.MyCVOnline.configuration.StringSequenceIdentifier;

@Entity
@Table(name = "APPLICATIONS")
public class Application  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "APPLICATION_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Applicantion_SEQ")
	@GenericGenerator(name = "Applicantion_SEQ", strategy = "com.MyCVOnline.configuration.StringSequenceIdentifier", parameters = {
			@Parameter(name = StringSequenceIdentifier.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringSequenceIdentifier.VALUE_PREFIX_PARAMETER, value = "A"),
			@Parameter(name = StringSequenceIdentifier.NUMBER_FORMAT_PARAMETER, value = "%06d") })
	private String applicationNumber;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "APPLICATION_DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private String applicationDate;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "POSITION_ID")
	private CompanyPosition position;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;

	public Application() {
		super();
	}

	public Application(String applicationNumber, String applicationDate, CompanyPosition position,
			Applicant applicant) {
		super();
		this.applicationNumber = applicationNumber;
		this.applicationDate = applicationDate;
		this.position = position;
		this.applicant = applicant;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public CompanyPosition getPosition() {
		return position;
	}

	public void setPosition(CompanyPosition position) {
		this.position = position;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "Application [applicationNumber=" + applicationNumber + ", applicationDate=" + applicationDate
				+ ", position=" + position + ", applicant=" + applicant + "]";
	}

}
