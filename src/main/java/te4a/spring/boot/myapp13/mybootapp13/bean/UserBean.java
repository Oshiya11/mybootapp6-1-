package te4a.spring.boot.myapp13.mybootapp13.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserBean {

    @Id
    private String username;

    @JsonIgnore
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

}
