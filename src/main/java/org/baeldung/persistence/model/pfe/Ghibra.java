package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ghibra")
public class Ghibra {
	@Id
	@Column(unique = true, columnDefinition = "bigint default 0", nullable = false, name = "ID_VIC")
	private Long idVictime;
	
	@Column(unique = true, nullable = false, length = 20, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@Column(name = "NB_JOUR_PERDE")
	private Integer nombreJourPerde;
	
	@Column(name = "POURCENTAGE_DEFICIT")
	private Double pourcentageDeficit;
	
	@Column(length = 200, name = "ATAR_SAYIA")
	private String atarSayia;
	
	@Column(length = 250, name = "NA9S_MIHANI")
	private String na9sMihani;
	
	@Column(nullable = false, name = "Isti3anaBichghss")
	private Double isti3anaBichaghass;
	
	@Column(nullable = false, length = 60, name = "In9ita3")
	private String in9ita3;
	
	@Column(length = 200, name = "TACHWIH")
	private String tachwih;
	
	@Column(length = 100, name = "ALAM_JISMANI")
	private String alamJismani;
	
	@Column(name = "COMPENSATION_MEDICAL")
	private Double compensationMedical;
	
	@Column(name = "POURCENTAGE_ACCUSE")
	private Double pourcentageAccuse;
	
	
	public Long getIdVictime() {
		return idVictime;
	}
	public void setIdVictime(Long idVictime) {
		this.idVictime = idVictime;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public Integer getNombreJourPerde() {
		return nombreJourPerde;
	}
	public void setNombreJourPerde(Integer nombreJourPerde) {
		this.nombreJourPerde = nombreJourPerde;
	}
	public Double getPourcentageDeficit() {
		return pourcentageDeficit;
	}
	public void setPourcentageDeficit(Double pourcentageDeficit) {
		this.pourcentageDeficit = pourcentageDeficit;
	}
	public String getAtarSayia() {
		return atarSayia;
	}
	public void setAtarSayia(String atarSayia) {
		this.atarSayia = atarSayia;
	}
	public String getNa9sMihani() {
		return na9sMihani;
	}
	public void setNa9sMihani(String na9sMihani) {
		this.na9sMihani = na9sMihani;
	}
	public Double getIsti3anaBichaghass() {
		return isti3anaBichaghass;
	}
	public void setIsti3anaBichaghass(Double isti3anaBichaghass) {
		this.isti3anaBichaghass = isti3anaBichaghass;
	}
	public String getIn9ita3() {
		return in9ita3;
	}
	public void setIn9ita3(String in9ita3) {
		this.in9ita3 = in9ita3;
	}
	public String getTachwih() {
		return tachwih;
	}
	public void setTachwih(String tachwih) {
		this.tachwih = tachwih;
	}
	public String getAlamJismani() {
		return alamJismani;
	}
	public void setAlamJismani(String alamJismani) {
		this.alamJismani = alamJismani;
	}
	public Double getCompensationMedical() {
		return compensationMedical;
	}
	public void setCompensationMedical(Double compensationMedical) {
		this.compensationMedical = compensationMedical;
	}
	public Double getPourcentageAccuse() {
		return pourcentageAccuse;
	}
	public void setPourcentageAccuse(Double pourcentageAccuse) {
		this.pourcentageAccuse = pourcentageAccuse;
	}
	
	
}
