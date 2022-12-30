package ru.galyameev.springboot312.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.galyameev.springboot312.model.User;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
         entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}
