package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.CompanyEmployee;
import com.MyCVOnline.model.CompanyPosition;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.CompanyPositionDAO;

public class CompanyPositionDAOImpl extends AbstractDAO<CompanyPosition> implements CompanyPositionDAO {

	@Transactional
	public void insertJobPosition(CompanyPosition position, CompanyEmployee employee) {
		 
		position.setCompany(employee.getCompany());
		
		save(position);
		

	}

	@Transactional
	public void deleteJobPosition(String positionID) {
		
		Query query = getSession().createQuery("FROM COMPANIES_POSITIONS WHERE position_id = :positionID ");
		query.setParameter("positionID", positionID);

		CompanyPosition position = (CompanyPosition)query.uniqueResult();
		
		delete(position);
	}

	@Transactional
	public CompanyPosition retreiveJobPosition(String positionID) {
		
		Query query = getSession().createQuery("FROM COMPANIES_POSITIONS WHERE position_id = :positionID ");
		query.setParameter("positionID", positionID);

		CompanyPosition position = (CompanyPosition)query.uniqueResult();
		
		return position;
	}

	@Transactional
	public void updateJobPosition(CompanyPosition position) {
		Query query = getSession().createQuery("UPDATE COMPANIES_POSITIONS"
											+ "job_title = :jobTitle"
											+ "job_description = :jobDescription"
											+ "job_domain = :jobDomain"
											+ "type_of_job = :typeOfJob"
											+ "availability = :availability"
											+ "offer_salary = :offerSalary"
											+ "additional_compensation = :additionalCompensation"
											+ "WHERE position_id = :positionID ");
				query.setParameter("jobTitle", position.getPositionID());
				query.setParameter("jobDescription", position.getJobDescription());
				query.setParameter("jobDomain", position.getJobDomain());
				query.setParameter("typeOfJob", position.getTypeOfJob());
				query.setParameter("availability", position.getAvailability());
				query.setParameter("offerSalary", position.getOfferSalary());
				query.setParameter("additionalCompensation", position.getAdditionalCompensation());
				query.setParameter("positionID", position.getPositionID());
				
				query.executeUpdate();
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositions() {
		
		
		
		return null;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByCompanyID(String companyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByDomain(String domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByTypeOfJob(String typeOfJob) {
		// TODO Auto-generated method stub
		return null;
	}

}
