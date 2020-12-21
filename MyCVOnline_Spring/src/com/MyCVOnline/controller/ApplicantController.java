package com.MyCVOnline.controller;


import java.io.IOException;
import java.util.ArrayList;
import com.MyCVOnline.model.*;
import com.MyCVOnline.model.service.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Applicants")
@ComponentScan("com.MyCVOnline") 
public class ApplicantController { 

	
	/***********Service's Dependency******************/
	@Autowired
	ApplicantService applicant_service;
	
	@Autowired
	ApplicantExperienceService applicant_experience_service;
	
	@Autowired
	ApplicantEducationService applicant_education_service;
	
	@Autowired
	ApplicantOtherSkillService applicant_other_skill_service;
	
	@Autowired
	ApplicantTechSkillService applicant_tech_skill_service;
	
	@Autowired
	ApplicationService application_service;
	
	@Autowired
	CompanyEmployeeService employee_service;
	
	@Autowired
	CompanyPositionService position_service;
	
	@Autowired
	CompanyService company_service;

	@Autowired
	PositionExperienceService position_experience_service;
	
	@Autowired
	PositionQualificationSarvice position_qualification_service;
	
	 @Autowired
	 MessageSource messageSource;

	
	 // This method will list all existing employees.    
	 	@RequestMapping(value = { "/All-Applicants" }, method = RequestMethod.GET)
	    public String getAllApplicants(ModelMap model, HttpServletResponse response) {
	  
	        ArrayList<Applicant> applicants = applicant_service.retreiveApplicants();
	        model.addAttribute("applicants", applicants);
	        
	        return "All-Applicants";
	    }
	 	
	 	 // This method will list all display .    
	 	@RequestMapping(value = { "/All-Applicants_Pictures" }, method = RequestMethod.GET)
	    public void getAllApplicantPictures(@PathVariable String applicantID, HttpServletResponse response,HttpServletRequest request) 
	            throws ServletException, IOException{
	 		
	 		System.out.println("Works when calling controller \n");
	 		
	 		Applicant applicant = applicant_service.retreiveApplicant(applicantID);
	        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	        response.getOutputStream().write(applicant.getProfilePicture());


	        response.getOutputStream().close();
	        //applicant_service.displayApplicantProfilePicture(applicantID, response);
			

	    }
	 	  
	      
	    // This method will provide the medium to add a new applicant.     
	    @RequestMapping(value = { "/New-Applicant" }, method = RequestMethod.GET)
	    public String newApplicant(ModelMap model) {
	    	
	        Applicant applicant = new Applicant();
	        model.addAttribute("applicant", applicant);
	        model.addAttribute("edit", false);
	        return "registration"; 
	    }
	      
	     // This method will be called on form submission, handling POST request for
	     // saving an applicant in database. It also validates the user input     
	    @RequestMapping(value = { "/New-Applicant" }, method = RequestMethod.POST)
	    public String saveApplicant(@Valid Applicant applicant, BindingResult result,
	            ModelMap model) {
	    	
	        if (result.hasErrors()) {
	        	
	        	model.addAttribute("error_adding_applicant","ERROR: " + result.getFieldError()); 
	            
	        	
	            return "registration";
	            }
 	        
	        	if(applicant_service.isApplicantUsernameAlreadyExists(applicant.getUsername())){
	        	
	            FieldError IDError =new FieldError("applicant","username",messageSource.getMessage("non.unique.ID", new String[]{applicant.getUsername()}, null));
	            result.addError(IDError);
	            
	            return "registration";
	        	}
	        	else if(!result.hasErrors()) {
	        		 
	        		applicant_service.insertApplicant(applicant);
	        		  
	        	}
	        	
     	        model.addAttribute("success", "Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " registered successfully");
     	        return "success";
	    }
	      
	    
	    
	    
	    
	    
	     // This method will provide the medium to update an existing applicant.     
	    @RequestMapping(value = { "/edit-{applicantID}-applicant" }, method = RequestMethod.GET)
	    public String editApplicant(@PathVariable String applicantID, ModelMap model) {
	    	Applicant applicant = applicant_service.retreiveApplicant(applicantID);
	        model.addAttribute("applicant", applicant);
	        model.addAttribute("edit", true);
	        return "Applicant";
	    }
	      
	    
	     // This method will be called on form submission, handling POST request for
	     // updating applicant in database. It also validates the user input
	     
	    @RequestMapping(value = { "/edit-{applicantID}-applicant" }, method = RequestMethod.POST)
	    public String updateApplicant(@Valid Applicant applicant, BindingResult result,
	            ModelMap model, @PathVariable String applicantID) {
	  
	        if (result.hasErrors()) {
	        	
	        	model.addAttribute("error_editing_applicant","ERROR: " + result.getFieldError()); 
	            return "Applicant";
	        }
	        
	        
	        //if the userame to edit already exists and is different that the previous one -> you will have to choose another oner 
	        if(applicant_service.isApplicantUsernameAlreadyExists(applicant.getUsername())&& !applicant.getUsername().equalsIgnoreCase(applicant.getUsername())){
	        	
	            FieldError IDError =new FieldError("applicant","username",messageSource.getMessage("non.unique.ID", new String[]{applicant.getUsername()}, null));
	            result.addError(IDError);
	            
	            return "registration";
	        	}
	  
	        if(!applicant_service.isApplicantIDAlreadyExists(applicantID)){
	            
	            model.addAttribute("error_editing_applicant","The Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " haven't been previously registered\n Please register as a new applicant.\n "); 
	            
	            return "registration";
	        }
	        
	        else if(!result.hasErrors()) {
       		 
	        	applicant_service.updateApplicant(applicant);
        		  
        	}

	        model.addAttribute("success", "Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " updated successfully");
	        return "success";
	    }
	          
	     // This method will delete an applicant by it's ID value.     
	    @RequestMapping(value = { "/delete-{applicantID}-applicant" }, method = RequestMethod.GET)
	    public String deleteApplicant(@PathVariable String applicantID,ModelMap model) {
	    	
	    	applicant_service.deleteApplicant(applicantID);
	        
	    	model.addAttribute("success", "Applicant successfully deleted!");
	        return "success";
	    	
	    }
	 
	 
	 
}
