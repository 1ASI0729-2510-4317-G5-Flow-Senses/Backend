package com.acme.catchup.backendflowsense.freelancer.rest;

import com.acme.catchup.backendflowsense.freelancer.aggregates.Freelancer;
import com.acme.catchup.backendflowsense.freelancer.services.FreelancerCommandServiceImpl;
import com.acme.catchup.backendflowsense.freelancer.services.FreelancerQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/freelancers")
public class FreelancerController {
    @Autowired
    private FreelancerCommandServiceImpl commandService;
    @Autowired
    private FreelancerQueryServiceImpl queryService;

    @GetMapping
    public List<Freelancer> getAll() {
        return queryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Freelancer> getById(@PathVariable Long id) {
        return queryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Freelancer create(@RequestBody Freelancer freelancer) {
        return commandService.save(freelancer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Freelancer> update(@PathVariable Long id, @RequestBody Freelancer freelancer) {
        return queryService.findById(id)
                .map(f -> {
                    f.setNombre(freelancer.getNombre());
                    f.setEmail(freelancer.getEmail());
                    f.setProfesion(freelancer.getProfesion());
                    f.setDescripcion(freelancer.getDescripcion());
                    f.setFotoUrl(freelancer.getFotoUrl());
                    f.setEstado(freelancer.getEstado());
                    return ResponseEntity.ok(commandService.save(f));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commandService.delete(id);
    }
} 