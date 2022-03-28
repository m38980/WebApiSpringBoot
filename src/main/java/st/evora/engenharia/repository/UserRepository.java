package st.evora.engenharia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsernameAndPassword(String username, String password);
 
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE CONCAT " + "(u.username, " + " u.email, " + "u.enabled) LIKE %?1%")
    public List<User> search(String keyword);
    
}