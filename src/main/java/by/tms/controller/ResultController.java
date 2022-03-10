package by.tms.controller;

import by.tms.entity.Result;
import by.tms.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class ResultController {

    ResultService resultService = new ResultService();
    Result result;

    @GetMapping
    public String calc() {
        return "calc";
    }

    @PostMapping
    public String calc(int firstNumber, int secondNumber, String operatorType, Model model) {
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("operatorType", operatorType);
        result = new Result(firstNumber, secondNumber, operatorType);
        resultService.calculation(result);
        model.addAttribute("messageCalculator", result.toString());
        return "redirect:/calc";  ///pages/calc.jsp
    }

}
