package com.acme.catchup.backendflowsense.company.rest;

import com.acme.catchup.backendflowsense.company.aggregates.Company;
import com.acme.catchup.backendflowsense.company.services.CompanyCommandServiceImpl;
import com.acme.catchup.backendflowsense.company.services.CompanyQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    private CompanyCommandServiceImpl commandService;
    @Autowired
    private CompanyQueryServiceImpl queryService;

    @GetMapping
    public List<Company> getAll() {
        return queryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id) {
        return queryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        return commandService.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company company) {
        return queryService.findById(id)
                .map(c -> {
                    c.setNombre(company.getNombre());
                    c.setEmail(company.getEmail());
                    c.setDescripcion(company.getDescripcion());
                    c.setLogoUrl(company.getLogoUrl());
                    c.setEstado(company.getEstado());
                    return ResponseEntity.ok(commandService.save(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commandService.delete(id);
    }
} 