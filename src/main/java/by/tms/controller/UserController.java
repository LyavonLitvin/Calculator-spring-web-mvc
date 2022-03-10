package by.tms.controller;

import by.tms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/reg")
    public String reg(@ModelAttribute("newUser") User user, Model model){
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@Valid @ModelAttribute("newUser") User user, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Map<String, String> map = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            model.addAllAttributes(map);

            return "reg";
        }
        return "redirect:/test";
    }
}
