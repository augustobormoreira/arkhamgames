package shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.model.Client;
import shop.model.Employee;
import shop.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    

    @Query("from Client")
    List<Client> findAllClient();

    @Query("from Employee")
    List<Employee> findAllEmployee();

    @Query("from Client")
    User findClientByCpf();

    @Query("from Employee")
    User findEmployeeByCpf();
}
