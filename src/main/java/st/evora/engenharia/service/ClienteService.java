package st.evora.engenharia.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
    private ClienteRepository clienteRepository ;
	
	
	
	
    public List<Cliente> listAll(String keyword) {
    	if (keyword != null) {
			return clienteRepository.search(keyword);
		}
        return clienteRepository.findAll();   
        
    } 

    public void save(Cliente cliente) {
    	clienteRepository.save(cliente);
    }
    
    public Cliente get(Integer id) {
        return clienteRepository.findById(id).get();
    }
     
    public void delete(Integer id) {
    	clienteRepository.deleteById(id);
    }
    
    public List<Cliente> search(String keyword) {
		return clienteRepository.search(keyword);

	}
    
}
