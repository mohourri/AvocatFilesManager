package org.baeldung.web.dto;

import java.util.Date;


public class VictimDawi {





	private Long idVictime;

	private Long idDawi;
	
	private String cin;
	
	
	private String nom;
	
	
	private String prenom;
	
	
	private String addresse;
	
	private String situationFamilialle;
	
	private String dateNaissance;
	
	private Double ta3widDawi;
	
	private Double ta3widMa3nawi;
	
	private String proffession;
	
	private Integer nisbMadi;
	
	private String relation;
	
	private String ta3wid;



	public VictimDawi(Long idVictime, Long idDawi, String cin, String nom, String prenom, String addresse,
			String situationFamilialle, String dateNaissance, Double ta3widDawi, Double ta3widMa3nawi, String proffession,
			Integer nisbMadi, String relation, String ta3wid) {
		super();
		this.idVictime = idVictime;
		this.idDawi = idDawi;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.situationFamilialle = situationFamilialle;
		this.dateNaissance = dateNaissance;
		this.ta3widDawi = ta3widDawi;
		this.ta3widMa3nawi = ta3widMa3nawi;
		this.proffession = proffession;
		this.nisbMadi = nisbMadi;
		this.relation = relation;
		this.ta3wid = ta3wid;
	}
	

	public Long getIdVictime() {
		return idVictime;
	}


	public void setIdVictime(Long idVictime) {
		this.idVictime = idVictime;
	}
	public String getTa3wid() {
		return ta3wid;
	}

	public void setTa3wid(String ta3wid) {
		this.ta3wid = ta3wid;
	}

	
	public Long getIdDawi() {
		return idDawi;
	}

	public void setIdDawi(Long idDawi) {
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Double getTa3widDawi() {
		return ta3widDawi;
	}

	public void setTa3widDawi(Double ta3widDawi) {
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}



	@Override
	public String toString() {
		return "VictimDawi [idVictime=" + idVictime + ", idDawi=" + idDawi + ", cin=" + cin + ", nom=" + nom
				+ ", prenom=" + prenom + ", addresse=" + addresse + ", situationFamilialle=" + situationFamilialle
				+ ", dateNaissance=" + dateNaissance + ", ta3widDawi=" + ta3widDawi + ", ta3widMa3nawi=" + ta3widMa3nawi
				+ ", proffession=" + proffession + ", nisbMadi=" + nisbMadi + ", relation=" + relation + ", ta3wid="
				+ ta3wid + "]";
	}
	
}
