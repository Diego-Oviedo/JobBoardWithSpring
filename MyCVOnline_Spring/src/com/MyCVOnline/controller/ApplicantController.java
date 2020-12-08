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
import org.springframework.http.MediaType;
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

	@Autowired
	ApplicantService applicant_service;
	
	 @Autowired
	 MessageSource messageSource;

	 // This method will list all existing employees.    
	 	@RequestMapping(value = { "/All-Applicants" }, method = RequestMethod.GET)
	    public String getAllApplicants(ModelMap model, HttpServletResponse response) {
	  
	        ArrayList<Applicant> applicants = applicant_service.retreiveApplicants();
	        model.addAttribute("applicants", applicants);
	        return "AllApplicants";
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
	            return "registration";
	            }
	        
	        if(!applicant_service.isApplicantIDUnique(applicant.getApplicantID())){
	        	
	            FieldError IDError =new FieldError("applicant","applicantID",messageSource.getMessage("non.unique.ID", new String[]{applicant.getApplicantID()}, null));
	            result.addError(IDError);
	            return "registration";
	        	}
	          
	        applicant_service.insertApplicant(applicant);
	  
	        model.addAttribute("success", "Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " registered successfully");
	        return "success";
	    }
	      
	     // This method will provide the medium to update an existing applicant.     
	    @RequestMapping(value = { "/edit-{applicantID}-applicant" }, method = RequestMethod.GET)
	    public String editApplicant(@PathVariable String applicantID, ModelMap model) {
	    	Applicant applicant = applicant_service.retreiveApplicant(applicantID);
	        model.addAttribute("applicant", applicant);
	        model.addAttribute("edit", true);
	        return "registration";
	    }
	      
	    
	     // This method will be called on form submission, handling POST request for
	     // updating applicant in database. It also validates the user input
	     
	    @RequestMapping(value = { "/edit-{applicantID}-applicant" }, method = RequestMethod.POST)
	    public String updateApplicant(@Valid Applicant applicant, BindingResult result,
	            ModelMap model, @PathVariable String applicantID) {
	  
	        if (result.hasErrors()) {
	            return "registration";
	        }
	  
	        if(!applicant_service.isApplicantIDUnique(applicantID)){
	        	FieldError IDError =new FieldError("applicant","applicantID",messageSource.getMessage("non.unique.ID", new String[]{applicant.getApplicantID()}, null));
	            result.addError(IDError);
	            return "registration";
	        }
	  
	        applicant_service.updateApplicant(applicant);
	  
	        model.addAttribute("success", "Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " updated successfully");
	        return "success";
	    }
	          
	     // This method will delete an applicant by it's ID value.     
	    @RequestMapping(value = { "/delete-{applicantID}-applicant" }, method = RequestMethod.GET)
	    public String deleteApplicant(@PathVariable String applicantID) {
	    	applicant_service.deleteApplicant(applicantID);
	        return "redirect:/AllApplicants";
	    }
	 
	 
	 
}
