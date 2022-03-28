package st.evora.engenharia.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import st.evora.engenharia.model.User;
import st.evora.engenharia.repository.UserRepository;
import st.evora.engenharia.service.ClienteService;
import st.evora.engenharia.service.ContadorService;
import st.evora.engenharia.service.UserService;

@Controller
@RequestMapping
public class AppController {

	@Autowired

	private ClienteService clienteService;
	private ContadorService contadorService;
	private UserService userService;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;

	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {

		User loginUser = userService.login(user.getUsername(), user.getPassword());

		System.out.print(user);
		if (Objects.nonNull(user)) {

			return "redirect:/clientes";

		} else {
			return "redirect:/login";

		}

	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/login";
	}

	@RequestMapping("/")
	public String paginaPrincipal() {
		return "home";

	}

	@GetMapping("/403")
	public String error403() {
		return "403";

	}

}
