package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ta3widdawi")


public class Ta3widDawi {
	@Id
    @Column(length = 30, nullable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTa3widDawi;
	
	@Column(nullable = false, name = "id_da7iya")
	private Long idDa7iya;
	
	@Column(length = 30, nullable = false, name = "Prenom")
	private String prenom;
	
	@Column(length = 30, nullable = false, name = "Nom")
	private String nom;
	
	@Column(length = 100, nullable = false, name = "Akarib")
	private String akarib;
	
	@Column(nullable = false, name = "Ta3wid")
	private Double ta3wid;
	
	@Column(length = 30, nullable = false, name = "Nom_Vic")
	private String nomVictime;
	
	@Column(length = 30, nullable = false, name = "Prenom_Vic")
	private String prenomVictime;
	
	@Column(nullable = false, name = "Ta3wid_Ma3nawi")
	private Double ta3widMa3nawi;
	
	@Column(nullable = false, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@Column(name = "nisbMadi")
	private Integer nisbMady;
	
	@Column(name = "nisbMaoul")
	private Double nisbMaoul;
	
	@Column(length = 10, name = "tachterMa3nawi")
	private String tachterMa3nawi;
	
	@Column(name = "nbYa3olohm")
	private Integer nbYa3olohm;
	
	
	
	public Long getId() {
		return idTa3widDawi;
	}
	public void setId(Long idTa3widDawi) {
		this.idTa3widDawi = idTa3widDawi;
	}
	public Long getIdDa7iya() {
		return idDa7iya;
	}
	public void setIdDa7iya(Long idDa7iya) {
		this.idDa7iya = idDa7iya;
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
	public String getAkarib() {
		return akarib;
	}
	public void setAkarib(String akarib) {
		this.akarib = akarib;
	}
	public Double getTa3wid() {
		return ta3wid;
	}
	public void setTa3wid(Double ta3wid) {
		this.ta3wid = ta3wid;
	}
	public String getNomVictime() {
		return nomVictime;
	}
	public void setNomVictime(String nomVictime) {
		this.nomVictime = nomVictime;
	}
	public String getPrenomVictime() {
		return prenomVictime;
	}
	public void setPrenomVictime(String prenomVictime) {
		this.prenomVictime = prenomVictime;
	}
	public Double getTa3widMa3nawi() {
		return ta3widMa3nawi;
	}
	public void setTa3widMa3nawi(Double ta3widMa3nawi) {
		this.ta3widMa3nawi = ta3widMa3nawi;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public Integer getNisbMady() {
		return nisbMady;
	}
	public void setNisbMady(Integer nisbMady) {
		this.nisbMady = nisbMady;
	}
	public Double getNisbMaoul() {
		return nisbMaoul;
	}
	public void setNisbMaoul(Double nisbMaoul) {
		this.nisbMaoul = nisbMaoul;
	}
	public String getTachterMa3nawi() {
		return tachterMa3nawi;
	}
	public void setTachterMa3nawi(String tachterMa3nawi) {
		this.tachterMa3nawi = tachterMa3nawi;
	}
	public Integer getNbYa3olohm() {
		return nbYa3olohm;
	}
	public void setNbYa3olohm(Integer nbYa3olohm) {
		this.nbYa3olohm = nbYa3olohm;
	}
	
}
