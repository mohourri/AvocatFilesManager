package org.baeldung.persistence.model.pfe;

import java.io.Serializable;

import javax.persistence.Column;

public class AvocatAccuseId implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 80, name = "CIN_AVOCAT")
	private String cinAvocat;
	
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
	public AvocatAccuseId(String cinAvocat, Long idAccuse) {
		super();
		this.cinAvocat = cinAvocat;
		this.idAccuse = idAccuse;
	}
	public AvocatAccuseId() {
		super();
	}
	
	
}
