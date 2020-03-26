package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.models.User;
import project.services.AuthService;

import javax.servlet.http.HttpSession;

@Controller
public class SignUpController {

    @Autowired
    private AuthService authService;


    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView getView(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        if (authentication != null){
            modelAndView.setViewName("redirect:/main");
        } else {
            modelAndView.setViewName("signUp");
        }
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ModelAndView getCourse(@RequestParam String name, @RequestParam String surname,
                                  @RequestParam String email, @RequestParam String password) {
        Long id = authService.signUp(User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build());
        ModelAndView modelAndView = new ModelAndView("redirect:/signIn");
        return modelAndView;
    }
}
