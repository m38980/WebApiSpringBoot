package st.evora.engenharia.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.Contador;
import st.evora.engenharia.repository.ContadorRepository;

@Service
@Transactional
public class ContadorService {

	@Autowired
	private ContadorRepository contadorRepository;

	public List<Contador> listAll(String keyword) {
		if (keyword != null) {
			return contadorRepository.search(keyword);
		}
		return contadorRepository.findAll();
	}

	public Contador update(Contador contador) {
		return contadorRepository.save(contador);
	}

	public void save(Contador contador) {
		contadorRepository.save(contador);
	}

	public Contador get(Long id) {
		return contadorRepository.findById(id).get();
	}

	public void delete(Long id) {
		contadorRepository.deleteById(id);
	}
	/*
	 * public List<Cliente> search(String keyword) { return
	 * contadorRepository.search(keyword);
	 * 
	 * }
	 */
}

/*
 * public class ContadorService {
 * 
 * List<Contador> listAll(); List<Contador> getAllContadores();
 * 
 * Contador saveContador(Contador contador);
 * 
 * Contador getContadorById(Long id);
 * 
 * Contador updateContador(Contador contador);
 * 
 * void deleteContadorById(Long id);
 * 
 * }
 */
/*
 * @Autowired private ContadorRepository contadorRepository ;
 * 
 * public List<Contador> listAll() { return contadorRepository.findAll(); }
 * 
 * public void save(Contador contador) { contadorRepository.save(contador); }
 * 
 * public Contador get(Long id) { return contadorRepository.findById(id).get();
 * }
 * 
 * public void delete(Long id) { contadorRepository.deleteById(id); }
 */
