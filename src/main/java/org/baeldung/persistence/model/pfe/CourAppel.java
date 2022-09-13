package org.baeldung.persistence.model.pfe;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cour_appel")
public class CourAppel {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nom;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cour_appel")
	private Collection<PremiereInstance> premiereInstances = new ArrayList<PremiereInstance>();

	public CourAppel() {
		
	}

	public CourAppel(String nom) {
		this.nom=nom;
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

	public Collection<PremiereInstance> getPremiereInstances() {
		return premiereInstances;
	}

	public void setPremiereInstances(Collection<PremiereInstance> premiereInstances) {
		this.premiereInstances = premiereInstances;
	}

	@Override
	public String toString() {
		return "CourAppel [id=" + id + ", nom=" + nom + ", premiereInstances=" + premiereInstances + "]";
	}
	
	
	
}
