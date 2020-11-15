package com.MyCVOnline.controller;


import java.util.ArrayList;
import com.MyCVOnline.model.*;
import com.MyCVOnline.model.service.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("retreive")
@ComponentScan("com.MyCVOnline") 
public class AppController {

	@Autowired
	ApplicantService applicant_service;
	
	 @Autowired
	 MessageSource messageSource;

	 // This method will list all existing employees.    
	 	@RequestMapping("applicants")
	    public String listApplicants(ModelMap model) {
	  
	        ArrayList<Applicant> applicants = applicant_service.retreiveApplicants();
	        model.addAttribute("applicants", applicants);
	        return "AllApplicants";
	    }
//	      
//	    // This method will provide the medium to add a new employee.     
//	    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
//	    public String newEmployee(ModelMap model) {
//	        Applicant applicant = new Applicant();
//	        model.addAttribute("applicant", applicant);
//	        model.addAttribute("edit", false);
//	        return "registration";
//	    }
//	      
//	     // This method will be called on form submission, handling POST request for
//	     // saving employee in database. It also validates the user input     
//	    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
//	    public String saveEmployee(@Valid Applicant applicant, BindingResult result,
//	            ModelMap model) {
//	  
//	        if (result.hasErrors()) {
//	            return "registration";
//	        }
//	          
//	         // Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
//	         // and applying it on field [ssn] of Model class [Employee].Below mentioned peace of code [if block] is 
//	          // to demonstrate that you can fill custom errors outside the validation
//	         // framework as well while still using internationalized messages.
//	           
//	       
//	        if(!applicant_service.isApplicantIDUnique(applicant.getApplicantID())){
//	            /*FieldError IDError =new FieldError("applicant","applicantID",messageSource.getMessage("non.unique.ssn", new String[]{applicant.getApplicantID()}));
//	            result.addError(IDError);*/
//	            return "registration";
//	        }
//	          
//	        applicant_service.insertApplicant(applicant);
//	  
//	        model.addAttribute("success", "Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " registered successfully");
//	        return "success";
//	    }
//	      
//	     // This method will provide the medium to update an existing employee.     
//	    @RequestMapping(value = { "/edit-{applicantID}-employee" }, method = RequestMethod.GET)
//	    public String editEmployee(@PathVariable String applicantID, ModelMap model) {
//	    	Applicant applicant = applicant_service.retreiveApplicant(applicantID);
//	        model.addAttribute("applicant", applicant);
//	        model.addAttribute("edit", true);
//	        return "registration";
//	    }
//	      
//	    
//	     // This method will be called on form submission, handling POST request for
//	     // updating employee in database. It also validates the user input
//	     
//	    @RequestMapping(value = { "/edit-{applicantID}-employee" }, method = RequestMethod.POST)
//	    public String updateEmployee(@Valid Applicant applicant, BindingResult result,
//	            ModelMap model, @PathVariable String applicantID) {
//	  
//	        if (result.hasErrors()) {
//	            return "registration";
//	        }
//	  
//	        if(!applicant_service.isApplicantIDUnique(applicantID)){
//	            /*FieldError ssnError =new FieldError("applicant","applicantID",messageSource.getMessage("non.unique.ssn", new String[]{applicant.getApplicantID()}));
//	            result.addError(ssnError);*/
//	            return "registration";
//	        }
//	  
//	        applicant_service.updateApplicant(applicant);
//	  
//	        model.addAttribute("success", "Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " updated successfully");
//	        return "success";
//	    }
//	          
//	     // This method will delete an employee by it's SSN value.     
//	    @RequestMapping(value = { "/delete-{applicantID}-employee" }, method = RequestMethod.GET)
//	    public String deleteEmployee(@PathVariable String applicantID) {
//	    	applicant_service.deleteApplicant(applicantID);
//	        return "redirect:/list";
//	    }
//	 
	 
}
