package by.tms.controller;

import by.tms.dao.hibernate.HibernateResultsDAO;

import by.tms.entity.Result;
import by.tms.entity.User;
import by.tms.service.HibernateResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.util.List;

@Component
@RequestMapping("calculator/history")
public class HistoryController {

    @Autowired
    HibernateResultService hibernateResultService;

    @Autowired
    HibernateResultsDAO hibernateResultsDAO;


    @GetMapping("calculator/history")
    public String history(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        } else {
            List<Result> resultList = hibernateResultsDAO.findAllByUser((User) session.getAttribute("user"));
            model.addAttribute("resultsHistory", resultList);
            return "calculator/history";
        }
    }
}
