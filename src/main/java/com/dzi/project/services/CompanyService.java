package com.dzi.project.services;

import com.dzi.project.models.Company;
import com.dzi.project.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompany(Integer id) {
        Optional<Company> user = companyRepository.findById(id);
        return user.orElse(null);
    }

    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    public void editCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }



}
