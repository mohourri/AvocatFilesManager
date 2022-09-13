package org.baeldung.persistence.model.pfe;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_ta3wid")

public class TableT3wid {
	@Id
    @Column(unique = true, nullable = false, name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTableTa3wid;
	
	@Column(name = "SALAIRE")
	private Double salaire;
	
	@Column(name = "AGE")
	private Double age;
	
	@Column(name = "RASS_LMAL")
	private Double rassMal;
	
	@Column(length = 60, name = "proffession")
	private String proffession;
	
	@Column(name = "DATE_NAISSANCE_VICTIME")
	private Date dateNaissanceVictime;
	
	@Column(length = 30, nullable = false, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@Column(name = "Nisba")
	private Integer nisba;
	
	@Column(name = "nisbatMasoulMoutah")
	private Double nisbatMasoulMoutah;
	
	@Column(name = "nbYa3olohm")
	private Integer nbYa3olohm;
	
	@Column(length = 10, name = "tachterMa3nawi")
	private String tachterMa3nawi;
	
	
	public Long getId() {
		return idTableTa3wid;
	}
	public void setId(Long idTableTa3wid) {
		this.idTableTa3wid = idTableTa3wid;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public Double getRassMal() {
		return rassMal;
	}
	public void setRassMal(Double rassMal) {
		this.rassMal = rassMal;
	}
	public String getProffession() {
		return proffession;
	}
	public void setProffession(String proffession) {
		this.proffession = proffession;
	}
	public Date getDateNaissanceVictime() {
		return dateNaissanceVictime;
	}
	public void setDateNaissanceVictime(Date dateNaissanceVictime) {
		this.dateNaissanceVictime = dateNaissanceVictime;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public Integer getNisba() {
		return nisba;
	}
	public void setNisba(Integer nisba) {
		this.nisba = nisba;
	}
	public Double getNisbatMasoulMoutah() {
		return nisbatMasoulMoutah;
	}
	public void setNisbatMasoulMoutah(Double nisbatMasoulMoutah) {
		this.nisbatMasoulMoutah = nisbatMasoulMoutah;
	}
	public Integer getNbYa3olohm() {
		return nbYa3olohm;
	}
	public void setNbYa3olohm(Integer nbYa3olohm) {
		this.nbYa3olohm = nbYa3olohm;
	}
	public String getTachterMa3nawi() {
		return tachterMa3nawi;
	}
	public void setTachterMa3nawi(String tachterMa3nawi) {
		this.tachterMa3nawi = tachterMa3nawi;
	}
	
	
}
