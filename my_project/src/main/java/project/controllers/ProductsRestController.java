package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.dto.ResponseProductDto;
import project.dto.ResponseProductsDto;
import project.services.ProductService;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/products-management")
public class ProductsRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/pagination")
    public ResponseProductsDto getProducts(@RequestParam("page") Integer page,
                                        @RequestParam("size") Integer size,
                                        @RequestParam("sort") String sort)  {
        return ResponseProductsDto.builder()
                .data(productService.getProducts(page, size, sort))
                .build();
    }

    @GetMapping("/products")
    public ResponseProductsDto getAllProducts()  {
        return ResponseProductsDto.builder()
                .data(productService.findAll())
                .build();
    }

    @GetMapping("/products/{product-id}")
    public ResponseProductDto getProduct(@PathVariable("product-id") Long id) {
        return ResponseProductDto.builder()
                .data(productService.find(id).get())
                .build();
    }

}
