package org.baeldung.persistence.model.pfe;

import java.io.Serializable;
import java.util.Objects;

public class DossierVictimeId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroDossier;
	private Long idVictime;
	
	public DossierVictimeId() {
		super();
	}

	public DossierVictimeId(String numeroDossier, Long idVictime) {
		super();
		this.numeroDossier = numeroDossier;
		this.idVictime = idVictime;
	}
	
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public Long getIdVictime() {
		return idVictime;
	}
	public void setIdVictime(Long idVictime) {
		this.idVictime = idVictime;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DossierVictimeId dossierVictimeId = (DossierVictimeId) o;
        return numeroDossier.equals(dossierVictimeId.numeroDossier) &&
        		idVictime.equals(dossierVictimeId.idVictime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDossier, idVictime);
    }
	

}
