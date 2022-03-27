package by.tms.dao.jpa;

import by.tms.entity.Result;
import by.tms.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JPAResultDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Result result){
        entityManager.persist(result);
        entityManager.close();
    }

    public void remove(Result result){
        entityManager.remove(result);
        entityManager.close();
    }

    public void update(Result result){
        entityManager.merge(result);
        entityManager.close();
    }

    public Result findById(long id){
        Result result = entityManager.find(Result.class, id);
        entityManager.close();
        return result;
    }

    public List<Result> findAllByUser(User user){
        List<Result> resultList = user.getResultList();
        return resultList;
    }
}
