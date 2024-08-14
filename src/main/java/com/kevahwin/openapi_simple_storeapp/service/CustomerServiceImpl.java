package com.kevahwin.openapi_simple_storeapp.service;

import com.kevahwin.openapi_simple_storeapp.model.Customer;
import com.kevahwin.openapi_simple_storeapp.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements
    CustomerService {
  private final CustomerRepository customerRepository;

  @Override
  public List<Customer> listCustomers() {
    return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
        .toList();
  }

  @Override
  public Customer getCustomerById(UUID id) {
    return customerRepository.findById(id).orElseThrow();
  }

}
