package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dossieraccuse")
@IdClass(DossierAccuseId.class)
public class DossierAccuse {
	@Id
	@Column(nullable = false, name = "ID_ACC")
	private Long idAccuse;
	
	@Id
	@Column(nullable = false, length = 20, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@Column(nullable = false, name = "ID_TOHMA")
	private Long idTohma;
	
	public DossierAccuse() {
		super();
	}
	public DossierAccuse(Long idAccuse, String numeroDossier, Long idTohma) {
		super();
		this.idAccuse = idAccuse;
		this.numeroDossier = numeroDossier;
		this.idTohma = idTohma;
	}
	@ManyToOne
	@JoinColumn(name = "NUMERO_DOSSIER",referencedColumnName="NUMERO_DOSSIER", insertable=false, updatable=false)
	private Dossier dossier;
	
	@ManyToOne
	@JoinColumn(name = "ID_TOHMA",referencedColumnName="ID_TOHMA", insertable=false, updatable=false)
	private Tohma tohma;
	
	public Long getIdAccuse() {
		return idAccuse;
	}
	public void setIdAccuse(Long idAccuse) {
		this.idAccuse = idAccuse;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public Long getIdTohma() {
		return idTohma;
	}
	public void setIdTohma(Long idTohma) {
		this.idTohma = idTohma;
	}
	
}
