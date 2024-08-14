package com.kevahwin.openapi_simple_storeapp.controller;

import static com.kevahwin.openapi_simple_storeapp.controller.CustomerController.BASE_URL;

import com.kevahwin.openapi_simple_storeapp.model.Customer;
import com.kevahwin.openapi_simple_storeapp.service.CustomerService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class CustomerController {

  public static final String BASE_URL = "/v1";
  private final CustomerService customerService;

  @GetMapping("/customers")
  public ResponseEntity<List<Customer>> getAllCustomers(){
    return ResponseEntity.ok(customerService.listCustomers());
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") UUID customerId){
    return ResponseEntity.ok(customerService.getCustomerById(customerId));
  }

}
