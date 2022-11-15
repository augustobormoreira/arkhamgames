package shop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    private String cpf;
    private String name;
    private String streetName;
    private String homeNumber;
    private String cep;
    private String userName;
    private String password;
}
