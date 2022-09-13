package org.baeldung.persistence.model.pfe;

import java.io.Serializable;
import java.util.Objects;

public class DossierAccuseId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroDossier;
	private Long idAccuse;
	
	public DossierAccuseId() {
		super();
	}

	public DossierAccuseId(String numeroDossier, Long idAccuse) {
		super();
		this.numeroDossier = numeroDossier;
		this.idAccuse = idAccuse;
	}
	
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public Long getIdAccuse() {
		return idAccuse;
	}
	public void setIdAccuse(Long idAccuse) {
		this.idAccuse = idAccuse;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DossierAccuseId dossierAccuseId = (DossierAccuseId) o;
        return numeroDossier.equals(dossierAccuseId.numeroDossier) &&
        		idAccuse.equals(dossierAccuseId.idAccuse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDossier, idAccuse);
    }
	

}
