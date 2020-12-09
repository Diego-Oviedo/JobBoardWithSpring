package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.Application;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.ApplicationDAO;

public class ApplicationDAOImpl extends AbstractDAO<Application> implements ApplicationDAO {

	@Transactional
	public void insertApplication(Application application) {
		
		save(application);

	}

	@Transactional
	public void deleteApplication(String applicationNumber) {
		
		Application application = getByID(applicationNumber);
		
		delete(application);

	}

	@Transactional
	public Application retreiveApplication(String applicationNumber) {
		
		Application application = getByID(applicationNumber);
		
		return application;
	}

	@Transactional
	public ArrayList<Application> retreiveApplications() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>) criteria.list();
		
		
		return applicantions;
	}

	@Transactional
	public void updateApplication(Application application) {
		Query query = getSession().createQuery("UPDATE APPLICATIONS"
												+ " application_date = ;applicationDate "
												+ " applicant_id = ;applicantID "
												+ " position_id = ;positionID "
												+ "WHERE application_number = :applicationNumber ");
		query.setParameter("applicationDate", application.getApplicationDate());
		query.setParameter("applicantID", application.getApplicant().getApplicantID());
		query.setParameter("positionID", application.getPosition().getPositionID());
		query.setParameter("applicationNumber", application.getApplicationNumber());
		
		query.executeUpdate();
		
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByApplicantID(String applicantID) {
		
		Query query = getSession().createQuery("FROM APPLICATIONS WHERE applicant_id = :applicantID ");
		query.setParameter("applicantID", applicantID);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByCompany(String companyID) {
		
		Query query = getSession().createQuery("FROM APPLICATIONS WHERE position_id IN ( position_id FROM COMPANIES WHERE company_id LIKE '%:companyID%' ) ");
		query.setParameter("companyID", companyID);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
		
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByPostID(String jobPostID) {
		
		Query query = getSession().createQuery("FROM APPLICATIONS WHERE position_id = :jobPostID ");
		query.setParameter("jobPostID", jobPostID);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByCity(String city) {
		
		Query query = getSession().createQuery("FROM APPLICATIONS WHERE position_id IN ( position_id FROM COMPANIES c WHERE c.city LIKE '%:city%' UNION FROM APPLICANTS a WHERE a.city LIKE '%:city%' ) ");
		query.setParameter("city", city);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByDomain(String domain) {

		Query query = getSession().createQuery("FROM APPLICATIONS WHERE position_id IN ( position_id FROM COMPANIES WHERE job_domain LIKE '%:domain%' ) ");
		query.setParameter("domain", domain);
		
		@SuppressWarnings("unchecked") 
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByCountry(String country) {

		Query query = getSession().createQuery("FROM APPLICATIONS WHERE position_id IN ( position_id FROM COMPANIES c WHERE c.country LIKE '%:country%' UNION FROM APPLICANTS a WHERE a.country LIKE '%:country%' ) ");
		query.setParameter("country", country);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByTypeOfJob(String typeOfJob) {
		
		Query query = getSession().createQuery("FROM APPLICATIONS WHERE position_id IN ( position_id FROM COMPANIES WHERE type_of_job = :typeOfJob ) ");
		query.setParameter("typeOfJob", typeOfJob);
		
		@SuppressWarnings("unchecked") 
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
		
	}

}
