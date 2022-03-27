package by.tms.dao.jpa;

import by.tms.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class JPAUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Transactional(readOnly = true)
    public User findById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    public void remove(User user) {
        entityManager.remove(user);
        entityManager.close();
    }

    public void update(User user) {
        entityManager.merge(user);
        entityManager.close();
    }

    public List<User> findAllByLogin(String login) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findAllByLogin", User.class);
        query.setParameter("login", login);
        List<User> resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    public List<User> findAll() {
        TypedQuery<User> from_user = entityManager.createQuery("", User.class);
        List<User> resultList = from_user.getResultList();
        entityManager.close();
        return resultList;
    }

    public User findByLogin(String login) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByLogin", User.class);
        query.setParameter("login", login);
        User singleResult = query.getSingleResult();
        entityManager.close();
        return singleResult;
    }
}
