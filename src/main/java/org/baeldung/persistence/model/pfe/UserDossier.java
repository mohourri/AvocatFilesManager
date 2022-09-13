package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "user_dossier")
@IdClass(UserDossierId.class)
public class UserDossier {
	
	@Id
	@Column(nullable = false, length = 20, name = "NUMERO_DOSSIER")
	private String numeroDossier;
	
	@Id
	@Column(nullable = false, name = "ID_USER")
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

	public UserDossier(String numeroDossier, Long idUser) {
		super();
		this.numeroDossier = numeroDossier;
		this.idUser = idUser;
	}

	public UserDossier() {
		super();
	}
	
}
