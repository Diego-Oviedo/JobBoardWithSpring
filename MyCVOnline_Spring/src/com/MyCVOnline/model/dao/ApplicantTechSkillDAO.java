package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import com.MyCVOnline.model.ApplicantTechSkill;

public interface ApplicantTechSkillDAO {

	public void insertApplicantTechSkill(ApplicantTechSkill techSkill);

	public void deleteApplicantTechSkill(String applicantID, String skillName);

	public ApplicantTechSkill retreiveApplicantTechSkill(String applicantID, String skillName);

	public ArrayList<ApplicantTechSkill> retreiveAppicantTechnicalSkillsByID(String applicantID);

	public void updateApplicantTechSkill(ApplicantTechSkill techSkill);

	public ArrayList<ApplicantTechSkill> retreiveAppicantTechnicalSkills();

}
