package org.baeldung.persistence.model.pfe;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "avocat")
public class Avocat {
	@Id
	@Column(unique = true, nullable = false, length = 80, name = "CIN_AVOCAT")
	private String cinAvocat;
	
	@Column(length = 70, name = "PRENOM_AVOCAT")
	private String prenom;
	
	@Column(length = 70, name = "NOM_AVOCAT")
	private String nom;
	
	@Column(length = 80, name = "ADRESSE_AVOCAT")
	private String addresse;
	
	@Column(name = "Haya_AVOCAT")
	private Long idBarreau;
	
	@OneToMany(mappedBy = "avocat", fetch = FetchType.LAZY)
	private Collection<Accuse> accuses;
	
	@OneToMany(mappedBy = "avocat", fetch = FetchType.LAZY)
	private Collection<Victime> victimes;
	
	@ManyToOne
	@JoinColumn(name = "Haya_AVOCAT",referencedColumnName="ID_BARREAU", insertable=false, updatable=false)
	private Barreau barreau;
	
	
	public String getCin() {
		return cinAvocat;
	}
	public void setCin(String cinAvocat) {
		this.cinAvocat = cinAvocat;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public Long getHaya() {
		return idBarreau;
	}
	public void setHaya(Long idBarreau) {
		this.idBarreau = idBarreau;
	}
	
	
}
