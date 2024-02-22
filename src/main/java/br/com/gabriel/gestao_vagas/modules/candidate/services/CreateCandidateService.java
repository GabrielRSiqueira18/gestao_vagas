package br.com.gabriel.gestao_vagas.modules.candidate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.gestao_vagas.exceptions.UserFoundException;
import br.com.gabriel.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.gabriel.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateService {
  @Autowired
  private CandidateRepository candidateRepository;
  
  public CandidateEntity execute(CandidateEntity candidateEntity) {
    if(candidateEntity == null) {
			throw new IllegalArgumentException("Don't exsist candidate.");
		}

		this.candidateRepository
			.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
			.ifPresent((user) -> {
				throw new UserFoundException();
			});

		return this.candidateRepository.save(candidateEntity);
  }
}
