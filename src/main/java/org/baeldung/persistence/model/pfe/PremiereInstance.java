package org.baeldung.persistence.model.pfe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "premiere_instance")
public class PremiereInstance {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String nom;
	
	public PremiereInstance() {
		
	}
	public PremiereInstance( String nom) {
		
		this.nom = nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "PremiereInstance [id=" + id + ", nom=" + nom + "]";
	}

}
