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
import org.baeldung.persistence.model.pfe.Dossier;
import org.baeldung.persistence.model.pfe.OfficierCivil;
import org.baeldung.persistence.model.pfe.Temoin;
import org.baeldung.persistence.model.pfe.Victime;
import org.baeldung.service.pfe.AjouterService;
import org.baeldung.service.pfe.ConsulterService;
import org.baeldung.service.pfe.SeancesService;
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
public class ConsulterController {
	
	@Autowired
	SeancesService seancesService;
	
	@Autowired
	ConsulterService consulterService;
	
	@Autowired
	private AjouterService ajouterService;
	
	@GetMapping("Client/consulterDossier")
	public String consulterDossier(Model model, HttpServletRequest request) {
		
		model.addAttribute("assurances",ajouterService.listeAssurances());
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
		model.addAttribute("nombreSeancesAujourdhui",seancesService.getDaySeances().size());
		model.addAttribute("dossiers",consulterService.getAllDossiersByUser(user.getId()));
		return "Client/consulterDossier";
	}
	
	@PostMapping("Client/consulterDossier/loadDossier")
	@ResponseBody
	public HashMap<String, Object> findDossier(@RequestParam("numero_dossier") String numeroDossier) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy / MM / dd");
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Dossier dossier = consulterService.getDossierById(numeroDossier);
		
		List<Victime> victimes = consulterService.getVictimes(numeroDossier);
		List<Accuse> accuses = consulterService.getAccuses(numeroDossier);
		List<Temoin> temoins = consulterService.getTemoins(numeroDossier);
		
		String dateAccident = formatter.format(dossier.getDateDossier1());
		String dateDossier = formatter.format(dossier.getDateDossier());
		String dateSeance = formatter.format(dossier.getDateSeance());
		
		result.put("dossier", dossier);
		
		result.put("victimes", victimes);
		result.put("accuses", accuses);
		result.put("temoins", temoins);
		
		result.put("dateAccident", dateAccident);
		result.put("dateDossier", dateDossier);
		result.put("dateSeance", dateSeance);
		
		return result;
	}
	
	@PostMapping("Client/consulterDossier/ajouterRemarque")
	@ResponseBody
	public List<Object> ajouterRemarque(@RequestParam("numeroDossier") String numeroDossier,
			@RequestParam("remarqueDossier") String remarqueDossier) {
		List<Object> result = new ArrayList<Object>();
		try {
			if(remarqueDossier.isEmpty()) {
				result.add(new GenericResponse("المرجوا التأكد من مكونات الملاحظة", "error"));
				return result;
			}
			Dossier dossier = consulterService.getDossierById(numeroDossier);
			dossier.setCommentaire(remarqueDossier);
			consulterService.ajouterDossier(dossier);
			result.add(new GenericResponse("تم اضافة الملاحظة بنجاح", "success"));
			result.add(remarqueDossier);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.add(new GenericResponse("المرجوا التأكد من مكونات الملاحظة", "error"));
			return result;
		}
	}
	
	@PostMapping("Client/consulterDossier/ajouterDateSeance")
	@ResponseBody
	public List<Object> ajouterDateSeance(@RequestParam("numeroDossier") String numeroDossier,
			@RequestParam("dateSeanceDossier") String dateSeanceDossier) {
		List<Object> result = new ArrayList<Object>();
		try {
			
			Dossier dossier = consulterService.getDossierById(numeroDossier);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			dossier.setDateSeance(formatter.parse(dateSeanceDossier));
			consulterService.ajouterDossier(dossier);
			result.add(new GenericResponse("تم اضافة الملاحظة بنجاح", "success"));
			result.add(dateSeanceDossier);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.add(new GenericResponse("المرجوا التأكد من مكونات الملاحظة", "error"));
			return result;
		}
	}
	
	@PostMapping("Client/consulterDossier/deleteDossier")
	@ResponseBody
	public GenericResponse deleteDossier(@RequestParam("numero_dossier") String numero_dossier) {
		
		try {
			consulterService.deleteDossier(numero_dossier);
			return new GenericResponse("تم حذف الملف بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم حذف الملف، المرجو اعادة المحاولة", "error");
		}
	}
	
	
	
	
	
	
	
	@GetMapping("Client/consulterDossier/Victime/{idVictime}")
	@ResponseBody
	public HashMap<String, Object> findVictime(@PathVariable("idVictime") String idVictime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Victime victime = consulterService.getVictimeById(Long.parseLong(idVictime));
		String dateNaissance = formatter.format(victime.getDateNaissance());
		
		result.put("victime", victime);
		result.put("dateNaissance", dateNaissance);
		result.put("avocats", consulterService.getAvocatVictime(Long.parseLong(idVictime)));
		result.put("dawis", consulterService.getDawisByIdVictime(victime.getId()));
		result.put("indemnites", consulterService.getIndemnitesByIdVictime(victime.getId()));
		
		return result;
	}
	
	@PostMapping("Client/consulterDossier/updateVictime")
	@ResponseBody
	public HashMap<String, Object> updateVictime(
			@RequestParam("id_victime") String id_victime,
			@RequestParam("cni_victime") String cni_victime,
			@RequestParam("prenom_victime") String prenom_victime,
			@RequestParam("nom_victime") String nom_victime,
			@RequestParam("etat_social_victime") String etat_social_victime,
			@RequestParam("nombre_enfants_victime") String nombre_enfants_victime,
			@RequestParam("salaire_annuel_victime") String salaire_annuel_victime,
			@RequestParam("date_naissance_victime") String date_naissance_victime,
			@RequestParam("job_victime") String job_victime,
			@RequestParam("lieu_naissance_victime") String lieu_naissance_victime,
			@RequestParam("pere_victime") String pere_victime,
			@RequestParam("mere_victime") String mere_victime,
			@RequestParam("addresse_victime") String addresse_victime,
			@RequestParam("etat_victime") String etat_victime){
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			Victime victime = consulterService.getVictimeById(Long.parseLong(id_victime));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			
			victime.setCin(cni_victime);
			victime.setPrenom(prenom_victime);
			victime.setNom(nom_victime);
			victime.setSituationFamiliale(etat_social_victime);
			if(nombre_enfants_victime.isEmpty()) {
				victime.setNombreEnfant(null);
			}else {
				victime.setNombreEnfant(Integer.parseInt(nombre_enfants_victime));
			}			
			victime.setSalaire(Double.parseDouble(salaire_annuel_victime));
			victime.setDateNaissance(formatter.parse(date_naissance_victime));
			victime.setProffession(job_victime);
			victime.setLieuNaissance(lieu_naissance_victime);
			victime.setPrenomPere(pere_victime);
			victime.setPrenomMere(mere_victime);
			victime.setAddresse(addresse_victime);
			//victime.setEtat(etat_victime);
			
			consulterService.ajouterVictime(victime);
			String dateNaissance = formatter.format(victime.getDateNaissance());
			
			result.put("victime", victime);
			result.put("dateNaissance", dateNaissance);
			result.put("message", new GenericResponse("تم تعديل الضحية بنجاح", "success"));
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", new GenericResponse("لم يتم تعديل الضحية، المرجوا إعادة المحاولة", "error"));
			return result;
		}
	}
	
	
	@PostMapping("Client/consulterDossier/addVictime")
	@ResponseBody
	public HashMap<String, Object> addVictime(
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
			@RequestParam("numero_dossier") String numero_dossier){
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			Victime victime = new Victime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			victime.setCin(cni_victime);
			victime.setPrenom(prenom_victime);
			victime.setNom(nom_victime);
			victime.setSituationFamiliale(etat_social_victime);
			if(nombre_enfants_victime.isEmpty()) {
				victime.setNombreEnfant(null);
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
			//victime.setNumeroDossier(numero_dossier);
			victime.setEtat("حي");
			
			consulterService.ajouterVictime(victime);
			String dateNaissance = formatter.format(victime.getDateNaissance());
			
			result.put("victime", victime);
			result.put("dateNaissance", dateNaissance);
			result.put("message", new GenericResponse("تم إضافة الضحية بنجاح", "success"));
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", new GenericResponse("لم يتم إضافة الضحية، المرجوا إعادة المحاولة", "error"));
			return result;
		}
	}
	
	
	@PostMapping("Client/ajouterDossier/updateEtatVictime")
	@ResponseBody
	public List<Object> updateEtatVictime(
			@RequestParam("id_victime") String id_victime,
			@RequestParam("etat_victime") String etat_victime){
		
		List <Object> list = new ArrayList<Object>();
		
		try {
			Victime victime = consulterService.getVictimeById(Long.parseLong(id_victime));
			
			victime.setEtat(etat_victime);
			
			consulterService.ajouterVictime(victime);
			
			list.add(new GenericResponse("تم إضافة الضحية بنجاح", "success"));
			list.add(victime);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			list.add(new GenericResponse("لم يتم إضافة الضحية، المرجوا إعادة المحاولة", "error"));
			return list;
		}
	}
	
	
	
	@PostMapping("Client/consulterDossier/deleteVictime")
	@ResponseBody
	public GenericResponse deleteDossierVictime(@RequestParam("id_victime") String id_victime,
										@RequestParam("numero_dossier") String numero_dossier) {
		
		try {
			consulterService.deleteDossierVictime(Long.parseLong(id_victime), numero_dossier);
			return new GenericResponse("تم حذف الضحية بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم حذف الضحية، المرجو اعادة المحاولة", "error");
		}
	}
	
	
	
	
	
	
	@PostMapping("Client/consulterDossier/readAccuse")
	@ResponseBody
	public HashMap<String, Object> findAccuse(@RequestParam("id_accuse") String idAccuse, @RequestParam("numero_dossier") String numeroDossier) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Accuse accuse = consulterService.getAccuseById(Long.parseLong(idAccuse));
		String dateNaissance = formatter.format(accuse.getDateNaissance());
		
		result.put("accuse", accuse);
		result.put("dateNaissance", dateNaissance);
		result.put("avocats", consulterService.getAvocatAccuse(Long.parseLong(idAccuse)));
		result.put("officierCivil", consulterService.getOfficierCivil(Long.parseLong(idAccuse)));
		
		//result.put("accuseAssurance","أكسا");
		//result.put("accuseTohma","qatl ghayr 3amd");
		//result.put("officierCivilAssurance","أليانز");
		
		OfficierCivil officierCivil = consulterService.getOfficierCivil(Long.parseLong(idAccuse));
		
		if(officierCivil != null) {
			result.put("officierCivilAssurance", consulterService.getOfficierCivilAssurance(officierCivil.getCniOfficierCivil()));
		}else {
			result.put("officierCivilAssurance","");
		}
		
		result.put("accuseAssurance", consulterService.getAccuseAssurance(Long.parseLong(idAccuse)));
		//System.out.println("accuseAssurance => " + consulterService.getAccuseAssurance(Long.parseLong(idAccuse)));
		//System.out.println("OCAssurance => " + consulterService.getOfficierCivilAssurance(consulterService.getOfficierCivil(Long.parseLong(idAccuse)).getCniOfficierCivil()));
		result.put("accuseTohma", consulterService.getAccuseTohma(Long.parseLong(idAccuse), numeroDossier));
		
		//result.put("officierCivilAssurance", consulterService.getOfficierCivilAssurance(consulterService.getOfficierCivil(Long.parseLong(idAccuse)).getCniOfficierCivil()));
		
		return result;
	}
	
	
	@PostMapping("Client/consulterDossier/updateAccuse")
	@ResponseBody
	public HashMap<String, Object> updateAccuse(
			@RequestParam("id_accuse") String id_accuse,
			@RequestParam("cni_accuse") String cni_accuse,
			@RequestParam("nom_accuse") String nom_accuse,
			@RequestParam("prenom_accuse") String prenom_accuse,
			@RequestParam("etat_social_accuse") String etat_social_accuse,
			@RequestParam("assurance_accuse") String assurance_accuse,
			@RequestParam("date_naissance_accuse") String date_naissance_accuse,
			@RequestParam("job_accuse") String job_accuse,
			@RequestParam("lieu_naissance_accuse") String lieu_naissance_accuse,
			@RequestParam("pere_accuse") String pere_accuse,
			@RequestParam("mere_accuse") String mere_accuse,
			@RequestParam("addresse_accuse") String addresse_accuse,
			@RequestParam("charge_accuse") String charge_accuse){
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			Accuse accuse = consulterService.getAccuseById(Long.parseLong(id_accuse));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			
			accuse.setCin(cni_accuse);
			accuse.setNom(nom_accuse);
			accuse.setPrenom(prenom_accuse);
			accuse.setSituationFamilialle(etat_social_accuse);
			//accuse.setAssurance(assurance_accuse);
			accuse.setDateNaissance(formatter.parse(date_naissance_accuse));
			accuse.setProffession(job_accuse);
			accuse.setLieuNaissance(lieu_naissance_accuse);
			accuse.setPrenomPere(pere_accuse);
			accuse.setPrenomMere(mere_accuse);
			accuse.setAddresse(addresse_accuse);
			//accuse.setTohma(charge_accuse);
			
			consulterService.ajouterAccuse(accuse);
			String dateNaissance = formatter.format(accuse.getDateNaissance());
			
			result.put("accuse", accuse);
			result.put("dateNaissance", dateNaissance);
			result.put("message", new GenericResponse("تم تعديل المتهم بنجاح", "success"));
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", new GenericResponse("لم يتم تعديل المتهم، المرجوا إعادة المحاولة", "error"));
			return result;
		}
	}
	
	
	@PostMapping("Client/consulterDossier/addAccuse")
	@ResponseBody
	public HashMap<String, Object> addAccuse(
			@RequestParam("cni_accuse") String cni_accuse,
			@RequestParam("nom_accuse") String nom_accuse,
			@RequestParam("prenom_accuse") String prenom_accuse,
			@RequestParam("etat_social_accuse") String etat_social_accuse,
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
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			Accuse accuse = new Accuse();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			
			accuse.setCin(cni_accuse);
			accuse.setNom(nom_accuse);
			accuse.setPrenom(prenom_accuse);
			accuse.setSituationFamilialle(etat_social_accuse);
			//accuse.setAssurance(assurance_accuse);
			accuse.setDateNaissance(formatter.parse(date_naissance_accuse));
			accuse.setProffession(job_accuse);
			accuse.setLieuNaissance(lieu_naissance_accuse);
			accuse.setSexe(sexe_accuse);
			accuse.setPrenomPere(pere_accuse);
			accuse.setPrenomMere(mere_accuse);
			accuse.setAddresse(addresse_accuse);
			//accuse.setTohma(charge_accuse);
			//accuse.setNumeroDossier(numero_dossier);
			
			consulterService.ajouterAccuse(accuse);
			String dateNaissance = formatter.format(accuse.getDateNaissance());
			
			result.put("accuse", accuse);
			result.put("dateNaissance", dateNaissance);
			result.put("message", new GenericResponse("تم إضافة المتهم بنجاح", "success"));
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", new GenericResponse("لم يتم إضافة المتهم، المرجوا إعادة المحاولة", "error"));
			return result;
		}
	}
	
	
	@PostMapping("Client/consulterDossier/deleteAccuse")
	@ResponseBody
	public GenericResponse deleteDossierAccuse(@RequestParam("id_accuse") String id_accuse,
										@RequestParam("numero_dossier") String numero_dossier) {
		
		try {
			consulterService.deleteDossierAccuse(Long.parseLong(id_accuse), numero_dossier);
			return new GenericResponse("تم حذف المتهم بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم حذف المتهم، المرجو اعادة المحاولة", "error");
		}
	}
	
	
	
	
	
	
	
	@GetMapping("Client/consulterDossier/Temoin/{cinTemoin}")
	@ResponseBody
	public HashMap<String, Object> findTemoin(@PathVariable("cinTemoin") String cinTemoin) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Temoin temoin = consulterService.getTemoinByCin(cinTemoin);
		String dateNaissance = formatter.format(temoin.getDateNaissance());
		
		result.put("temoin", temoin);
		result.put("dateNaissance", dateNaissance);		
		return result;
	}
	
	
	@PostMapping("Client/consulterDossier/updateTemoin")
	@ResponseBody
	public HashMap<String, Object> updateTemoin(
			@RequestParam("cni_temoin") String cin_temoin,
			@RequestParam("nom_temoin") String nom_temoin,
			@RequestParam("prenom_temoin") String prenom_temoin,
			@RequestParam("etat_social_temoin") String etat_social_temoin,
			@RequestParam("job_temoin") String job_temoin,
			@RequestParam("date_naissance_temoin") String date_naissance_temoin,
			@RequestParam("lieu_naissance_temoin") String lieu_naissance_temoin,
			@RequestParam("pere_temoin") String pere_temoin,
			@RequestParam("mere_temoin") String mere_temoin,
			@RequestParam("addresse_temoin") String addresse_temoin){
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			Temoin temoin = consulterService.getTemoinByCin(cin_temoin);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			
			temoin.setNom(nom_temoin);
			temoin.setPrenom(prenom_temoin);
			temoin.setSituation(etat_social_temoin);
			temoin.setProffession(job_temoin);
			temoin.setDateNaissance(formatter.parse(date_naissance_temoin));
			temoin.setLieuNaissance(lieu_naissance_temoin);
			temoin.setPrenomPere(pere_temoin);
			temoin.setPrenomMere(mere_temoin);
			temoin.setAddresse(addresse_temoin);
			
			consulterService.ajouterTemoin(temoin);
			String dateNaissance = formatter.format(temoin.getDateNaissance());
			
			result.put("temoin", temoin);
			result.put("dateNaissance", dateNaissance);
			result.put("message", new GenericResponse("تم تعديل الشاهد بنجاح", "success"));
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", new GenericResponse("لم يتم تعديل الشاهد، المرجوا إعادة المحاولة", "error"));
			return result;
		}
	}
	
	
	@PostMapping("Client/consulterDossier/addTemoin")
	@ResponseBody
	public HashMap<String, Object> addTemoin(
			@RequestParam("cni_temoin") String cin_temoin,
			@RequestParam("nom_temoin") String nom_temoin,
			@RequestParam("prenom_temoin") String prenom_temoin,
			@RequestParam("etat_social_temoin") String etat_social_temoin,
			@RequestParam("job_temoin") String job_temoin,
			@RequestParam("sexe_temoin") String sexe_temoin,
			@RequestParam("date_naissance_temoin") String date_naissance_temoin,
			@RequestParam("lieu_naissance_temoin") String lieu_naissance_temoin,
			@RequestParam("pere_temoin") String pere_temoin,
			@RequestParam("mere_temoin") String mere_temoin,
			@RequestParam("addresse_temoin") String addresse_temoin,
			@RequestParam("numero_dossier") String numero_dossier){
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		try {
			Temoin temoin = new Temoin();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			
			temoin.setCinTemoin(cin_temoin);
			temoin.setNom(nom_temoin);
			temoin.setPrenom(prenom_temoin);
			temoin.setSituation(etat_social_temoin);
			temoin.setProffession(job_temoin);
			temoin.setSexe(sexe_temoin);
			temoin.setDateNaissance(formatter.parse(date_naissance_temoin));
			temoin.setLieuNaissance(lieu_naissance_temoin);
			temoin.setPrenomPere(pere_temoin);
			temoin.setPrenomMere(mere_temoin);
			temoin.setAddresse(addresse_temoin);
			//temoin.setNumeroDossier(numero_dossier);
			
			consulterService.ajouterTemoin(temoin);
			String dateNaissance = formatter.format(temoin.getDateNaissance());
			
			result.put("temoin", temoin);
			result.put("dateNaissance", dateNaissance);
			result.put("message", new GenericResponse("تم إضافة الشاهد بنجاح", "success"));
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", new GenericResponse("لم يتم إضافة الشاهد، المرجوا إعادة المحاولة", "error"));
			return result;
		}
	}
	
	
	@PostMapping("Client/consulterDossier/deleteTemoin")
	@ResponseBody
	public GenericResponse deleteTemoigner(@RequestParam("cin_temoin") String cin_temoin,
										@RequestParam("numero_dossier") String numero_dossier) {
		
		try {
			consulterService.deleteTemoigner(cin_temoin, numero_dossier);
			return new GenericResponse("تم حذف الشاهد بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم حذف الشاهد، المرجو اعادة المحاولة", "error");
		}
	}
	
	
}
