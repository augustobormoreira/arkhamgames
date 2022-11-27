package progweb.servershop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import progweb.servershop.model.Client;
import progweb.servershop.model.Employee;
import progweb.servershop.model.User;
import progweb.servershop.repository.UserRepository;


/*
 * Uma classe de serviço é responsável por fornecer funcionalidades de transação na nossa aplicação.
 * Toda classe de serviço precisa ser anotada com @Service, e toda classe de serviço possui pelo
 * menos um repositório nela. Nesse caso a classe de serviço UserService possui o userRepository.
 * É aqui que é criado métodos mais intuitivos para o controlador e usado as funcionalidades
 * do repositório.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    /*
     * Usando o AutoWired no construtor eu me certifico que o userRepository é injetado no meu
     * serviço. Novamente outra maneira de se fazer isso seria:
     * @AutoWired
     * private UserRepository userRepository;
     * As duas maneiras são ok, mas a acima é mais comum.
     */
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

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

    public User findUser(String username){
        return this.userRepository.findClientByUsername(username);
    }

    

   
   
}
