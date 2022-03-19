package by.tms.service;

import by.tms.entity.Result;
import by.tms.dao.inmemory.InMemoryResultsStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class InMemoryResultService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    InMemoryResultsStorage inMemoryResultsStorage = InMemoryResultsStorage.getInstance();

    public InMemoryResultService() {
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
        addResult(result);
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

    public void addResult(Result result) {
        inMemoryResultsStorage.addResult(result);
    }

    public ArrayList<String> getResults(int userId) {
        ArrayList<String> selectedResult = inMemoryResultsStorage.getAll(userId).stream()
                .map(Result::toString)
                .collect(Collectors.toCollection(ArrayList::new));
        return selectedResult;
    }

    public void deleteResults() {
        inMemoryResultsStorage.deleteAll();
    }
}






