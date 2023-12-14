package com.jacaranda.employeeCompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.employeeCompany.model.Company;
import com.jacaranda.employeeCompany.services.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/listCompanies")
	public String listCompanies(Model model) {
		List<Company> listCompanies = companyService.getCompanies();
		model.addAttribute("listCompanies", listCompanies);
		
		return "company/listCompanies";
	}
	
	@GetMapping("/addCompany")
	public String addCompany(Model model) {
		Company company = new Company();
		model.addAttribute("company",company);
		
		return "company/addCompany";
	}
	
	@GetMapping("/saveCompany")
	public String saveCompany(Model model, @ModelAttribute("company") Company companySave) {
		Company company = new Company();
		model.addAttribute("company",company);
		companyService.addCompany(companySave);
		model.addAttribute("add", "Compañia añadida correctamente");
		return "company/addCompany";
	}
	
	@GetMapping("/deleteCompany")
	public String deleteCompany(Model model,@RequestParam("id") Company deleteCompany) {
		
		model.addAttribute("company",deleteCompany);
		
		return "company/deleteCompany";
	}
	
	@GetMapping("/confirmDeleteCompany")
	public String deleteFCompany(Model model,@ModelAttribute("company") Company deleteCompany) {
		Company company = new Company();
		model.addAttribute("company",company);
		companyService.deleteCompany(deleteCompany);
		model.addAttribute("delete", "Compañia borrada correctamente");
		return "company/deleteCompany";
	}
	
	@GetMapping("/editCompany")
	public String editCompany(Model model,@RequestParam("id") Company companyEdit) {
		
		model.addAttribute("company",companyEdit);
		
		return "company/editCompany";
	}
	
	@GetMapping("/confirmEditCompany")
	public String confirmEditCompany(Model model,@ModelAttribute("company") Company editCompany) {
		Company company = new Company();
		model.addAttribute("company",company);
		companyService.addCompany(editCompany);
		model.addAttribute("edit", "Compañia editada correctamente");
		return "company/editCompany";
	}
}
