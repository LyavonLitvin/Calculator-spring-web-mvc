package by.tms.controller;

import by.tms.dao.jpa.JPAResultDAO;
import by.tms.entity.Result;
import by.tms.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class ResultController {

    @Autowired
    ResultService resultService;

    @Autowired
    JPAResultDAO jpaResultDAO;

    @GetMapping
    public String calc(@ModelAttribute("result") Result result) {
        return "calculator/calc";
    }

    @PostMapping
    public String result(@Valid @ModelAttribute("result") Result result, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "calculator/calc";
        }

        model.addAttribute("msgResult", resultService.getCalculationResult(result));
        resultService.save(session, result);
        return "calculator/calc";
    }
}
