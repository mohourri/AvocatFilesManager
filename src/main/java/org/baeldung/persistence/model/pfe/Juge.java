package org.baeldung.persistence.model.pfe;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "juge")
public class Juge {
	@Id
	@Column(unique = true, nullable = false, length = 20, name = "MATRICULE_JUGE")
	private String matriculeJuge;
	
	@Column(length = 70, name = "PRENOM_JUGE")
	private String prenom;
	
	@Column(length = 70, name = "NOM_JUGE")
	private String nom;
	
	@Column(name = "TRIBUNAL")
	private Long idTribunal;
	
	@Column(length = 20, name = "TYPE_TRIBUNAL")
	private Long typeTribunal;
	
	@Column(length = 20, name = "SEXE")
	private String sexe;
	
	@Column(length = 300, name = "Adresse")
	private String addresse;
	
	@Column(length = 20, name = "Tel")
	private String tel;
	
	@OneToMany(mappedBy = "juge", fetch = FetchType.LAZY)
	private Collection<Dossier> dossiers;
	
	public String getMatriculeJuge() {
		return matriculeJuge;
	}
	public void setMatriculeJuge(String matriculeJuge) {
		this.matriculeJuge = matriculeJuge;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getAddresse() {
		return addresse;
	}
	public Long getIdTribunal() {
		return idTribunal;
	}
	public void setIdTribunal(Long idTribunal) {
		this.idTribunal = idTribunal;
	}
	public Long getTypeTribunal() {
		return typeTribunal;
	}
	public void setTypeTribunal(Long typeTribunal) {
		this.typeTribunal = typeTribunal;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
		
}
