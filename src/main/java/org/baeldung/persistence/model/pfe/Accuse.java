package org.baeldung.persistence.model.pfe;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accuse")
public class Accuse {
	@Id
    @Column(unique = true, nullable = false, name = "ID_ACC")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAccuse;
	
	@Column(length = 30, name = "CIN_ACCUSE")
	private String cin;
	
	@Column(length = 70, name = "PRENOM_ACCUSE")
	private String prenom;
	
	@Column(length = 70, name = "NOM_ACCUSE")
	private String nom;
	
	@Column(length = 150, name = "ADRESSE_ACCUSE")
	private String addresse;
	
	@Column(length = 6, name = "SEXE_ACCUSE")
	private String sexe;
	
	@Column(length = 100, name = "PRENOM_PERE_ACCUSE")
	private String prenomPere;
	
	@Column(length = 100, name = "PRENOM_MERE_ACCUSE")
	private String prenomMere;
	
	@Column(name = "DATE_NAISSANCE_ACCUSE")
	private Date dateNaissance;
	
	@Column(length = 200, name = "LIEU_DE_NAISSANCE_ACCUSE")
	private String lieuNaissance;
	
	@Column(length = 70, name = "PROFFESSION_ACCUSE")
	private String proffession;
	
	@Column(name = "NOMBER_ENFANT_ACC")
	private Integer nombreEnfant;
	
	@Column(length = 20, name = "SITUATION_FAMILIALLE")
	private String situationFamilialle;
	
	@Column(length = 20, name = "CNI_OFFICIER_CIVIL")
	private String cniOfficierCivil;
	
	@Column(length = 80, name = "CIN_AVOCAT")
	private String cinAvocat;
	
	@Column(name = "Assurance")
	private Long idAssurance;
	
	@ManyToOne
	@JoinColumn(name = "CIN_AVOCAT",referencedColumnName="CIN_AVOCAT", insertable=false, updatable=false)
	private Avocat avocat;
	
	@ManyToOne
	@JoinColumn(name = "CNI_OFFICIER_CIVIL",referencedColumnName="CNI_OFFICIER_CIVIL", insertable=false, updatable=false)
	private OfficierCivil officierCivil;
	
	@ManyToOne
	@JoinColumn(name = "Assurance",referencedColumnName="ID_Assurance", insertable=false, updatable=false)
	private Assurance assurance;
	
	
	public Long getId() {
		return idAccuse;
	}
	public void setId(Long idAccuse) {
		this.idAccuse = idAccuse;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
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
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getPrenomPere() {
		return prenomPere;
	}
	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}
	public String getPrenomMere() {
		return prenomMere;
	}
	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getProffession() {
		return proffession;
	}
	public void setProffession(String proffession) {
		this.proffession = proffession;
	}
	public Integer getNombreEnfant() {
		return nombreEnfant;
	}
	public void setNombreEnfant(Integer nombreEnfant) {
		this.nombreEnfant = nombreEnfant;
	}
	public String getSituationFamilialle() {
		return situationFamilialle;
	}
	public void setSituationFamilialle(String situationFamilialle) {
		this.situationFamilialle = situationFamilialle;
	}
	public String getCniOfficierCivil() {
		return cniOfficierCivil;
	}
	public void setCniOfficierCivil(String cniOfficierCivil) {
		this.cniOfficierCivil = cniOfficierCivil;
	}
	public String getCinAvocat() {
		return cinAvocat;
	}
	public void setCinAvocat(String cinAvocat) {
		this.cinAvocat = cinAvocat;
	}
	public Long getAssurance() {
		return idAssurance;
	}
	public void setAssurance(Long assurance) {
		this.idAssurance = assurance;
	}
	
	
	
}
