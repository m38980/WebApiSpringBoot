package st.evora.engenharia.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.User;
import st.evora.engenharia.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User login(String username, String password) {

		User user = userRepository.findByUsernameAndPassword(username, password);
		return user;
	}

	public List<User> listAll(String keyword) {
		if (keyword != null) {
			return userRepository.search(keyword);
		}
		return (List<User>) userRepository.findAll();

	}
	public void save(User user) {
		userRepository.save(user);
	}

	public User get(Long id) {
		return userRepository.findById(id).get();
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
