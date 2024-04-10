package com.dzi.project.controllers;
import com.dzi.project.models.Company;
import com.dzi.project.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
@RequestMapping(value = "/")
public class UICompanyController {
    @Autowired
    private final CompanyService companyService;

    public UICompanyController(CompanyService companyService) {

        this.companyService = companyService;
    }

    @GetMapping(value = "companies")
    public String companyView(Model model) {
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("companies", companies);
        return "admin/companies";
    }

    @GetMapping("companies/create-company")
    public String createCompany(Model model) {
        model.addAttribute("company", new Company());
        return "admin/create-company";
    }

    @PostMapping(path = "/companies", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public RedirectView submitForm(Company company) {
        companyService.createCompany(company);
        return new RedirectView("/companies");
    }

    @GetMapping(value = "/companies/edit-company/{id}")
    public String editCompany(@PathVariable int id, Model model) {
        Company editCompany = companyService.getCompany(id);
        model.addAttribute("company", editCompany);
        return "admin/edit-company";
    }

    @PostMapping(value = "/companies/edit-company")
    public RedirectView editSubmitUser(@ModelAttribute(value = "company") Company company) {
        companyService.editCompany(company);
        return new RedirectView("/companies");
    }
}
