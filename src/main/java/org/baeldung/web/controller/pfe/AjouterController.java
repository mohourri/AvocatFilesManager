package org.baeldung.web.controller.pfe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.baeldung.persistence.model.User;
import org.baeldung.persistence.model.pfe.Accuse;
import org.baeldung.persistence.model.pfe.Avocat;
import org.baeldung.persistence.model.pfe.AvocatAccuse;
import org.baeldung.persistence.model.pfe.AvocatVictime;
import org.baeldung.persistence.model.pfe.CourAppel;
import org.baeldung.persistence.model.pfe.Dossier;
import org.baeldung.persistence.model.pfe.DossierAccuse;
import org.baeldung.persistence.model.pfe.DossierVictime;
import org.baeldung.persistence.model.pfe.DroitsPersonneDecedee;
import org.baeldung.persistence.model.pfe.Indemnite;
import org.baeldung.persistence.model.pfe.OfficierCivil;
import org.baeldung.persistence.model.pfe.Temoigner;
import org.baeldung.persistence.model.pfe.Temoin;
import org.baeldung.persistence.model.pfe.UserDossier;
import org.baeldung.persistence.model.pfe.Victime;
import org.baeldung.service.pfe.AjouterService;
import org.baeldung.web.dto.VictimDawi;
import org.baeldung.web.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjouterController {
	
	@Autowired
	private AjouterService ajouterService;
	
	
	@GetMapping("Client/ajouterDossier")
	public String ajouterDossier(HttpServletRequest request, Model model) {
		
		model.addAttribute("courAppels",ajouterService.getAllCourAppels());
		model.addAttribute("assurances",ajouterService.listeAssurances());
		model.addAttribute("barreaux",ajouterService.listeBarreaux());
		model.addAttribute("charges",ajouterService.listeCharges());
		model.addAttribute("victimes", ajouterService.listeVictimes());
		model.addAttribute("dawis", ajouterService.listeDawis());
		model.addAttribute("avocats", ajouterService.listeAvocats());
		model.addAttribute("accuses", ajouterService.listeAccuses());
		model.addAttribute("officierCivils", ajouterService.listeOfficierCivils());
		model.addAttribute("temoins", ajouterService.listeTemoins());
		
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user1");
		if(user!=null) {
			model.addAttribute("user", user);
		}
		model.addAttribute("nombreSeancesAujourdhui",ajouterService.getDaySeances().size());
		return "Client/ajouterDossier";
	}
	
	@GetMapping("Client/ajouterDossier/CourAppel/{id}")
	@ResponseBody
	public CourAppel findInstance(@PathVariable("id") Long id) {
		return ajouterService.getCourAppelById(id);
	}
	
	@PostMapping("Client/ajouterDossier/listeJuges")
	@ResponseBody
	public HashMap<String, Object> listeJuges(@RequestParam("typeTribunal") String type,@RequestParam("idTribunal") String idTribunal) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		Long typeTribunal = null;
		if(type.equals("PREMIERE_INSTANCE")) {
			typeTribunal = (long) 2;
		}else if(type.equals("COUR_APPEL")) {
			typeTribunal = (long) 1;
		}
		result.put("juges", ajouterService.listeJuges(Long.parseLong(idTribunal), typeTribunal));
		return result;
	}
	
	
	@PostMapping("Client/ajouterDossier/dossier")
	@ResponseBody
	public GenericResponse addDossier(@RequestParam("tribunal") String tribunal,
			@RequestParam("numero_dossier") String numero_dossier,
			@RequestParam("date_dossier") String date_dossier,
			@RequestParam("date_accident") String date_accident,
			@RequestParam("date_session") String date_session,
			@RequestParam("juge") String juge,
			@RequestParam("numero_national") String numero_national,
			@RequestParam("logged_in_user") String logged_in_user){
		try {
			if(numero_dossier.isEmpty()) {
				return new GenericResponse("لم يتم إضافة الملف، المرجوا إعادة المحاولة", "error");
			}
			Dossier dossier = new Dossier();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			dossier.setTribunal(tribunal);
			dossier.setNumeroDossier(numero_dossier);
			dossier.setDateDossier(formatter.parse(date_dossier));
			dossier.setDateDossier1(formatter.parse(date_accident));
			dossier.setDateSeance(formatter.parse(date_session));
			if(!juge.isEmpty()) {
				dossier.setMatriculeJuge(juge);
			}
			dossier.setNumeroNational(numero_national);
			System.out.println(dossier.getNumeroDossier());
			ajouterService.ajouterDossier(dossier);
			
			UserDossier userDossier = new UserDossier(numero_dossier, Long.parseLong(logged_in_user));
			ajouterService.ajouterUserDossier(userDossier);
			
			return new GenericResponse("تم إضافة الملف بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم إضافة الملف، المرجوا إعادة المحاولة", "error");
		}
	}
	
	
	@PostMapping("Client/ajouterDossier/victime")
	@ResponseBody
	public List<Object> addVictime(
			@RequestParam("cni_victime") String cni_victime,
			@RequestParam("prenom_victime") String prenom_victime,
			@RequestParam("nom_victime") String nom_victime,
			@RequestParam("etat_social_victime") String etat_social_victime,
			@RequestParam("nombre_enfants_victime") String nombre_enfants_victime,
			@RequestParam("salaire_annuel_victime") String salaire_annuel_victime,
			@RequestParam("date_naissance_victime") String date_naissance_victime,
			@RequestParam("job_victime") String job_victime,
			@RequestParam("lieu_naissance_victime") String lieu_naissance_victime,
			@RequestParam("sexe_victime") String sexe_victime,
			@RequestParam("pere_victime") String pere_victime,
			@RequestParam("mere_victime") String mere_victime,
			@RequestParam("addresse_victime") String addresse_victime,
			@RequestParam("numero_dossier") String numero_dossier,
			@RequestParam("montantDemande") String montantDemande){

		List <Object> list = new ArrayList<Object>();
		
		try {
			Victime victime = new Victime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			
			if(cni_victime.isEmpty()) {
				cni_victime="temporaryCNI";
			}
			
			victime.setCin(cni_victime);
			victime.setPrenom(prenom_victime);
			victime.setNom(nom_victime);
			victime.setSituationFamiliale(etat_social_victime);
			if(nombre_enfants_victime.isEmpty()) {
				victime.setNombreEnfant(0);
			}else {
				victime.setNombreEnfant(Integer.parseInt(nombre_enfants_victime));
			}	
			
			victime.setSalaire(Double.parseDouble(salaire_annuel_victime));
			victime.setDateNaissance(formatter.parse(date_naissance_victime));
			victime.setProffession(job_victime);
			victime.setLieuNaissance(lieu_naissance_victime);
			victime.setSexe(sexe_victime);
			victime.setPrenomPere(pere_victime);
			victime.setPrenomMere(mere_victime);
			victime.setAddresse(addresse_victime);
			victime.setMontantDemande(Double.parseDouble(montantDemande));
			victime.setEtat("حي");
			ajouterService.ajouterVictime(victime);
			
			Long idVictime = ajouterService.consulterVictime(cni_victime).getId();
			DossierVictime dossierVictime = new DossierVictime(idVictime,numero_dossier);
			
			ajouterService.ajouterDossierVictime(dossierVictime);
			
			if(cni_victime.equals("temporaryCNI")) {
				Victime victimeEdited = ajouterService.consulterVictime(idVictime);
				victimeEdited.setCin("");
				ajouterService.ajouterVictime(victimeEdited);
			}
				
			
			list.add(new GenericResponse("تم إضافة الضحية بنجاح", "success"));
			list.add(victime);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			list.add(new GenericResponse("لم يتم إضافة الضحية، المرجوا إعادة المحاولة", "error"));
			return list;
		}
	}
	
	@PostMapping("Client/ajouterDossier/insertVictime")
	@ResponseBody
	public List<Object> insertVictime(@RequestParam("id_victime") String id_victime,
										@RequestParam("numero_dossier") String numero_dossier){
		List <Object> list = new ArrayList<Object>();
		
		try {
			System.out.println("SUCCES");
			DossierVictime dossierVictime = new DossierVictime(Long.parseLong(id_victime), numero_dossier);
			ajouterService.ajouterDossierVictime(dossierVictime);				
			list.add(new GenericResponse("تم إضافة الضحية بنجاح", "success"));
			Victime victime = ajouterService.consulterVictime(Long.parseLong(id_victime));
			list.add(victime);
			return list;
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
			list.add(new GenericResponse("لم يتم إضافة الضحية، المرجوا إعادة المحاولة", "error"));
			return list;
		}
	}
	
	@PostMapping("Client/ajouterDossier/updateVictime")
	@ResponseBody
	public List<Object> updateVictime(
			@RequestParam("id_victime") String id_victime,
			@RequestParam("etat_victime") String etat_victime){
		
		List <Object> list = new ArrayList<Object>();
		
		try {
			Victime victime = ajouterService.consulterVictime(Long.parseLong(id_victime));
			
			victime.setEtat(etat_victime);
			
			ajouterService.ajouterVictime(victime);
			
			list.add(new GenericResponse("تم إضافة الضحية بنجاح", "success"));
			list.add(victime);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			list.add(new GenericResponse("لم يتم إضافة الضحية، المرجوا إعادة المحاولة", "error"));
			return list;
		}
	}

	
	public List<Object> victimDawiList(Long idVictm){
		List<Object> victimeDawis = new ArrayList<Object>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy / MM / dd");

		try {

			DroitsPersonneDecedee victimDawi = new DroitsPersonneDecedee();
			for (Indemnite object : ajouterService.listeIndemnites()) {
				if(object.getIdVictime().toString().equals(idVictm.toString())) {
					victimDawi = (DroitsPersonneDecedee)ajouterService.consulterDawi(object.getIdDawi());
					VictimDawi VD = new VictimDawi(idVictm, object.getIdDawi(), victimDawi.getCin(),victimDawi.getNom(), victimDawi.getPrenom(),victimDawi.getAddresse(),victimDawi.getSituationFamilialle(),formatter.format(victimDawi.getDateNaissance()) ,victimDawi.getTa3wid(),victimDawi.getTa3widMa3nawi(),victimDawi.getProffession(),victimDawi.getNisbMadi(), object.getCoteFamille(), object.getHa9Ta3wid());
					victimeDawis.add(VD);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return victimeDawis;
	}

	@PostMapping("Client/ajouterDossier/dawi")
	@ResponseBody
	public List<Object> addDawi(
			@RequestParam("relation_avec_victime") String relation_avec_victime,
			@RequestParam("droit_compensation") String droit_compensation,
			@RequestParam("cni") String cni,
			@RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom,
			@RequestParam("date_naissance") String date_naissance,
			@RequestParam("etat_sociale") String etat_sociale,
			@RequestParam("job") String job,
			@RequestParam("addresse") String addresse,
			@RequestParam("id_victime") String id_victime){
		
		List<Object> victimeDawis = new ArrayList<Object>();

		
		try {
			DroitsPersonneDecedee dawi = new DroitsPersonneDecedee();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			
			//dawi.setRelationAvecVictime(relation_avec_victime);
			//dawi.setDroitCompensation(droit_compensation);
			if(cni.isEmpty()) {
				cni="temporaryCNI";
			}
			dawi.setCin(cni);
			dawi.setNom(nom);
			dawi.setPrenom(prenom);
			dawi.setDateNaissance(formatter.parse(date_naissance));
			dawi.setSituationFamilialle(etat_sociale);
			dawi.setProffession(job);
			dawi.setAddresse(addresse);
			//dawi.setVictime(accidentService.consulterVictime(Long.parseLong(id_victime)).getCin());
			dawi.setTa3wid(0.0);
			dawi.setTa3widMa3nawi(0.0);
			
			ajouterService.ajouterDawi(dawi);
			
			Long idDawi = ajouterService.consulterDawi(cni).getId();
			Indemnite indemnite = new Indemnite(Long.parseLong(id_victime), idDawi, relation_avec_victime, droit_compensation);
			
			ajouterService.ajouterIndemnite(indemnite);
			
			if(cni.equals("temporaryCNI")) {
				DroitsPersonneDecedee dawiEdited = ajouterService.consulterDawi(idDawi);
				dawiEdited.setCin("");
				ajouterService.ajouterDawi(dawiEdited);
			}
			
		
			Indemnite indem = new Indemnite(Long.parseLong(id_victime), idDawi, relation_avec_victime, droit_compensation);
			ajouterService.ajouterIndemnite(indem);

			DroitsPersonneDecedee victimDawi = new DroitsPersonneDecedee();
			for (Indemnite object : ajouterService.listeIndemnites()) {
				if(object.getIdVictime().toString().equals(id_victime)) {
					victimDawi = (DroitsPersonneDecedee)ajouterService.consulterDawi(object.getIdDawi());
					VictimDawi VD = new VictimDawi(Long.parseLong(id_victime), object.getIdDawi(), victimDawi.getCin(),victimDawi.getNom(), victimDawi.getPrenom(),victimDawi.getAddresse(),victimDawi.getSituationFamilialle(),formatter.format(victimDawi.getDateNaissance()) ,victimDawi.getTa3wid(),victimDawi.getTa3widMa3nawi(),victimDawi.getProffession(),victimDawi.getNisbMadi(), object.getCoteFamille(), object.getHa9Ta3wid());

					if(victimeDawis.size() == 0) {
						victimeDawis.add(new GenericResponse("تم إضافة ذي الحقوق بنجاح", "success"));
					}
					
					victimeDawis.add(VD);
				}
			}
			return victimeDawis;
			
		} catch (Exception e) {
			e.printStackTrace();
			victimeDawis.add(new GenericResponse("لم يتم إضافة ذي الحقوق، المرجوا إعادة المحاولة", "error"));
			return victimeDawis;

		}
		
	}
	
	
	
//	@PostMapping("Client/ajouterDossier/dawi")
//	@ResponseBody
//	public GenericResponse addDawi(
//			@RequestParam("relation_avec_victime") String relation_avec_victime,
//			@RequestParam("droit_compensation") String droit_compensation,
//			@RequestParam("cni") String cni,
//			@RequestParam("nom") String nom,
//			@RequestParam("prenom") String prenom,
//			@RequestParam("date_naissance") String date_naissance,
//			@RequestParam("etat_sociale") String etat_sociale,
//			@RequestParam("job") String job,
//			@RequestParam("addresse") String addresse,
//			@RequestParam("id_victime") String id_victime){
//		
//		
//		try {
//			DroitsPersonneDecedee dawi = new DroitsPersonneDecedee();
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//			
//			//dawi.setRelationAvecVictime(relation_avec_victime);
//			//dawi.setDroitCompensation(droit_compensation);
//			if(cni.isEmpty()) {
//				cni="temporaryCNI";
//			}
//			dawi.setCin(cni);
//			dawi.setNom(nom);
//			dawi.setPrenom(prenom);
//			dawi.setDateNaissance(formatter.parse(date_naissance));
//			dawi.setSituationFamilialle(etat_sociale);
//			dawi.setProffession(job);
//			dawi.setAddresse(addresse);
//			//dawi.setVictime(accidentService.consulterVictime(Long.parseLong(id_victime)).getCin());
//			dawi.setTa3wid(0.0);
//			dawi.setTa3widMa3nawi(0.0);
//			
//			ajouterService.ajouterDawi(dawi);
//			
//			Long idDawi = ajouterService.consulterDawi(cni).getId();
//			Indemnite indemnite = new Indemnite(Long.parseLong(id_victime), idDawi, relation_avec_victime, droit_compensation);
//			
//			ajouterService.ajouterIndemnite(indemnite);
//			
//			if(cni.equals("temporaryCNI")) {
//				DroitsPersonneDecedee dawiEdited = ajouterService.consulterDawi(idDawi);
//				dawiEdited.setCin("");
//				ajouterService.ajouterDawi(dawiEdited);
//			}
//			
//			
//			return new GenericResponse("تم إضافة ذي الحقوق بنجاح", "success");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new GenericResponse("لم يتم إضافة ذي الحقوق، المرجوا إعادة المحاولة", "error");
//		}
//	}
	
	/*
	@PostMapping("Client/ajouterDossier/insertDawi")
	@ResponseBody
	public GenericResponse insertDawi(
			@RequestParam("relation_avec_victime") String relation_avec_victime,
			@RequestParam("droit_compensation") String droit_compensation,
			@RequestParam("id_dawi") String id_dawi,
			@RequestParam("id_victime") String id_victime){
		
		try {
			
			Indemnite indemnite = new Indemnite(Long.parseLong(id_victime), Long.parseLong(id_dawi), relation_avec_victime, droit_compensation);
			ajouterService.ajouterIndemnite(indemnite);
			
			return new GenericResponse("تم إضافة ذي الحقوق بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم إضافة ذي الحقوق، المرجوا إعادة المحاولة", "error");
		}
	}
	*/
	
	@PostMapping("Client/ajouterDossier/avocatVictime")
	@ResponseBody
	public GenericResponse addAvocatVictime(
			@RequestParam("cni_avocat_victime") String cni_avocat_victime,
			@RequestParam("prenom_avocat_victime") String prenom_avocat_victime,
			@RequestParam("nom_avocat_victime") String nom_avocat_victime,
			@RequestParam("barreau_victime") String barreau_victime,
			@RequestParam("addresse_avocat_victime") String addresse_avocat_victime,
			@RequestParam("id_victime") String id_victime){
		
		
		try {
			Avocat avocat = new Avocat();			
			avocat.setCin(cni_avocat_victime);
			avocat.setPrenom(prenom_avocat_victime);
			avocat.setNom(nom_avocat_victime);
			avocat.setHaya(Long.parseLong(barreau_victime));
			avocat.setAddresse(addresse_avocat_victime);
			ajouterService.ajouterAvocat(avocat);
			
			AvocatVictime avocatVictime = new AvocatVictime(cni_avocat_victime, Long.parseLong(id_victime));
			ajouterService.ajouterAvocatVictime(avocatVictime);
			
			return new GenericResponse("تم إضافة المحامي بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم إضافة المحامي، المرجوا إعادة المحاولة", "error");
		}
	}
	
	
	@PostMapping("Client/ajouterDossier/insertAvocatVictime")
	@ResponseBody
	public GenericResponse insertAvocatVictime(
			@RequestParam("cni_avocat_victime") String cni_avocat_victime,
			@RequestParam("id_victime") String id_victime){
		
		
		try {
			
			AvocatVictime avocatVictime = new AvocatVictime(cni_avocat_victime, Long.parseLong(id_victime));
			ajouterService.ajouterAvocatVictime(avocatVictime);
			
			return new GenericResponse("تم إضافة المحامي بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم إضافة المحامي، المرجوا إعادة المحاولة", "error");
		}
	}

	
	@PostMapping("Client/ajouterDossier/accuse")
	@ResponseBody
	public List<Object> addAccuse(
			@RequestParam("cni_accuse") String cni_accuse,
			@RequestParam("prenom_accuse") String prenom_accuse,
			@RequestParam("nom_accuse") String nom_accuse,
			@RequestParam("etat_social_accuse") String etat_social_accuse,
			@RequestParam("nombre_enfants_accuse") String nombre_enfants_accuse,
			@RequestParam("assurance_accuse") String assurance_accuse,
			@RequestParam("date_naissance_accuse") String date_naissance_accuse,
			@RequestParam("job_accuse") String job_accuse,
			@RequestParam("lieu_naissance_accuse") String lieu_naissance_accuse,
			@RequestParam("sexe_accuse") String sexe_accuse,
			@RequestParam("pere_accuse") String pere_accuse,
			@RequestParam("mere_accuse") String mere_accuse,
			@RequestParam("addresse_accuse") String addresse_accuse,
			@RequestParam("charge_accuse") String charge_accuse,
			@RequestParam("numero_dossier") String numero_dossier){
		
		List <Object> list = new ArrayList<Object>();
		
		try {
			Accuse accuse = new Accuse();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			if(cni_accuse.isEmpty()) {
				cni_accuse="temporaryCNI";
			}
			accuse.setCin(cni_accuse);
			accuse.setPrenom(prenom_accuse);
			accuse.setNom(nom_accuse);
			accuse.setSituationFamilialle(etat_social_accuse);
			if(nombre_enfants_accuse.isEmpty()) {
				accuse.setNombreEnfant(0);
			}else {
				accuse.setNombreEnfant(Integer.parseInt(nombre_enfants_accuse));
			}
			accuse.setAssurance(Long.parseLong(assurance_accuse));
			accuse.setDateNaissance(formatter.parse(date_naissance_accuse));
			accuse.setProffession(job_accuse);
			accuse.setLieuNaissance(lieu_naissance_accuse);
			accuse.setSexe(sexe_accuse);
			accuse.setPrenomPere(pere_accuse);
			accuse.setPrenomMere(mere_accuse);
			accuse.setAddresse(addresse_accuse);
			
			//accuse.setTohma(charge_accuse);
			//accuse.setNumeroDossier(numero_dossier);
			
			ajouterService.ajouterAccuse(accuse);
			
			Long idAccuse = ajouterService.consulterAccuse(cni_accuse).getId();
			DossierAccuse dossierAccuse = new DossierAccuse(idAccuse, numero_dossier, Long.parseLong(charge_accuse));
			
			ajouterService.ajouterDossierAccuse(dossierAccuse);
			
			if(cni_accuse.equals("temporaryCNI")) {
				Accuse accuseEdited = ajouterService.consulterAccuse(idAccuse);
				accuseEdited.setCin("");
				ajouterService.ajouterAccuse(accuseEdited);
			}
			
			list.add(new GenericResponse("تم إضافة المتهم بنجاح", "success"));
			list.add(accuse);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			list.add(new GenericResponse("لم يتم إضافة المتهم، المرجوا إعادة المحاولة", "error"));
			return list;
		}
	}
	
	
	@PostMapping("Client/ajouterDossier/insertAccuse")
	@ResponseBody
	public List<Object> insertAccuse(
			@RequestParam("id_accuse") String id_accuse,
			@RequestParam("numero_dossier") String numero_dossier,
			@RequestParam("charge_accuse") String charge_accuse){
		
		List <Object> list = new ArrayList<Object>();
		
		try {
			
			DossierAccuse dossierAccuse = new DossierAccuse(Long.parseLong(id_accuse), numero_dossier, Long.parseLong(charge_accuse));
			ajouterService.ajouterDossierAccuse(dossierAccuse);
			
			Accuse accuse = ajouterService.consulterAccuse(Long.parseLong(id_accuse));
			
			list.add(new GenericResponse("تم إضافة المتهم بنجاح", "success"));
			list.add(accuse);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			list.add(new GenericResponse("لم يتم إضافة المتهم، المرجوا إعادة المحاولة", "error"));
			return list;
		}
	}
	
	
	
	@PostMapping("Client/ajouterDossier/officierCivil")
	@ResponseBody
	public GenericResponse addOfficierCivil(
			@RequestParam("cni_officier_civil") String cni_officier_civil,
			@RequestParam("prenom_officier_civil") String prenom_officier_civil,
			@RequestParam("nom_officier_civil") String nom_officier_civil,
			@RequestParam("assurance_officier_civil") String assurance_officier_civil,
			@RequestParam("addresse_officier_civil") String addresse_officier_civil,
			@RequestParam("id_accuse") String id_accuse){
		try {
			OfficierCivil officierCivil = new OfficierCivil();
			officierCivil.setCniOfficierCivil(cni_officier_civil);
			officierCivil.setPrenom(prenom_officier_civil);
			officierCivil.setNom(nom_officier_civil);
			officierCivil.setAssurance(Long.parseLong(assurance_officier_civil));
			officierCivil.setAddresse(addresse_officier_civil);
			ajouterService.ajouterOfficierCivil(officierCivil);
			
			Accuse accuse = ajouterService.consulterAccuse(Long.parseLong(id_accuse));
			accuse.setCniOfficierCivil(cni_officier_civil);
			ajouterService.ajouterAccuse(accuse);
			
			return new GenericResponse("تم إضافة المسؤول المدني بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم إضافة المسؤول المدني، المرجوا إعادة المحاولة", "error");
		}
	}
	
	
	@PostMapping("Client/ajouterDossier/insertOfficierCivil")
	@ResponseBody
	public GenericResponse insertOfficierCivil(
			@RequestParam("cni_officier_civil") String cni_officier_civil,
			@RequestParam("id_accuse") String id_accuse){
		try {
			
			Accuse accuse = ajouterService.consulterAccuse(Long.parseLong(id_accuse));
			accuse.setCniOfficierCivil(cni_officier_civil);
			ajouterService.ajouterAccuse(accuse);
			
			return new GenericResponse("تم إضافة المسؤول المدني بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم إضافة المسؤول المدني، المرجوا إعادة المحاولة", "error");
		}
	}
	
	@PostMapping("Client/ajouterDossier/avocatAccuse")
	@ResponseBody
	public GenericResponse addAvocatAccuse(
			@RequestParam("cni_avocat_accuse") String cni_avocat_accuse,
			@RequestParam("prenom_avocat_accuse") String prenom_avocat_accuse,
			@RequestParam("nom_avocat_accuse") String nom_avocat_accuse,
			@RequestParam("barreau_accuse") String barreau_accuse,
			@RequestParam("addresse_avocat_accuse") String addresse_avocat_accuse,
			@RequestParam("id_accuse") String id_accuse){
		
		
		try {
			Avocat avocat = new Avocat();			
			avocat.setCin(cni_avocat_accuse);
			avocat.setPrenom(prenom_avocat_accuse);
			avocat.setNom(nom_avocat_accuse);
			avocat.setHaya(Long.parseLong(barreau_accuse));
			avocat.setAddresse(addresse_avocat_accuse);
			ajouterService.ajouterAvocat(avocat);
			
			AvocatAccuse avocatAccuse = new AvocatAccuse(cni_avocat_accuse, Long.parseLong(id_accuse));
			ajouterService.ajouterAvocatAccuse(avocatAccuse);
			
			return new GenericResponse("تم إضافة المحامي بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم إضافة المحامي، المرجوا إعادة المحاولة", "error");
		}
	}
	
	@PostMapping("Client/ajouterDossier/insertAvocatAccuse")
	@ResponseBody
	public GenericResponse insertAvocatAccuse(
			@RequestParam("cni_avocat_accuse") String cni_avocat_accuse,
			@RequestParam("id_accuse") String id_accuse){
		
		
		try {
			
			AvocatAccuse avocatAccuse = new AvocatAccuse(cni_avocat_accuse, Long.parseLong(id_accuse));
			ajouterService.ajouterAvocatAccuse(avocatAccuse);
			
			return new GenericResponse("تم إضافة المحامي بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم إضافة المحامي، المرجوا إعادة المحاولة", "error");
		}
	}
	
	
	@PostMapping("Client/ajouterDossier/temoin")
	@ResponseBody
	public List<Object> addTemoin(
			@RequestParam("cni_temoin") String cni_temoin,
			@RequestParam("prenom_temoin") String prenom_temoin,
			@RequestParam("nom_temoin") String nom_temoin,
			@RequestParam("etat_sociale_temoin") String etat_sociale_temoin,
			@RequestParam("date_naissance_temoin") String date_naissance_temoin,
			@RequestParam("job_temoin") String job_temoin,
			@RequestParam("lieu_naissance_temoin") String lieu_naissance_temoin,
			@RequestParam("sexe_temoin") String sexe_temoin,
			@RequestParam("pere_temoin") String pere_temoin,
			@RequestParam("mere_temoin") String mere_temoin,
			@RequestParam("addresse_temoin") String addresse_temoin,
			@RequestParam("numero_dossier") String numero_dossier){
		
		List <Object> list = new ArrayList<Object>();
		
		try {
			Temoin temoin = new Temoin();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			
			if(cni_temoin.isEmpty()) {
				list.add(new GenericResponse("لم يتم إضافة الشاهد، المرجوا إعادة المحاولة", "error"));
				return list;
			}
			
			temoin.setCinTemoin(cni_temoin);
			temoin.setPrenom(prenom_temoin);
			temoin.setNom(nom_temoin);
			temoin.setSituation(etat_sociale_temoin);
			temoin.setDateNaissance(formatter.parse(date_naissance_temoin));
			temoin.setProffession(job_temoin);
			temoin.setLieuNaissance(lieu_naissance_temoin);
			temoin.setSexe(sexe_temoin);
			temoin.setPrenomPere(pere_temoin);
			temoin.setPrenomMere(mere_temoin);
			temoin.setAddresse(addresse_temoin);
			
			ajouterService.ajouterTemoin(temoin);
			
			Temoigner temoigner = new Temoigner(cni_temoin,numero_dossier);
			
			ajouterService.ajouterTemoigner(temoigner);
			
			list.add(new GenericResponse("تم إضافة الشاهد بنجاح", "success"));
			list.add(temoin);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			list.add(new GenericResponse("لم يتم إضافة الشاهد، المرجوا إعادة المحاولة", "error"));
			return list;
		}
	}
	
	@PostMapping("Client/ajouterDossier/insertTemoin")
	@ResponseBody
	public List<Object> insertTemoin(
			@RequestParam("cni_temoin") String cni_temoin,
			@RequestParam("numero_dossier") String numero_dossier){
		
		List <Object> list = new ArrayList<Object>();
		
		try {
			
			Temoigner temoigner = new Temoigner(cni_temoin,numero_dossier);
			ajouterService.ajouterTemoigner(temoigner);
			
			Temoin temoin = ajouterService.consulterTemoin(cni_temoin);
			
			list.add(new GenericResponse("تم إضافة الشاهد بنجاح", "success"));
			list.add(temoin);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			list.add(new GenericResponse("لم يتم إضافة الشاهد، المرجوا إعادة المحاولة", "error"));
			return list;
		}
	}
	
	
	//Admin
	@PostMapping("Admin/ajouterDossier/addCourAppel")
	public String addCourAppel(@RequestParam("nom") String nom) {
		ajouterService.ajouterCourAppel(nom);
		return "Admin/ajouterDossier";
	}
	
	@PostMapping("Admin/ajouterDossier/addPremiere")
	public String addPremiere(@RequestParam("nom") String nom, @RequestParam("id") Long id) {
		ajouterService.ajouterPremiereInstance(nom, id);
		return "Admin/ajouterDossier";
	}
	
	


// supprimer dawi 
	
@PostMapping("Client/ajouterDossier/supprimerDawi")
@ResponseBody
public List<Object> supprimerDawi(@RequestParam("idDawi") String idDawi, @RequestParam("idVictime") String idVictime){
	
	List<Object> listDawis = new ArrayList<Object>() ;
	try {
		ajouterService.supprimerIdemniteByIdDawi(Long.parseLong(idDawi));
		ajouterService.supprimerDawiById(Long.parseLong(idDawi));
		listDawis =victimDawiList(Long.parseLong(idVictime));
		return listDawis;
		
	} catch (Exception e) {
		e.printStackTrace();
		listDawis.add(new GenericResponse("حدث خطأ، لم يتم حذف ذوي الحقوق", "error"));
		return listDawis;
	}
}


//modifier dawi 

@PostMapping("Client/ajouterDossier/modifierDawi")
@ResponseBody
public List<Object> modifierDawi(
		@RequestParam("relation_avec_victime") String relation_avec_victime,
		@RequestParam("droit_compensation") String droit_compensation,
		@RequestParam("cni") String cni,
		@RequestParam("nom") String nom,
		@RequestParam("prenom") String prenom,
		@RequestParam("date_naissance") String date_naissance,
		@RequestParam("etat_sociale") String etat_sociale,
		@RequestParam("job") String job,
		@RequestParam("addresse") String addresse,
		@RequestParam("id_victime") String id_victime){
	
	List<Object> listDawis = new ArrayList<Object>() ;
	try {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		for (DroitsPersonneDecedee dawi : ajouterService.listeDawis()) {
			if(dawi.getCin().equals(cni)) {
				dawi.setCin(cni);
				dawi.setNom(nom);
				dawi.setPrenom(prenom);
				dawi.setSituationFamilialle(etat_sociale);
				dawi.setAddresse(addresse);
				dawi.setProffession(job);
				dawi.setDateNaissance(formatter.parse(date_naissance));
				listDawis.add(new GenericResponse("تم تحديث ذي الحقوق بنجاح.", "message"));
			}
		}
		listDawis.addAll(victimDawiList(Long.parseLong(id_victime)));
		return listDawis;
		
	} catch (Exception e) {
		e.printStackTrace();
		listDawis.add(new GenericResponse("حدث خطأ، لم يتم تحديث ذي الحقوق.", "message"));
		return listDawis;
	}
}
}
