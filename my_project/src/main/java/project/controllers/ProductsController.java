package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.models.Product;
import project.models.Site;
import project.models.Who;
import project.services.ProductService;
import project.services.SiteService;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    ProductService productService;
    @Autowired
    SiteService siteService;

    @PreAuthorize("permitAll()")
    @GetMapping("/products_women")
    public ModelAndView getWomenPage(@RequestParam(required = false) Long store,
                                   @RequestParam(required = false) Integer select){
        return getProductsPage(store, select, Who.WOMAN).addObject("url","/products_women" )
                .addObject("who",Who.WOMAN);

    }

    @PreAuthorize("permitAll()")
    @GetMapping("/products_men")
    public ModelAndView getMenPage(@RequestParam(required = false) Long store,
                                   @RequestParam(required = false) Integer select){
        return getProductsPage(store, select, Who.MAN).addObject("url","/products_men" )
                .addObject("who",Who.MAN);

    }

    @PreAuthorize("permitAll()")
    @GetMapping("/products_kids")
    public ModelAndView getKidsPage(@RequestParam(required = false) Long store,
                                   @RequestParam(required = false) Integer select){
        return getProductsPage(store, select, Who.KIDS).addObject("url","/products_kids" )
                .addObject("who",Who.KIDS);
    }


    public ModelAndView getProductsPage(@RequestParam(required = false) Long store,
                                        @RequestParam(required = false) Integer select, Who who) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        List<Site> sites = siteService.findAll();
        List<Product> products;
        if (store != null) {
            products = productService.findAllByStoreAndWho(store, who);
        } else if (select != null){
            if (select == 2){
                products = productService.findAllByWhoAndSort(false, who);
            } else {
                products = productService.findAllByWhoAndSort(true, who);
            }
        } else {
            products = productService.findAllByWho(who);
        }
//        modelAndView.addObject("products", products);
        modelAndView.addObject("sites", sites);
        modelAndView.addObject("first", true);
        modelAndView.addObject("empty", "http://localhost:8080/files/empty.jpg");
        return modelAndView;
    }
}
