package br.com.gabriel.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.gabriel.gestao_vagas.modules.candidate.services.CreateCandidateService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	@Autowired
	private CreateCandidateService createCandidateService;

	@PostMapping("")
	public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
		try {
			var result = this.createCandidateService.execute(candidateEntity);
			return ResponseEntity.status(201).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}
}