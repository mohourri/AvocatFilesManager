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
@Table(name = "tohma")
public class Tohma {
	@Id
    @Column(unique = true, nullable = false, name = "ID_Tohma")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTohma;
	
	@Column(length = 200, name = "Nom_tohma")
	private String nomTohma;
	
	
	@OneToMany(mappedBy = "tohma", fetch = FetchType.LAZY)
	private Collection<DossierAccuse> dossierAccuses;
	
	public Long getIdTohma() {
		return idTohma;
	}
	public void setIdTohma(Long idTohma) {
		this.idTohma = idTohma;
	}
	public String getNomTohma() {
		return nomTohma;
	}
	public void setNomTohma(String nomTohma) {
		this.nomTohma = nomTohma;
	}
	
}
