package by.tms.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @NotNull(message = Constants.MSG_ERROR_VALUE1_IS_NULL)
    private double firstNumber;

    @NotNull(message = Constants.MSG_ERROR_VALUE2_IS_NULL)
    private double secondNumber;

    @NotNull(message = Constants.MSG_ERROR_OPERATOR_IS_NULL)
    private String operatorType;
    private double resultNumber;

    public Result() {
    }

    public Result(double firstNumber, double secondNumber, String operatorType) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
    }

    public Result(double firstNumber, double secondNumber, String operatorType, User user) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.user = user;
    }

    public Result(long id, User user, double firstNumber, double secondNumber, String operatorType, double resultNumber) {
        this.id = id;
        this.user = user;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
    }

    public Result(User user, double firstNumber, double secondNumber, String operatorType, double resultNumber) {
        this.user = user;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
    }

    public Result(double firstNumber, double secondNumber, String operatorType, double resultNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public double getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(double resultNumber) {
        this.resultNumber = resultNumber;
    }

    @Override
    public String toString() {
        return " " + id + " " + firstNumber + " " + operatorType + " " + secondNumber + " = " + resultNumber + " ";
    }


}
