package ch.zli.m223.example.auth.domain.repository;

import ch.zli.m223.example.auth.domain.model.RoleModel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Stateless
public class RoleRepository extends AbstractRepository<RoleModel, Long> {

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager entityManager() {
        return this.entityManager;
    }

    public Optional<RoleModel> findByName(String name) {
        return this.entityManager
                .createNamedQuery("Roles.findByName", RoleModel.class)
                .setParameter("name", name)
                .getResultStream()
                .findFirst();
    }
}
