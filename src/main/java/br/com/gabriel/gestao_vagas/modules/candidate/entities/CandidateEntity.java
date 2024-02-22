package br.com.gabriel.gestao_vagas.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity(name = "candidate")
public class CandidateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	
	@NotBlank()
	@Pattern(regexp = "\\S+", message = "The field [username] should not have space.")
	private String username;

	@Email(message = "This field [email] should have write in email format: example@gmail.com.")
	private String email;
	
	@Length(min = 6, max = 20, message = "The field [passord] should have beetween 6 and 20 letters or numbers.")
	private String password;
	private String description;
	private String curriculum;

	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public CandidateEntity() {}

	public CandidateEntity(
		UUID id, 
		String name, 
		String username, 

		@Email
		String email, 
		String password, 
		String description,
		String curriculum
		) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.description = description;
		this.curriculum = curriculum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateEntity other = (CandidateEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}