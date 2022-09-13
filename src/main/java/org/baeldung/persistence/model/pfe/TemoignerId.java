package org.baeldung.persistence.model.pfe;

import java.io.Serializable;
import java.util.Objects;

public class TemoignerId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroDossier;
	private String cinTemoin;
	
	public TemoignerId() {
		super();
	}

	public TemoignerId(String numeroDossier, String cinTemoin) {
		super();
		this.numeroDossier = numeroDossier;
		this.cinTemoin = cinTemoin;
	}
	
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public String getCinTemoin() {
		return cinTemoin;
	}
	public void setCinTemoin(String cinTemoin) {
		this.cinTemoin = cinTemoin;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemoignerId temoignerId = (TemoignerId) o;
        return numeroDossier.equals(temoignerId.numeroDossier) &&
        		cinTemoin.equals(temoignerId.cinTemoin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDossier, cinTemoin);
    }
	

}
