package org.baeldung.web.controller.pfe;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.baeldung.persistence.model.User;
import org.baeldung.persistence.model.pfe.Accuse;
import org.baeldung.persistence.model.pfe.Temoin;
import org.baeldung.persistence.model.pfe.Victime;
import org.baeldung.service.pfe.SeancesService;
import org.baeldung.service.pfe.ChercherService;
import org.baeldung.web.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChercherController {
	@Autowired
	ChercherService searchService;
	
	@Autowired
	SeancesService seancesService;
	
	@GetMapping("Client/rechercher")
	public String rechercher(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user1");
		if(user!=null) {
			model.addAttribute("user", user);
		}
		model.addAttribute("nombreSeancesAujourdhui",seancesService.getDaySeances().size());
		return "Client/rechercher";
	}
	
	@PostMapping("Client/rechercher/action")
	@ResponseBody
	public List<Object> rechercherAction(@RequestParam("search_type") String search_type, 
								@RequestParam("search_keyword") String search_keyword){
		List<Object> list = new ArrayList<Object>();
		try {
			list.add(new GenericResponse("OK", "success"));
			
			if(search_type.equals("dossier")) {
				list.add(searchService.getDossierById(search_keyword));
			}else if(search_type.equals("victime")) {
				if(search_keyword.matches(".*\\d.*")){
					Victime victime = searchService.getVictimeByCin(search_keyword);
					if(victime != null)
						list.add(victime);
				} else{
					List<Victime> listVictimes = searchService.getVictimesByKeyword(search_keyword);
					list.addAll(listVictimes);
				}
			}else if(search_type.equals("accuse")) {
				if(search_keyword.matches(".*\\d.*")){
					Accuse accuse = searchService.getAccuseByCin(search_keyword);
					if(accuse != null)
						list.add(accuse);
				} else{
					List<Accuse> listAccuses = searchService.getAccusesByKeyword(search_keyword);
					list.addAll(listAccuses);
				}
			}else{
				if(search_keyword.matches(".*\\d.*")){
					Temoin temoin = searchService.getTemoinByCin(search_keyword);
					if(temoin != null)
						list.add(temoin);
				} else{
					List<Temoin> listTemoins = searchService.getTemoinsByKeyword(search_keyword);
					list.addAll(listTemoins);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			list.add(0, new GenericResponse("NOT", "error"));
			return list;
		}
	}
}
