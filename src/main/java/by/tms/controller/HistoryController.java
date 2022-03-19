package by.tms.controller;

import by.tms.dao.inmemory.InMemoryResultsStorage;
import by.tms.entity.Result;
import by.tms.service.InMemoryResultService;
import by.tms.service.InMemoryUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Component
@RequestMapping("/history")
public class HistoryController {



//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        InMemoryResultService inMemoryResultService = new InMemoryResultService();
//        InMemoryUsersService inMemoryUsersService = new InMemoryUsersService();
//        ArrayList<Result> results = resultService.getResults(userService.getUserId((String) session.getAttribute("username")));
//        req.setAttribute("results", results);
//        logger.info("Show history of results");
//        req.getServletContext().getRequestDispatcher(Constants.HISTORY_LINK_JSP).forward(req, resp);
//    }
//
//    getResults(int userId)
}
