package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.services.SiteService;

@Controller
public class MainController {

    @Autowired
    private SiteService siteService;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView getMainPage(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auth", authentication != null ? true : false);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
