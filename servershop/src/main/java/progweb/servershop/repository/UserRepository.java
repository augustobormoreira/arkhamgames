package progweb.servershop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import progweb.servershop.model.Client;
import progweb.servershop.model.Employee;
import progweb.servershop.model.User;



public interface UserRepository extends JpaRepository<User, String> {
    
   
    @Query("from Client")
    List<Client> findAllClient();

    @Query("from Client")
    User findClientByCpf();

    @Query("from Employee")
    List<Employee> findAllEmployee();

    @Query("from Client")
    User findEmployeeByCpf();

    @Query("from Client")
    User findClientByUsername(String username);

    
}
