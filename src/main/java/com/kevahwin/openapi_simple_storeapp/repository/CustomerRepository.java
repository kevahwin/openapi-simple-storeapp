package com.kevahwin.openapi_simple_storeapp.repository;

import com.kevahwin.openapi_simple_storeapp.model.Customer;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
