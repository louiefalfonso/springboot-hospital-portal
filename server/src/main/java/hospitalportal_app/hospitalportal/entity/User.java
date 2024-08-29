package hospitalportal_app.hospitalportal.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    public String getPassword() {
        return password;
    }

    public Object setName(Object name) {
        return name;
    }

    public String setUsername(String username) {
        return username;
    }

    public String setEmail(String email) {
        return email;
    }

    public String setPassword(String encode) {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> setRoles(Set<Role> roles) {
        return roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
