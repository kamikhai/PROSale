package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "/products_women", method = RequestMethod.GET)
    public ModelAndView getWomenPage(@RequestParam(required = false) Long store,
                                   @RequestParam(required = false) Integer select){
        return getProductsPage(store, select, Who.WOMAN).addObject("url","/products_women" );
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/products_men", method = RequestMethod.GET)
    public ModelAndView getMenPage(@RequestParam(required = false) Long store,
                                   @RequestParam(required = false) Integer select){
        return getProductsPage(store, select, Who.MAN).addObject("url","/products_men" );
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/products_kids", method = RequestMethod.GET)
    public ModelAndView getKidsPage(@RequestParam(required = false) Long store,
                                   @RequestParam(required = false) Integer select){
        return getProductsPage(store, select, Who.KIDS).addObject("url","/products_kids" );
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
        modelAndView.addObject("products", products);
        modelAndView.addObject("sites", sites);
        modelAndView.addObject("empty", "http://localhost:8080/files/empty.jpg");
        modelAndView.addObject("size", products.size());
        return modelAndView;
    }
}
