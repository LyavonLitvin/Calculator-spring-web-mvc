package by.tms.controller;

import by.tms.dao.jpa.JPAUserDAO;
import by.tms.dto.UserDTO;
import by.tms.entity.User;
import by.tms.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private JPAUserDAO jpaUserDAO;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/")
    public String index(){

        //init test data users
        System.out.println(jpaUserDAO.findById(1));
        if (jpaUserDAO.findById(1) == null) {

            User user = new User();
            user.setLogin("admin");
            user.setPassword("admin");
            user.setEmail("admin@gmail.com");
            jpaUserDAO.save(user);
        }

        return "user/index";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", jpaUserDAO.findAll());
        return "user/users";
    }

    @GetMapping("user/{id}")
    public String showByIdUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", jpaUserDAO.findById(id));
        return "user/user";
    }


    @GetMapping("user/reg")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/reg";
    }

    @PostMapping("user/reg")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/reg";
        }

        jpaUserDAO.save(user);
        return "redirect:/";
    }

    @GetMapping("user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("user/login")
    public String showLoginPage(@ModelAttribute("user") User user) {
        return "user/login";
    }

    @PostMapping("user/login")
    public String login(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult bindingResult,
                        HttpSession session, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/login";
        } else if (userValidator.isValid(userDTO))  {
            session.setAttribute("user", jpaUserDAO.findByLogin(userDTO.getLogin()));
        } else  {
            model.addAttribute("msgerror", "invalid user/login");
            return "user/login";
        }

        return "user/index";
    }

    @GetMapping("user/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", jpaUserDAO.findById(id));
        return "user/edit";
    }

    @PatchMapping("user/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, @PathVariable("id") long id,
                         HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "user/edit";
        }

        session.setAttribute("user", user);
        jpaUserDAO.update(user);
        return "user/index";
    }

    @DeleteMapping("user/{id}")
    public String delete(@PathVariable("id") long id, HttpSession session) {
        User user = jpaUserDAO.findById(id);
        jpaUserDAO.remove(user);
        session.invalidate();
        return "user/index";
    }


}
