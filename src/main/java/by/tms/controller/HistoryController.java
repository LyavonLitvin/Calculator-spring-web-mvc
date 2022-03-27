package by.tms.controller;

import by.tms.dao.jpa.JPAResultDAO;

import by.tms.entity.Result;
import by.tms.entity.User;
import by.tms.service.ResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.util.List;

@Component
@RequestMapping("calc")
public class HistoryController {

    @Autowired
    ResultService resultService;

    @Autowired
    JPAResultDAO jpaResultsDAO;


    @GetMapping("/history")
    public String history(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        } else {
            List<Result> resultList = jpaResultsDAO.findAllByUser((User) session.getAttribute("user"));
            model.addAttribute("resultsHistory", resultList);
            return "calculator/history";
        }
    }
}
