package shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.model.Client;
import shop.model.Employee;
import shop.model.User;
import shop.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

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
    public ResponseEntity<Client> addNewClient(@RequestBody Client client){
        Client newClient = ((Client) this.userService.addUser(client));
        return new ResponseEntity<>(newClient, HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
        Employee newEmployee = ((Employee) this.userService.addUser(employee));
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("cpf") String cpf){
        Optional<User> newUser = this.userService.findById(cpf);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser={cpf}")
    public ResponseEntity<String> deleteUserById(@PathVariable("cpf") String cpf){
        Boolean hasUserBeenDeleted = this.userService.deleteById(cpf);
        if(hasUserBeenDeleted){
            return new ResponseEntity<>("User has been deleted successfully!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("He's dead Jim!", HttpStatus.BAD_REQUEST);
        }
    }
    

}
