package project.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SignInController {

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView getView(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        if (authentication != null){
            modelAndView.setViewName("redirect:/profile");
        } else {
            modelAndView.setViewName("signIn");
        }
        return modelAndView;
    }

}
