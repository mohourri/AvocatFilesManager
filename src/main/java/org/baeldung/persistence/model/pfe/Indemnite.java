package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "indemnite")
@IdClass(IndemniteId.class)
public class Indemnite {
	@Id @Column(nullable = false, name = "ID_VIC")
	private Long idVictime;
	
	@Id @Column(nullable = false, name = "ID_DAWI")
	private Long idDawi;
	
	@Column(length = 100, name = "COTE_FAMILLE")
	private String coteFamille;
	
	@Column(length = 30, nullable = false, name = "ha9ta3wid")
	private String ha9Ta3wid;
	
	@ManyToOne
	@JoinColumn(name = "ID_DAWI",referencedColumnName="ID_DAWI", insertable=false, updatable=false)
	private DroitsPersonneDecedee droitsPersonneDecedee;
	
	public Long getIdVictime() {
		return idVictime;
	}
	public void setIdVictime(Long idVictime) {
		this.idVictime = idVictime;
	}

	
	public Long getIdDawi() { return idDawi; } 
	  public Indemnite() {
		super();
	}
	public Indemnite(Long idVictime, Long idDawi, String coteFamille, String ha9Ta3wid) {
		super();
		this.idVictime = idVictime;
		this.idDawi = idDawi;
		this.coteFamille = coteFamille;
		this.ha9Ta3wid = ha9Ta3wid;
	}
	public void setIdDawi(Long idDawi)
	  { this.idDawi = idDawi; }
	 
	public String getCoteFamille() {
		return coteFamille;
	}
	public void setCoteFamille(String coteFamille) {
		this.coteFamille = coteFamille;
	}
	public String getHa9Ta3wid() {
		return ha9Ta3wid;
	}
	public void setHa9Ta3wid(String ha9Ta3wid) {
		this.ha9Ta3wid = ha9Ta3wid;
	}
	
	
}
