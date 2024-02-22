package br.com.gabriel.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.gabriel.gestao_vagas.modules.company.services.CreateComapanyService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {
  @Autowired
  private CreateComapanyService createComapanyService;

  @PostMapping()
  public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
    try {
      CompanyEntity result = this.createComapanyService.execute(companyEntity);

      

      return ResponseEntity.status(201).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(401).body(e.getMessage());
    }
  }
}
