package org.baeldung.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.baeldung.persistence.model.User;
import org.baeldung.persistence.model.pfe.Dossier;
import org.baeldung.service.pfe.ConsulterService;
import org.baeldung.service.pfe.SeancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	
	@Autowired
	SeancesService seancesService;
	
	@Autowired
	ConsulterService consulterService;
	 
	 @RequestMapping(value = "/Client/index")
		public ModelAndView wxAutoLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView ret = new ModelAndView();
			HttpSession session = request.getSession();
			User user =(User)session.getAttribute("user1");
			if(user!=null) {
				ret.addObject("user", user);
			}
			ret.setViewName("/Client/index");
			
			//infos de page d'accueil
			int nombreDossiers = 0;
			String dernierDossier = null;
			int nombreSeancesAujourdhui = 0;
			int nombreSeancesSemaine = 0;
			Dossier seancePlusProche = null;
			
			try {
				nombreDossiers = consulterService.getAllDossiersByUser(user.getId()).size();
				dernierDossier = seancesService.getLastDossier().getNumeroDossier();
				nombreSeancesAujourdhui = seancesService.getDaySeances().size();
				nombreSeancesSemaine = seancesService.getWeekSeances().size();
				seancePlusProche = seancesService.getNearestSeance();
				
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
			ret.addObject("nombreDossiers", nombreDossiers);
			ret.addObject("dernierDossier", dernierDossier);
			ret.addObject("nombreSeancesAujourdhui", nombreSeancesAujourdhui);
			ret.addObject("nombreSeancesSemaine", nombreSeancesSemaine);
			ret.addObject("seancePlusProche", seancePlusProche);
			
			return ret;

		}
	 
	 @RequestMapping(value = "/Admin/index")
		public ModelAndView wxAutoLogin1(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView ret = new ModelAndView();
			HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user1");
			if(user!=null) {
				ret.addObject("user", user);
			}
			ret.setViewName("/Admin/index");
			return ret;

		}
}
