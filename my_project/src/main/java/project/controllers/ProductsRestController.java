package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import project.dto.ResponseProductDto;
import project.dto.ResponseProductsDto;
import project.models.Product;
import project.models.Who;
import project.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products-management")
@PreAuthorize("permitAll()")
public class ProductsRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/pagination")
    public ResponseProductsDto getProducts(@RequestParam("page") Integer page,
                                           @RequestParam("size") Integer size,
                                           @RequestParam("sort") String sort) {
        return ResponseProductsDto.builder()
                .data(productService.getProducts(page, size, sort))
                .build();
    }

    @GetMapping("/products")
    public ResponseEntity<ResponseProductsDto> getAllProducts() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return ResponseEntity.ok(ResponseProductsDto.builder()
                .data(productService.findAll())
                .build());
//        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/products/{who}")
    public ResponseEntity<ResponseProductsDto> getAllProductsForSomeone(@PathVariable("who") Who who,
                                                                        @RequestParam(required = false) Integer sort) {
        if (sort != null) {
            if (sort == 2) {
                return ResponseEntity.ok(ResponseProductsDto.builder()
                        .data(productService.findAllByWhoAndSort(false, who))
                        .build());
            } else {
                return ResponseEntity.ok(ResponseProductsDto.builder()
                        .data(productService.findAllByWhoAndSort(true, who))
                        .build());
            }
        } else {
            return ResponseEntity.ok(ResponseProductsDto.builder()
                    .data(productService.findAllByWho(who))
                    .build());
        }
//        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/products/{who}/{store-id}")
    public ResponseEntity<ResponseProductsDto> getAllProductsForSomeoneFromSomeStore(@PathVariable("who") Who who,
                                                                                     @PathVariable("store-id") Long storeId,
                                                                                     @RequestParam(required = false) Integer sort) {
        if (sort != null) {
            if (sort == 2) {
                return ResponseEntity.ok(ResponseProductsDto.builder()
                        .data(productService.findAllByWhoAndStoreAndSort(false, who, storeId))
                        .build());
            } else {
                return ResponseEntity.ok(ResponseProductsDto.builder()
                        .data(productService.findAllByWhoAndStoreAndSort(true, who, storeId))
                        .build());
            }
        } else {
            return ResponseEntity.ok(ResponseProductsDto.builder()
                    .data(productService.findAllByStoreAndWho(storeId, who))
                    .build());
        }
//        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/product/{product-id}")
    public ResponseProductDto getProduct(@PathVariable("product-id") Long id) {
        return ResponseProductDto.builder()
                .data(productService.find(id).get())
                .build();
    }

}
