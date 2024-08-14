package com.kevahwin.openapi_simple_storeapp.service;

import com.kevahwin.openapi_simple_storeapp.model.Customer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

  List<Customer> listCustomers();

  Customer getCustomerById(UUID id);
}
