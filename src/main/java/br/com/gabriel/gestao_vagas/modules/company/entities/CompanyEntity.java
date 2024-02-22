package br.com.gabriel.gestao_vagas.modules.company.entities;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity(name = "company")
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotBlank()
	@Pattern(regexp = "\\S+", message = "The field [username] should not have space.")
	private String username;

	@Email(message = "This field [email] should have write in email format: example@gmail.com.")
	private String email;
	
	@Length(min = 6, max = 20, message = "The field [passord] should have beetween 6 and 20 letters or numbers.")
	private String password;
	private String website;
	private String name;
	private String description;
	
	@CreationTimestamp
	private LocalDateTime createdAt;

	public CompanyEntity() {}

	public CompanyEntity(UUID id, String username, String email, String password, String website, String name,
		String description) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.website = website;
		this.name = name;
		this.description = description;
	}

	public UUID getId() {
		return id;
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
	 
	public String getWebsite() {
		return website;
	}
	 
	public void setWebsite(String website) {
		this.website = website;
	}
	 
	public String getName() {
		return name;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	 
	public String getDescription() {
		return description;
	}
	 
	public void setDescription(String description) {
		this.description = description;
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
		CompanyEntity other = (CompanyEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
}