package ch.zli.m223.example.auth.domain.model;

import ch.zli.m223.example.auth.util.PBKDF2;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "Users.count", query = "SELECT COUNT(u.id) FROM UserModel u"),
        @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM UserModel u WHERE u.email = :email")
})
public class UserModel extends AbstractModel {
    @Column(unique = true, nullable = false)
    @JsonProperty
    @NotBlank
    private String email;

    @Column(nullable = false, length = 2048)
    private String password;

    @Column(nullable = false)
    @NotBlank
    private String forename;

    @Column
    private String surname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.password = PBKDF2.createHash(password);
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }

    public void addRole(RoleModel role) {
        if (this.roles == null) {
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
    }
}
