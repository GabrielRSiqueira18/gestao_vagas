package br.com.gabriel.gestao_vagas.modules.company.entities;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "job")
public class JobEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String description;
	private String benefits;
	private String level;

	@ManyToOne()
	@JoinColumn(name = "id_company", insertable = false, updatable = false)
	private CompanyEntity companyEntity;

	@Column(name = "id_company", nullable = false)
	private UUID id_company;

	@CreationTimestamp
	private LocalDateTime createdAt;

	public JobEntity() {}

	public JobEntity(UUID id, String description, String benefits, String level, UUID id_company) {
		this.id = id;
		this.description = description;
		this.benefits = benefits;
		this.level = level;
		this.id_company = id_company;
	}

	public UUID getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public UUID getId_company() {
		return id_company;
	}

	public void setId_company(UUID id_company) {
		this.id_company = id_company;
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
		JobEntity other = (JobEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	

}