package org.baeldung.web.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.baeldung.persistence.model.pfe.Avocat;
import org.baeldung.persistence.model.pfe.Rapport;

public class VictimeDto {
	@Id
    @Column(unique = true, nullable = false, name = "ID_VIC")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVictime;
	
	@Column(length = 20, name = "CIN_VICTIME")
	private String cin;
	
	@Column(length = 20, name = "PRENOM_VICTIME")
	private String prenom;
	
	@Column(length = 20, name = "NOM_VICTIME")
	private String nom;
	
	@Column(length = 20, name = "PRENOM_PERE_VICTIME")
	private String prenomPere;
	
	@Column(length = 20, name = "PRENOM_MERE_VICTIME")
	private String prenomMere;
	
	@Column(length = 10, name = "SEXE_VICTIME")
	private String sexe;
	
	@Column(name = "DATE_NAISSANCE_VICTIME")
	private Date dateNaissance;
	
	@Column(length = 100, name = "LIEU_NAISSANCE_VICTIME")
	private String lieuNaissance;
	
	@Column(length = 20, name = "SITUATION_FAMILIALE")
	private String situationFamiliale;
	
	@Column(name = "NOMBRE_ENFANT_VIC")
	private Integer nombreEnfant;
	
	@Column(length = 20, name = "PROFFESION_VICTTIME")
	private String proffession;
	
	@Column(length = 20, name = "ETAT_VICTIME")
	private String etat;
	
	@Column(length = 70, name = "ADRESSE_VICTIME")
	private String addresse;
	
	@Column(length = 80, name = "CIN_AVOCAT")
	private String cinAvocat;
	
	@Column(name = "SALAIRE_DA7IYA")
	private Double salaire;
	
	@Column(name = "COMPONSATION_VIC")
	private Double componsation;

	@Column(name = "MONTANT_DEMANDE_AVC")
	private Double montantDemande;
	
	
	
	@OneToMany(mappedBy = "victime", fetch = FetchType.LAZY)
	private Collection<Rapport> rapports;
	
	@ManyToOne()
	@JoinColumn(name = "CIN_AVOCAT",referencedColumnName="CIN_AVOCAT", insertable=false, updatable=false)
	private Avocat avocat;
	
	
	
	public Long getId() {
		return idVictime;
	}
	public void setId(Long idVictime) {
		this.idVictime = idVictime;
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
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
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
	public String getSituationFamiliale() {
		return situationFamiliale;
	}
	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}
	public Integer getNombreEnfant() {
		return nombreEnfant;
	}
	public void setNombreEnfant(Integer nombreEnfant) {
		this.nombreEnfant = nombreEnfant;
	}
	public String getProffession() {
		return proffession;
	}
	public void setProffession(String proffession) {
		this.proffession = proffession;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getCinAvocat() {
		return cinAvocat;
	}
	public void setCinAvocat(String cinAvocat) {
		this.cinAvocat = cinAvocat;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public Double getComponsation() {
		return componsation;
	}
	public void setComponsation(Double componsation) {
		this.componsation = componsation;
	}

	public Double getMontantDemande() {
		return montantDemande;
	}
	public void setMontantDemande(Double md) {
		this.montantDemande = md;
	}
	
}
