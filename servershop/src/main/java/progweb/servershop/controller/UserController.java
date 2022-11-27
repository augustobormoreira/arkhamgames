package progweb.servershop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import progweb.servershop.model.Client;
import progweb.servershop.model.Employee;
import progweb.servershop.model.LoginSession;
import progweb.servershop.model.User;
import progweb.servershop.model.UserDTO;
import progweb.servershop.service.LoginSessionService;
import progweb.servershop.service.UserService;




@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;
    private final LoginSessionService loginSessionService;

    @GetMapping("/allClients")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = this.userService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = this.userService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/addClient")
    public ResponseEntity<Client> addClientUser(@RequestBody Client user){
        Client newUser = ((Client) this.userService.addUser(user));
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee user){
        Employee newUser = ((Employee) this.userService.addUser(user));
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("cpf") String cpf){
        Optional<User> newUser = this.userService.findById(cpf);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PostMapping("/findUser")
    public ResponseEntity<LoginSession> getSpecificUser(@RequestBody UserDTO userDTO){
        User existingUser = this.userService.findUser(userDTO.getUsername());
        if(existingUser.getPassword().equals(userDTO.getPassword())){
            LoginSession curSessh = loginSessionService.addNewSession(userDTO);
            return new ResponseEntity<>(curSessh, HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

}
