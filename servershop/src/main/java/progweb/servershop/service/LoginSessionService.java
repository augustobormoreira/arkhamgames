package progweb.servershop.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import progweb.servershop.model.LoginSession;
import progweb.servershop.model.UserDTO;
import progweb.servershop.repository.LoginSessionRepository;

@Service
public class LoginSessionService {
    @Autowired
    private LoginSessionRepository loginSessionRepository;

    public LoginSession addNewSession(UserDTO userDTO){
        LoginSession newLoginSession = new LoginSession(userDTO.getUsername(), userDTO.getToken());
        return this.loginSessionRepository.save(newLoginSession);
    }
    
}
