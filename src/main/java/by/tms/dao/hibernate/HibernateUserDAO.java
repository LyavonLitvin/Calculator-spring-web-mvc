package by.tms.dao.hibernate;

import by.tms.dao.InterfaceDAO;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateUserDAO implements InterfaceDAO<User> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    public User findById(long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void remove(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        session.beginTransaction().commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(user);
        session.beginTransaction().commit();
        session.close();
    }

    public List<User> findAllByName(String login) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where login = :login", User.class);
        query.setParameter("login", login);
        List<User> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        Query<User> from_user = session.createQuery("from User", User.class);
        List<User> resultList = from_user.getResultList();
        session.close();
        return resultList;
    }

    public User findByUsername(String login) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where login = :login", User.class);
        query.setParameter("login", login);
        User singleResult = query.getSingleResult();
        session.close();
        return singleResult;
    }
}

