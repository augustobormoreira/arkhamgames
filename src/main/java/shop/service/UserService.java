package shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.model.Client;
import shop.model.Employee;
import shop.model.User;
import shop.repository.UserRepository;

@Service

public class UserService {
    @Autowired
    public UserRepository userRepository;

    public User addUser(User user){
        return this.userRepository.save(user);
    }

    public List<Client> findAllClients(){
        return this.userRepository.findAllClient();
    }

    public List<Employee> findAllEmployees(){
        return this.userRepository.findAllEmployee();
    }

    public Optional<User> findById(String id){
        return this.userRepository.findById(id);
    }

    public boolean deleteById(String id){
        this.userRepository.deleteById(id);
        return true;
    }

    
    
}
