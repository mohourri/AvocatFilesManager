package org.baeldung.persistence.model.pfe;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dossier")
public class Dossier {
	@Id
	@Column(unique = true, nullable = false, length = 20, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@Column(unique = true, length = 20, name = "NUMERO_NATIONAL")
	private String numeroNational;
	
	@Column(nullable = true, length = 20, name = "MATRICULE_JUGE")
	private String matriculeJuge;
	
	@Column(name = "DATE_DOSSIER")
	private Date dateDossier;
	
	@Column(name = "DATE_SEANCE")
	private Date dateSeance;
	
	@Column(length = 500, name = "COMMENTAIRE")
	private String commentaire;
	
	@Column(length = 40, name = "TRIBUNAL")
	private String tribunal;
	
	@Column(name = "Date_Dossier1")
	private Date dateDossier1;
	
	@ManyToOne
	@JoinColumn(name = "MATRICULE_JUGE",referencedColumnName="MATRICULE_JUGE", insertable=false, updatable=false)
	private Juge juge;
	
	@OneToMany(mappedBy = "dossier", fetch = FetchType.LAZY)
	private Collection<DossierVictime> dossierVictimes;
	
	@OneToMany(mappedBy = "dossier", fetch = FetchType.LAZY)
	private Collection<DossierAccuse> dossierAccuses;
	
	@OneToMany(mappedBy = "dossier", fetch = FetchType.LAZY)
	private Collection<Temoigner> temoigners;
	
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public String getMatriculeJuge() {
		return matriculeJuge;
	}
	public void setMatriculeJuge(String matriculeJuge) {
		this.matriculeJuge = matriculeJuge;
	}
	public Date getDateDossier() {
		return dateDossier;
	}
	public void setDateDossier(Date dateDossier) {
		this.dateDossier = dateDossier;
	}
	public Date getDateSeance() {
		return dateSeance;
	}
	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getTribunal() {
		return tribunal;
	}
	public void setTribunal(String tribunal) {
		this.tribunal = tribunal;
	}
	public Date getDateDossier1() {
		return dateDossier1;
	}
	public void setDateDossier1(Date dateDossier1) {
		this.dateDossier1 = dateDossier1;
	}
	
	public String getNumeroNational() {
		return numeroNational;
	}
	public void setNumeroNational(String numeroNational) {
		this.numeroNational = numeroNational;
	}
	
}
