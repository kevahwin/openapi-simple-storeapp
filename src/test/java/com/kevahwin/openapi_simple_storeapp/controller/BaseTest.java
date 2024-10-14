package com.kevahwin.openapi_simple_storeapp.controller;

import com.kevahwin.openapi_simple_storeapp.model.Customer;
import com.kevahwin.openapi_simple_storeapp.repository.CustomerRepository;
import com.kevahwin.openapi_simple_storeapp.repository.OrderRepository;
import com.kevahwin.openapi_simple_storeapp.repository.ProductRepository;
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

  public MockMvc mockMvc;

  Customer testCustomer;

  @BeforeEach
  void setUp(){

    mockMvc = MockMvcBuilders.webAppContextSetup(wac)
        .build();
    testCustomer = customerRepository.findAll().iterator().next();
  }

}
