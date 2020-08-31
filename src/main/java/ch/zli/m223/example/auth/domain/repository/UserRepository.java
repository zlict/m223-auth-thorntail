package ch.zli.m223.example.auth.domain.repository;

import ch.zli.m223.example.auth.domain.model.UserModel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Stateless
public class UserRepository extends AbstractRepository<UserModel, Long> {

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager entityManager() {
        return this.entityManager;
    }

    public Long count() {
        return (Long)this.entityManager.createNamedQuery("Users.count").getSingleResult();
    }

    public Optional<UserModel> findByEmail(String email) {
        return this.entityManager
            .createNamedQuery("Users.findByEmail", UserModel.class)
            .setParameter("email", email)
            .getResultStream()
            .findFirst();
    }
}
