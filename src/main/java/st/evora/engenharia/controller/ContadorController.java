package st.evora.engenharia.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.Contador;
import st.evora.engenharia.repository.ContadorRepository;
import st.evora.engenharia.service.ClienteService;
import st.evora.engenharia.service.ContadorService;

@Controller
@RequestMapping("/contadores")
public class ContadorController {

	@Autowired
	ContadorService contadorService;

	@Autowired
	ContadorRepository contadorRepository;

	public ContadorController(ContadorService contadorService) {
		super();
		this.contadorService = contadorService;
	}

	@GetMapping()
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Contador> listContadores = contadorService.listAll(keyword);
		model.addAttribute("listContadores", listContadores);
		model.addAttribute("keyword", keyword);

		return "contadores";
	}

	@GetMapping("/contadores/new")
	public String createContadorForm(Model model) {

		// create contador object to hold contador form data
		Contador contador = new Contador();
		model.addAttribute("contador", contador);
		return "create_contador";

	}
	
	@PostMapping("/save")
	//@ResponseStatus(HttpStatus.CREATED)
	public String saveContador(@ModelAttribute("contador") Contador contador) {
		contadorService.save(contador);

		return "redirect:/contadores";
	}
	@PostMapping("/updatecontador/{id}")
	public String updateContador(@ModelAttribute("contador") Contador contador, @PathVariable(name = "id") Long id) {
		Contador contadorActual = contadorRepository.findById(id).orElse(null);

		if (contadorActual != null) {

			BeanUtils.copyProperties(contador, contadorActual, "idcontador");
			contadorService.save(contadorActual);

		}

		return "redirect:/contadores";
	}

	@GetMapping("/editcontadores/{id}")
	public ModelAndView showEditContadorPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("editar_contador");
		Contador contador = contadorRepository.findById(id).orElse(null);
		mav.addObject("contador", contador);

		return mav;
	}

	// Aqui deveria ser delete mas ele esta usando get.
	// @RequestMapping(value = "/cliente/delete/{id}")
	// @GetMapping("/delete/{id}")
	@GetMapping("/delete/{id}")
	public String deleteContador(@PathVariable(name = "id") Long id) {
		contadorService.delete(id);

		return "redirect:/contadores";

	}
	/*
	@GetMapping("/search")
	public ModelAndView search(@PathVariable String keyword) {
		ModelAndView mav = new ModelAndView("search");
		List<Cliente> result = clienteService.search(keyword);
		
		return mav;
	}
	
	
	*/
}
