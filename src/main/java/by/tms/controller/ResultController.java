package by.tms.controller;

import by.tms.entity.Result;
import by.tms.service.InMemoryResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("calculator/calc")
public class ResultController {

    InMemoryResultService resultService = new InMemoryResultService();
    Result result;

    @GetMapping
    public String calc() {
        return "calculator/calc";
    }

    @PostMapping
    public String calc(@Valid @ModelAttribute("result") Result result, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "calculator/calc";
        }
        model.addAttribute("messageCalculator", resultService.getCalculationResult(result));
        return "calculator/calc";
    }

}
