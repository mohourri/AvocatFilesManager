package org.baeldung.persistence.model.pfe;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temoins")
public class Temoin {
	@Id
    @Column(unique = true, nullable = false, name = "CIN_TEMOIN")
	private String cinTemoin;
	
	@Column(length = 70, name = "PRENOM_TEMOIN")
	private String prenom;
	
	@Column(length = 70, name = "NOM_TEMOIN")
	private String nom;
	
	@Column(length = 70, name = "PRENOM_MERE_TEMOIN")
	private String prenomMere;
	
	@Column(length = 70, name = "PRENOM_PERE_TEMOIN")
	private String prenomPere;
	
	@Column(length = 20, name = "SITUATION_TEM")
	private String situation;
	
	@Column(length = 10, name = "SEXE_TEMOIN")
	private String sexe;
	
	@Column(length = 100, name = "ADRESSE_TEMOIN")
	private String addresse;
	
	@Column(name = "DATE_NAISSANCE_TEMOIN")
	private Date dateNaissance;
	
	@Column(length = 100, name = "LIEU_DE_NAISSANCE_TEMOIN")
	private String lieuNaissance;
	
	@Column(length = 20, name = "PREFFESSION_TEMOIN")
	private String proffession;
	
	
	public String getCinTemoin() {
		return cinTemoin;
	}
	public void setCinTemoin(String cinTemoin) {
		this.cinTemoin = cinTemoin;
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
	public String getPrenomMere() {
		return prenomMere;
	}
	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}
	public String getPrenomPere() {
		return prenomPere;
	}
	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
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
	
}
