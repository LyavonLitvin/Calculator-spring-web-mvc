package by.tms.service;

import by.tms.dao.jpa.JPAResultDAO;
import by.tms.dao.jpa.JPAUserDAO;
import by.tms.entity.Result;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Component
public class ResultService {

    @Autowired
    JPAResultDAO jpaResultDAO;

    @Autowired
    JPAUserDAO jpaUserDAO;

    public ResultService() {
    }

    public Result getCalculationResult(Result result) {
        double resultNumber = 0;
        String controlLetter = result.getOperatorType();
        if (controlLetter.equals("+")) {
            resultNumber = sum(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("-")) {
            resultNumber = subtract(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("*")) {
            resultNumber = multiple(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("/")) {
            resultNumber = divide(result.getFirstNumber(), result.getSecondNumber());
        }
        result.setResultNumber(resultNumber);
        return result;
    }

    public double subtract(double a, double b) {
        return (a - b);
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double multiple(double a, double b) {
        return a * b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public void save(HttpSession session, Result result) {
        User user = (User) session.getAttribute("user");
        List<Result> resultList = user.getResultList();
        resultList.add(result);
        user.setResultList(resultList);
        jpaUserDAO.update(user);
    }
}







