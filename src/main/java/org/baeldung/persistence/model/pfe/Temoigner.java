package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(TemoignerId.class)

public class Temoigner {
	@Id @Column(length = 20, nullable = false, name = "CIN_TEMOIN")
	private String cinTemoin;
	
	@Id @Column(length = 20, nullable = false, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@ManyToOne
	@JoinColumn(name = "NUMERO_DOSSIER",referencedColumnName="NUMERO_DOSSIER", insertable=false, updatable=false)
	private Dossier dossier;
	
	public String getCin() {
		return cinTemoin;
	}
	public Temoigner() {
		super();
	}
	public Temoigner(String cinTemoin, String numeroDossier) {
		super();
		this.cinTemoin = cinTemoin;
		this.numeroDossier = numeroDossier;
	}
	public void setCin(String cinTemoin) {
		this.cinTemoin = cinTemoin;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	
}
