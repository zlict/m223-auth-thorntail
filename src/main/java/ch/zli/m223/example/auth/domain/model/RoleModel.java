package ch.zli.m223.example.auth.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@NamedQueries({
        @NamedQuery(name = "Roles.findByName", query = "SELECT r FROM RoleModel r WHERE r.name = :name")
})
public class RoleModel extends AbstractModel {
    @Column(nullable = false, unique = true, length = 32)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserModel> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
