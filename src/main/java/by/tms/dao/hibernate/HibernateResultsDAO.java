package by.tms.dao.hibernate;

import by.tms.entity.Result;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateResultsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Result findById(long id) {
        Session session = sessionFactory.openSession();
        Result result = session.get(Result.class, id);
        session.close();
        return result;
    }

    public List<Result> findAllByUser(User user) {
        List<Result> resultList = user.getResultList();
        return resultList;
    }

}