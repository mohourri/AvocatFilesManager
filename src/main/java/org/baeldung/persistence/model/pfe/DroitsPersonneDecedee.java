package org.baeldung.persistence.model.pfe;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "avec_les_droits_de_la_personne_decedee")
public class DroitsPersonneDecedee {
	@Id
	@Column(unique = true, nullable = false, name = "ID_DAWI")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDawi;
	
	@Column(length = 20, name = "CIN")
	private String cin;
	
	@Column(length = 40, name = "NOM")
	private String nom;
	
	@Column(length = 40, name = "PRENOM")
	private String prenom;
	
	@Column(length = 100, name = "ADRESSE")
	private String addresse;
	
	@Column(length = 20, name = "Situation_fam")
	private String situationFamilialle;
	
	@Column(name = "DATE_NAISSANCE_DAWI")
	private Date dateNaissance;
	
	@Column(nullable = false, name = "ta3wid_dawi")
	private Double ta3widDawi;
	
	@Column(nullable = false, name = "Ta3wid_Ma3nawi")
	private Double ta3widMa3nawi;
	
	@Column(length = 50, name = "proffession")
	private String proffession;
	
	@Column(name = "nisbMadi")
	private Integer nisbMadi;
	
	@OneToMany(mappedBy = "droitsPersonneDecedee", fetch = FetchType.LAZY)
	private Collection<Indemnite> indemnites;
	
	public Long getId() {
		return idDawi;
	}
	public void setId(Long idDawi) {
		this.idDawi = idDawi;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getSituationFamilialle() {
		return situationFamilialle;
	}
	public void setSituationFamilialle(String situationFamilialle) {
		this.situationFamilialle = situationFamilialle;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Double getTa3wid() {
		return ta3widDawi;
	}
	public void setTa3wid(Double ta3widDawi) {
		this.ta3widDawi = ta3widDawi;
	}
	public Double getTa3widMa3nawi() {
		return ta3widMa3nawi;
	}
	public void setTa3widMa3nawi(Double ta3widMa3nawi) {
		this.ta3widMa3nawi = ta3widMa3nawi;
	}
	public String getProffession() {
		return proffession;
	}
	public void setProffession(String proffession) {
		this.proffession = proffession;
	}
	public Integer getNisbMadi() {
		return nisbMadi;
	}
	public void setNisbMadi(Integer nisbMadi) {
		this.nisbMadi = nisbMadi;
	}
	
	
	
}
