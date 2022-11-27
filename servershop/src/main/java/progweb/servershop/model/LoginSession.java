package progweb.servershop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoginSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    private String clientUsername;
    @Size(min = 1, max = 255)
    private String sesshToken;

    public LoginSession(String clientUsername, String sesshToken){
        this.clientUsername = clientUsername;
        this.sesshToken = sesshToken;
    }   

}
