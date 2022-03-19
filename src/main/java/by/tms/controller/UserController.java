package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.InMemoryUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private InMemoryUsersService inMemoryUsersService;

    @Autowired
    public UserController(InMemoryUsersService inMemoryUsersService) {
        this.inMemoryUsersService = inMemoryUsersService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", inMemoryUsersService.getUsers());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String showByIdUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", inMemoryUsersService.getByUserId(id));
        return "user/user";
    }


    @GetMapping("/reg")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/reg";
    }

    @PostMapping("/reg")
    public String create(@Valid @ModelAttribute("user") User user, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user/reg";
        }

        inMemoryUsersService.addUser(user);
        return "redirect:/user";
    }
}
