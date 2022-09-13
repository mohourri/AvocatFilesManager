package org.baeldung.persistence.model.pfe;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "barreau")
public class Barreau {
	
	@Id
	@Column(unique = true, nullable = false, name = "ID_BARREAU")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBarreau;
	
	@Column(length = 40, name = "NOM_BARREAU")
	private String nomBarreau;
	
	@OneToMany(mappedBy = "barreau", fetch = FetchType.LAZY)
	private Collection<Avocat> avocats;

	public Long getIdBarreau() {
		return idBarreau;
	}

	public void setIdBarreau(Long idBarreau) {
		this.idBarreau = idBarreau;
	}

	public String getNomBarreau() {
		return nomBarreau;
	}

	public void setNomBarreau(String nomBarreau) {
		this.nomBarreau = nomBarreau;
	}

	public Barreau(Long idBarreau, String nomBarreau) {
		super();
		this.idBarreau = idBarreau;
		this.nomBarreau = nomBarreau;
	}

	public Barreau() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
