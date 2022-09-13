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
@Table(name = "rapport")
public class Rapport {
	@Id
	@Column(unique = true, nullable = false, name = "ID_RAPPORT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRapport;
	
	@Column(nullable = false, name = "ID_VIC")
	private Long idVictime;
	
	@Column(name = "NB_JOUR_PERDE")
	private Double nombreJourPerde;
	
	@Column(name = "POURCENTAGE_DEFICIT")
	private Double pourcentageDeficit;
	
	@Column(name = "POURCENTAGE_TCHWIH")
	private Double pourcentageTachwih;
	
	@Column(length = 300, name = "TACHWIH")
	private String tachwih;
	
	@Column(name = "POURCENTAGE_ALAM_JISMANI")
	private Double poucentageAlamJismani;
	
	@Column(length = 300, name = "ALAM_JISMANI")
	private String alamJismany;
	
	@Column(name = "COMPENSATION_MEDICAL")
	private Double compensationMedical;
	
	@Column(name = "SALAIRE_ANUELLE")
	private Double salaireAnuelle;
	
	@Column(name = "AGE_VIC")
	private Double ageVictime;
	
	@Column(name = "DATE_NAISS")
	private Date dateNaissance;
	
	@Column(length = 300, name = "PROFFESSION")
	private String proffession;
	
	@Column(name = "RASMAL")
	private Double rasmal;
	
	@Column(length = 200, name = "ATAR_SAYIA")
	private String atarSayia;
	
	@Column(name = "POURCENTAGE_ACCUSE")
	private Double pourcentageAccuse;
	
	@Column(name = "RESULTAT_AVANT_ACCUSE")
	private Double resultatAvantAccuse;
	
	@Column(name = "RESULTA_FINAL")
	private Double resultatFinal;
	
	@Column(length = 300, name = "NA9S_MIHANI")
	private String na9sMihani;
	
	@Column(name = "POURCENTAGE_NA9S")
	private Double pourcentageNa9s;
	
	@Column(nullable = false, length = 10, name = "3ajzMoa9at")
	private String ajzMoa9at;
	
	@Column(nullable = false, length = 10, name = "3ajzDaaim")
	private String ajzDaaim;
	
	@Column(nullable = false, name = "RaslmaAdna")
	private Double rasmalAdna;
	
	@Column(name = "Isti3anaBichghss")
	private Double isti3anaBichaghss;
	
	@Column(nullable = false, length = 30, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@Column(name = "POURCENTAGE_In9ita3")
	private Double pourcentageIn9ita3;
	
	@Column(length = 60, name = "In9ita3")
	private String in9ita3;
	
	@ManyToOne
	@JoinColumn(name = "ID_VIC",referencedColumnName="ID_VIC", insertable=false, updatable=false)
	private Victime victime;
	
	
	
	public Long getId() {
		return idRapport;
	}
	public void setId(Long idRapport) {
		this.idRapport = idRapport;
	}
	public Long getIdVictime() {
		return idVictime;
	}
	public void setIdVictime(Long idVictime) {
		this.idVictime = idVictime;
	}
	public Double getNombreJourPerde() {
		return nombreJourPerde;
	}
	public void setNombreJourPerde(Double nombreJourPerde) {
		this.nombreJourPerde = nombreJourPerde;
	}
	public Double getPourcentageDeficit() {
		return pourcentageDeficit;
	}
	public void setPourcentageDeficit(Double pourcentageDeficit) {
		this.pourcentageDeficit = pourcentageDeficit;
	}
	public Double getPourcentageTachwih() {
		return pourcentageTachwih;
	}
	public void setPourcentageTachwih(Double pourcentageTachwih) {
		this.pourcentageTachwih = pourcentageTachwih;
	}
	public String getTachwih() {
		return tachwih;
	}
	public void setTachwih(String tachwih) {
		this.tachwih = tachwih;
	}
	public Double getPoucentageAlamJismani() {
		return poucentageAlamJismani;
	}
	public void setPoucentageAlamJismani(Double poucentageAlamJismani) {
		this.poucentageAlamJismani = poucentageAlamJismani;
	}
	public String getAlamJismany() {
		return alamJismany;
	}
	public void setAlamJismany(String alamJismany) {
		this.alamJismany = alamJismany;
	}
	public Double getCompensationMedical() {
		return compensationMedical;
	}
	public void setCompensationMedical(Double compensationMedical) {
		this.compensationMedical = compensationMedical;
	}
	public Double getSalaireAnuelle() {
		return salaireAnuelle;
	}
	public void setSalaireAnuelle(Double salaireAnuelle) {
		this.salaireAnuelle = salaireAnuelle;
	}
	public Double getAgeVictime() {
		return ageVictime;
	}
	public void setAgeVictime(Double ageVictime) {
		this.ageVictime = ageVictime;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getProffession() {
		return proffession;
	}
	public void setProffession(String proffession) {
		this.proffession = proffession;
	}
	public Double getRasmal() {
		return rasmal;
	}
	public void setRasmal(Double rasmal) {
		this.rasmal = rasmal;
	}
	public String getAtarSayia() {
		return atarSayia;
	}
	public void setAtarSayia(String atarSayia) {
		this.atarSayia = atarSayia;
	}
	public Double getPourcentageAccuse() {
		return pourcentageAccuse;
	}
	public void setPourcentageAccuse(Double pourcentageAccuse) {
		this.pourcentageAccuse = pourcentageAccuse;
	}
	public Double getResultatAvantAccuse() {
		return resultatAvantAccuse;
	}
	public void setResultatAvantAccuse(Double resultatAvantAccuse) {
		this.resultatAvantAccuse = resultatAvantAccuse;
	}
	public Double getResultatFinal() {
		return resultatFinal;
	}
	public void setResultatFinal(Double resultatFinal) {
		this.resultatFinal = resultatFinal;
	}
	public String getNa9sMihani() {
		return na9sMihani;
	}
	public void setNa9sMihani(String na9sMihani) {
		this.na9sMihani = na9sMihani;
	}
	public Double getPourcentageNa9s() {
		return pourcentageNa9s;
	}
	public void setPourcentageNa9s(Double pourcentageNa9s) {
		this.pourcentageNa9s = pourcentageNa9s;
	}
	public String getAjzMoa9at() {
		return ajzMoa9at;
	}
	public void setAjzMoa9at(String ajzMoa9at) {
		this.ajzMoa9at = ajzMoa9at;
	}
	public String getAjzDaaim() {
		return ajzDaaim;
	}
	public void setAjzDaaim(String ajzDaaim) {
		this.ajzDaaim = ajzDaaim;
	}
	public Double getRasmalAdna() {
		return rasmalAdna;
	}
	public void setRasmalAdna(Double rasmalAdna) {
		this.rasmalAdna = rasmalAdna;
	}
	public Double getIsti3anaBichaghss() {
		return isti3anaBichaghss;
	}
	public void setIsti3anaBichaghss(Double isti3anaBichaghss) {
		this.isti3anaBichaghss = isti3anaBichaghss;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public Double getPourcentageIn9ita3() {
		return pourcentageIn9ita3;
	}
	public void setPourcentageIn9ita3(Double pourcentageIn9ita3) {
		this.pourcentageIn9ita3 = pourcentageIn9ita3;
	}
	public String getIn9ita3() {
		return in9ita3;
	}
	public void setIn9ita3(String in9ita3) {
		this.in9ita3 = in9ita3;
	}
	
	
	
}
