package org.baeldung.persistence.model.pfe;

import java.io.Serializable;

import javax.persistence.Column;

public class UserDossierId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numeroDossier;
	private Long idUser;
	
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public UserDossierId(String numeroDossier, Long idUser) {
		super();
		this.numeroDossier = numeroDossier;
		this.idUser = idUser;
	}
	public UserDossierId() {
		super();
	}
	
	
	
	
	
}
