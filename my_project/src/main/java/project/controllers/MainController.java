package project.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView getMainPage(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        modelAndView.addObject("auth", authentication.isAuthenticated()&&!authentication.getName().equals("anonymousUser"));
        modelAndView.addObject("auth", authentication != null ? true : false);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
