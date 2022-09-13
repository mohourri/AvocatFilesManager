package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "avocat_victime")
@IdClass(AvocatVictimeId.class)
public class AvocatVictime {
	@Id
	@Column(nullable = false, length = 80, name = "CIN_AVOCAT")
	private String cinAvocat;
	
	@Id
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

	public AvocatVictime(String cinAvocat, Long idVictime) {
		super();
		this.cinAvocat = cinAvocat;
		this.idVictime = idVictime;
	}

	public AvocatVictime() {
		super();
	}
	
	
}
