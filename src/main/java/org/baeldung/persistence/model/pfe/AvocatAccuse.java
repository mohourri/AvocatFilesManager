package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "avocat_accuse")
@IdClass(AvocatAccuseId.class)
public class AvocatAccuse {
	@Id
	@Column(nullable = false, length = 80, name = "CIN_AVOCAT")
	private String cinAvocat;
	
	@Id
	@Column(nullable = false, name = "ID_ACCUSE")
	private Long idAccuse;

	
	public String getCinAvocat() {
		return cinAvocat;
	}

	public void setCinAvocat(String cinAvocat) {
		this.cinAvocat = cinAvocat;
	}

	public Long getIdAccuse() {
		return idAccuse;
	}

	public void setIdAccuse(Long idAccuse) {
		this.idAccuse = idAccuse;
	}

	public AvocatAccuse(String cinAvocat, Long idAccuse) {
		super();
		this.cinAvocat = cinAvocat;
		this.idAccuse = idAccuse;
	}

	public AvocatAccuse() {
		super();
	}
	
	
}
