package com.kevahwin.openapi_simple_storeapp.controller;

import com.kevahwin.openapi_simple_storeapp.model.Customer;
import com.kevahwin.openapi_simple_storeapp.model.Order;
import com.kevahwin.openapi_simple_storeapp.model.Product;
import com.kevahwin.openapi_simple_storeapp.repository.CustomerRepository;
import com.kevahwin.openapi_simple_storeapp.repository.OrderRepository;
import com.kevahwin.openapi_simple_storeapp.repository.ProductRepository;
import jakarta.servlet.Filter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class BaseTest {

  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  ProductRepository productRepository;

  @Autowired
  OrderRepository orderRepository;
  @Autowired
  WebApplicationContext wac;

  @Autowired
  Filter validationFilter;

  public MockMvc mockMvc;

  Customer testCustomer;
  Product testProduct;
  Order testOrder;

  @BeforeEach
  void setUp(){

    mockMvc = MockMvcBuilders.webAppContextSetup(wac)

        .build();
    testCustomer = customerRepository.findAll().iterator().next();
    testProduct = productRepository.findAll().iterator().next();
    testOrder = orderRepository.findAll().iterator().next();
  }

}
