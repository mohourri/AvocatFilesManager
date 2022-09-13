package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dossiervictime")
@IdClass(DossierVictimeId.class)

public class DossierVictime {
	@Id
	@Column(nullable = false, name = "ID_VIC")
	private Long idVictime;
	
	@Id
	@Column(nullable = false, length = 20, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@ManyToOne
	@JoinColumn(name = "NUMERO_DOSSIER",referencedColumnName="NUMERO_DOSSIER", insertable=false, updatable=false)
	private Dossier dossier;
	
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
	public DossierVictime(Long idVictime, String numeroDossier) {
		super();
		this.idVictime = idVictime;
		this.numeroDossier = numeroDossier;
	}
	public DossierVictime() {
		super();
	}
	
	
}
