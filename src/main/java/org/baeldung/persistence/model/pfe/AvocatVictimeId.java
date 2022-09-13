package org.baeldung.persistence.model.pfe;

import java.io.Serializable;

import javax.persistence.Column;

public class AvocatVictimeId implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 80, name = "CIN_AVOCAT")
	private String cinAvocat;
	
	@Column(nullable = false, name = "ID_VICTIME")
	private Long idVictime;
	
	public String getCinAvocat() {
		return cinAvocat;
	}
	public void setCinAvocat(String cinAvocat) {
		this.cinAvocat = cinAvocat;
	}
	public Long getIdVictime() {
		return idVictime;
	}
	public void setIdVictime(Long idVictime) {
		this.idVictime = idVictime;
	}
	public AvocatVictimeId(String cinAvocat, Long idVictime) {
		super();
		this.cinAvocat = cinAvocat;
		this.idVictime = idVictime;
	}
	public AvocatVictimeId() {
		super();
	}
	
	
}
