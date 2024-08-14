package com.kevahwin.openapi_simple_storeapp.controller;

import static com.kevahwin.openapi_simple_storeapp.controller.CustomerController.BASE_URL;

import com.kevahwin.openapi_simple_storeapp.model.Product;
import com.kevahwin.openapi_simple_storeapp.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BASE_URL)
@RequiredArgsConstructor
public class ProductController {

  private static final String BASE_URL = "/v1";
  private final ProductService productService;

  @GetMapping("/products")
  public ResponseEntity<List<Product>> getAllProducts(){
    return ResponseEntity.ok(productService.listProducts());
  }

  @GetMapping("/products/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable("productId") UUID id){
    return ResponseEntity.ok(productService.getProductById(id));
  }

}
