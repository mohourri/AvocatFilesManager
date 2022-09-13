package org.baeldung.persistence.model.pfe;

import java.io.Serializable;
import java.util.Objects;

public class IndemniteId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idVictime;
	private Long idDawi;
	
	public Long getIdVictime() {
		return idVictime;
	}
	public void setIdVictime(Long idVictime) {
		this.idVictime = idVictime;
	}
	public Long getIdDawi() {
		return idDawi;
	}
	public void setIdDawi(Long idDawi) {
		this.idDawi = idDawi;
	}
	public IndemniteId(Long idVictime, Long idDawi) {
		super();
		this.idVictime = idVictime;
		this.idDawi = idDawi;
	}
	public IndemniteId() {
		super();
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndemniteId indemniteId = (IndemniteId) o;
        return idVictime.equals(indemniteId.idVictime) &&
        		idDawi.equals(indemniteId.idDawi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVictime, idDawi);
    }
}
