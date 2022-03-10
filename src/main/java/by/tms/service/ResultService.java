package by.tms.service;


import by.tms.entity.Result;


public class ResultService {

    public ResultService() {
    }

    public Result calculation(Result result) {
        double resultNumber = 0;
        String controlLetter = result.getOperatorType();
        if (controlLetter.equals("+")) {
            resultNumber = sum(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("-")) {
            resultNumber = diff(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("*")) {
            resultNumber = multiple(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("/")) {
            resultNumber = divide(result.getFirstNumber(), result.getSecondNumber());
        }
        result.setResultNumber(resultNumber);
        return result;
    }

    public double diff(double a, double b) {
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

}





