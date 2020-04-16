package project.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SignInController {

    @PreAuthorize("permitAll()")
    @GetMapping("/login")
    public ModelAndView getView(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        if (authentication == null){
            modelAndView.setViewName("signIn");
        } else {
            modelAndView.setViewName("redirect:/profile");
        }
        return modelAndView;
    }

}
