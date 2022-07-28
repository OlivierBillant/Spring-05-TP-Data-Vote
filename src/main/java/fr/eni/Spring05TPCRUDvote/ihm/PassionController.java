package fr.eni.Spring05TPCRUDvote.ihm;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.eni.Spring05TPCRUDvote.bll.PassionException;
import fr.eni.Spring05TPCRUDvote.bll.PassionManager;
import fr.eni.Spring05TPCRUDvote.bo.Passion;


@Controller
@RequestMapping("/passion")
public class PassionController {
	@Autowired
	PassionManager manager;
	
	@PostConstruct
	public void init() throws PassionException {
		Passion crochet = new Passion("Crochet", "Long et pénible");
		Passion peche = new Passion("Peche", "Penible et stupide");
		Passion belote = new Passion("Belote", "Formidable et formidable");
//		Passion chasse = new Passion("Chasse", "Dangereux et stupide");
		manager.addPassion(crochet, peche, belote);
//		manager.addPassion(chasse);
	}
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("list",manager.getAllPassion());
		return "index";
	}
	
	@GetMapping("/add")
	public String iniAddForm(Passion passion, Model model) {
		return "add";
	}
	
	@PostMapping("/add")
	public String validAddForm(@Valid Passion passion, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "add";
		}
		try {
			manager.addPassion(passion);
		} catch (PassionException e) {
			errors.addError(new FieldError("passion","nom",e.getMessage()));
			return "add";
		}
		return "redirect:/passion";
	}
	
	@GetMapping("/del/{id}")
	public String delPassion(@PathVariable("id") Integer id, Model model) {
		manager.delPassionById(id);
		return "redirect:/passion";
	}
	
	@GetMapping("/mod/{id}")
	public String modPassion(@PathVariable("id") Integer id, Model model) {
		Passion passion = manager.getPassionById(id);
		model.addAttribute("passion",passion);
		return "mod";
	}
	
	@PostMapping("/mod/{id}") 
	public String modeValidPassion(@PathVariable("id") Integer id,@Valid Passion passion, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "mod";
		}
		passion.setIdPassion(id);
		try {
			manager.addPassion(passion);
		} catch (PassionException e) {
			errors.addError(new FieldError("passion","nom",e.getMessage()));
			return "add";
		}
		return "redirect:/passion";
	}
}
