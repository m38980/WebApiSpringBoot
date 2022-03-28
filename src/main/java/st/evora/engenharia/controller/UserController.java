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
import st.evora.engenharia.model.User;
import st.evora.engenharia.repository.UserRepository;
import st.evora.engenharia.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@GetMapping()
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<User> listUsers = userService.listAll(keyword);
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("keyword", keyword);

		return "users";

	}

	@GetMapping("/novo")
	public String showNewProductPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "novo_user";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.save(user);

		return "redirect:/users";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("editar_user");
		User user = userRepository.findById(id).orElse(null);

		mav.addObject("user", user);

		return mav;
	}

	@PostMapping("/update/{id}")
	public String updateUser(@ModelAttribute("user") User user, @PathVariable(name = "id") Long id) {
		User userActual = userRepository.findById(id).orElse(null);
		if (userActual != null) {

			BeanUtils.copyProperties(user, userActual, "user_id");
			userService.save(userActual);

		}

		return "redirect:/users";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") Long id) {
		userService.delete(id);

		return "redirect:/users";

	}

}
