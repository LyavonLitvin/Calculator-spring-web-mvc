package by.tms.entity;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Result {
    private int resultId;
    private int resultCreatorId;
    @NotNull(message = Constants.MSG_ERROR_VALUE1_IS_NULL)
    private double firstNumber;

    @NotNull(message = Constants.MSG_ERROR_VALUE2_IS_NULL)
    private double secondNumber;

    @NotNull(message = Constants.MSG_ERROR_OPERATOR_IS_NULL)
    private String operatorType;
    private double resultNumber;
    private Timestamp resultUpdateDate;

    public Result() {
    }

    public Result(double firstNumber, double secondNumber, String operatorType) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
    }

    public Result(double firstNumber, double secondNumber, String operatorType, int userId) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultCreatorId = userId;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getResultCreatorId() {
        return resultCreatorId;
    }

    public void setResultCreatorId(int resultCreatorId) {
        this.resultCreatorId = resultCreatorId;
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

    public Timestamp getResultUpdateDate() {
        return resultUpdateDate;
    }

    public void setResultUpdateDate(Timestamp resultUpdateDate) {
        this.resultUpdateDate = resultUpdateDate;
    }

    @Override
    public String toString() {
        return " " + firstNumber + " " + operatorType + " " + secondNumber + " = " + resultNumber + " ";
    }


}
