package org.baeldung.web.controller.pfe;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.baeldung.persistence.model.User;
import org.baeldung.persistence.model.pfe.Dossier;
import org.baeldung.service.pfe.SeancesService;
import org.baeldung.web.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeancesController {
	
	@Autowired
	SeancesService seancesService;
	
	@GetMapping("Client/prochainesSeances")
	public String prochaineSeance(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user1");
		if(user!=null) {
			model.addAttribute("user", user);
		}
		model.addAttribute("dossiers",seancesService.getWeekSeances());
		model.addAttribute("nombreSeancesAujourdhui",seancesService.getDaySeances().size());
		return "Client/prochainesSeances";
	}
	
	@PostMapping("Client/prochainesSeances/dateSeance")
	@ResponseBody
	public GenericResponse updateDateSeance(@RequestParam("numeroDossier") String numeroDossier, 
								@RequestParam("dateSeanceDossier") String dateSeanceDossier){
		try {
			Dossier dossier = seancesService.getDossierById(numeroDossier);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			dossier.setDateSeance(formatter.parse(dateSeanceDossier));
			seancesService.ajouterDossier(dossier);
			return new GenericResponse("تم تأجيل الجلسة بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم تأجيل الجلسة، المرجوا إعادة المحاولة", "error");
		}
	}
	
	@PostMapping("Client/prochainesSeances/rmqSeance")
	@ResponseBody
	public GenericResponse updateRmqSeance(@RequestParam("numeroDossier") String numeroDossier, 
								@RequestParam("rmqSeanceDossier") String rmqSeanceDossier){
		try {
			if(rmqSeanceDossier.isEmpty())
				return new GenericResponse("المرجوا التأكد من مكونات الملاحظة", "error");
			Dossier dossier = seancesService.getDossierById(numeroDossier);
			dossier.setCommentaire(rmqSeanceDossier);
			seancesService.ajouterDossier(dossier);
			return new GenericResponse("تم اضافة الملاحظة بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم اضافة الملاحظة، المرجوا إعادة المحاولة", "error");
		}
	}
	
	@GetMapping("Client/seancesAujourdhui")
	public String seancesAujourdhui(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user1");
		if(user!=null) {
			model.addAttribute("user", user);
		}
		model.addAttribute("dossiers",seancesService.getDaySeances());
		model.addAttribute("nombreSeancesAujourdhui",seancesService.getDaySeances().size());
		return "Client/seancesAujourdhui";
	}
	
	@PostMapping("Client/seancesAujourdhui/dateSeance")
	@ResponseBody
	public GenericResponse updateDateSeanceDay(@RequestParam("numeroDossier") String numeroDossier, 
								@RequestParam("dateSeanceDossier") String dateSeanceDossier){
		try {
			Dossier dossier = seancesService.getDossierById(numeroDossier);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			dossier.setDateSeance(formatter.parse(dateSeanceDossier));
			seancesService.ajouterDossier(dossier);
			return new GenericResponse("تم تأجيل الجلسة بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم تأجيل الجلسة، المرجوا إعادة المحاولة", "error");
		}
	}
	
	@PostMapping("Client/seancesAujourdhui/rmqSeance")
	@ResponseBody
	public GenericResponse updateRmqSeanceDay(@RequestParam("numeroDossier") String numeroDossier, 
								@RequestParam("rmqSeanceDossier") String rmqSeanceDossier){
		try {
			if(rmqSeanceDossier.isEmpty())
				return new GenericResponse("المرجوا التأكد من مكونات الملاحظة", "error");
			Dossier dossier = seancesService.getDossierById(numeroDossier);
			dossier.setCommentaire(rmqSeanceDossier);
			seancesService.ajouterDossier(dossier);
			return new GenericResponse("تم اضافة الملاحظة بنجاح", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new GenericResponse("لم يتم اضافة الملاحظة، المرجوا إعادة المحاولة", "error");
		}
	}
	
}
