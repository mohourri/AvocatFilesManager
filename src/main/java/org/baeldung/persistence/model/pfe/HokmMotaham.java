package org.baeldung.persistence.model.pfe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hokm_motaham")
public class HokmMotaham {
	@Id
    @Column(unique = true, nullable = false, name = "idHokmMotaham")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idHokmMotaham;
	
	@Column(length = 20, nullable = false, name = "Numer_Dossier")
	private String numeroDossier;
	
	@Column(nullable = false, name = "ID_ACC")
	private Long idAccuse;
	
	@Column(length = 200, nullable = false, name = "ID_TOHMA")
	private String idTohma;
	
	@Column(length = 50, name = "Modat_Alhabs")
	private String modatAlhabs;
	
	@Column(length = 100, name = "MablaGH_Algharamm")
	private String mablaghAlgharama;
	
	@Column(length = 50, name = "Roghssa")
	private String roghssa;
	
	@Column(length = 50, name = "Modat_Taw9if")
	private String modatTawqif;
	
	@Column(length = 120, name = "Tarigh_taw9if")
	private String tarikhTawqif;
	
	@Column(length = 100, name = "Ijtiyaz_roghssa")
	private String ijtiyazRoghssa;
	
	@Column(length = 50, name = "Modat_man3_Ijtiyaz")
	private String modatMan3Ijtiyaz;
	
	@Column(length = 80, name = "Takwin")
	private String takwin;
	
	@Column(length = 50, name = "Nachr_hokm")
	private String nachrHokm;
	
	@Column(length = 60, name = "Saair")
	private String saair;
	
	@Column(length = 100, name = "molaghass")
	private String molakhass;
	
	
	
	public Long getIdHokmMotaham() {
		return idHokmMotaham;
	}
	public void setIdHokmMotaham(Long idHokmMotaham) {
		this.idHokmMotaham = idHokmMotaham;
	}
	public void setIdAccuse(Long idAccuse) {
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
	
	public String getIdTohma() {
		return idTohma;
	}
	public void setIdTohma(String idTohma) {
		this.idTohma = idTohma;
	}
	public String getModatAlhabs() {
		return modatAlhabs;
	}
	public void setModatAlhabs(String modatAlhabs) {
		this.modatAlhabs = modatAlhabs;
	}
	public String getMablaghAlgharama() {
		return mablaghAlgharama;
	}
	public void setMablaghAlgharama(String mablaghAlgharama) {
		this.mablaghAlgharama = mablaghAlgharama;
	}
	public String getRoghssa() {
		return roghssa;
	}
	public void setRoghssa(String roghssa) {
		this.roghssa = roghssa;
	}
	public String getModatTawqif() {
		return modatTawqif;
	}
	public void setModatTawqif(String modatTawqif) {
		this.modatTawqif = modatTawqif;
	}
	public String getTarikhTawqif() {
		return tarikhTawqif;
	}
	public void setTarikhTawqif(String tarikhTawqif) {
		this.tarikhTawqif = tarikhTawqif;
	}
	public String getIjtiyazRoghssa() {
		return ijtiyazRoghssa;
	}
	public void setIjtiyazRoghssa(String ijtiyazRoghssa) {
		this.ijtiyazRoghssa = ijtiyazRoghssa;
	}
	public String getModatMan3Ijtiyaz() {
		return modatMan3Ijtiyaz;
	}
	public void setModatMan3Ijtiyaz(String modatMan3Ijtiyaz) {
		this.modatMan3Ijtiyaz = modatMan3Ijtiyaz;
	}
	public String getTakwin() {
		return takwin;
	}
	public void setTakwin(String takwin) {
		this.takwin = takwin;
	}
	public String getNachrHokm() {
		return nachrHokm;
	}
	public void setNachrHokm(String nachrHokm) {
		this.nachrHokm = nachrHokm;
	}
	public String getSaair() {
		return saair;
	}
	public void setSaair(String saair) {
		this.saair = saair;
	}
	public String getMolakhass() {
		return molakhass;
	}
	public void setMolakhass(String molakhass) {
		this.molakhass = molakhass;
	}
	
	
}
