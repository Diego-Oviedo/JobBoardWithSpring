package com.MyCVOnline.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Companies")
@ComponentScan("com.MyCVOnline") 
public class CompanyController {

}
