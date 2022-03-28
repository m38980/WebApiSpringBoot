package st.evora.engenharia.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.repository.ClienteRepository;
import st.evora.engenharia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteservice;

	@Autowired
	ClienteRepository clienteRepository;

	
	
	@GetMapping()
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Cliente> listClientes = clienteservice.listAll(keyword);
		model.addAttribute("listClientes", listClientes);
		model.addAttribute("keyword", keyword);

		return "clientes";

	}

	@GetMapping("/novo")
	public String showNewProductPage(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);

		return "novo_cliente";
	}

	@PostMapping("/save")
	public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteservice.save(cliente);

		return "redirect:/clientes";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditclientePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editar_cliente");
		// System.out.println("Cheguei "+id);
		Cliente cliente = clienteRepository.findById(id).orElse(null);

		mav.addObject("cliente", cliente);

		return mav;
	}

	@PostMapping("/update/{id}")
	public String updateCliente(@ModelAttribute("cliente") Cliente cliente, @PathVariable(name = "id") int id) {

		// System.out.println("Cheguei " + id);
		Cliente clienteActual = clienteRepository.findById(id).orElse(null);

		if (clienteActual != null) {

			BeanUtils.copyProperties(cliente, clienteActual, "idcliente");
			clienteservice.save(clienteActual);

		}

		return "redirect:/clientes";
	}

	// Aqui deveria ser delete mas ele esta usando get.
	// @RequestMapping(value = "/cliente/delete/{id}")
	@GetMapping("/delete/{id}")
	// @GetMapping("/delete/{id}")
	public String deleteCliente(@PathVariable(name = "id") int id) {
		System.out.println("Cheguei " + id);
		clienteservice.delete(id);

		return "redirect:/clientes";

	}

}
