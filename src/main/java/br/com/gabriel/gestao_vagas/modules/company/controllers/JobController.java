package br.com.gabriel.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.gestao_vagas.modules.company.entities.JobEntity;
import br.com.gabriel.gestao_vagas.modules.company.services.CreateJobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
  @Autowired
  private CreateJobService createJobService;

  @PostMapping("")
  public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity, HttpServletRequest request) {
    try {
      var companyId = request.getAttribute("company_id");
      jobEntity.setId_company(UUID.fromString(companyId.toString()));
      this.createJobService.execute(jobEntity);

      return ResponseEntity.status(201).body(jobEntity);
    } catch (Exception e) {
        return ResponseEntity.status(401).body(e.getMessage());
    }
  }
}