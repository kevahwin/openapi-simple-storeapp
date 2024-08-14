package com.kevahwin.openapi_simple_storeapp.repository;

import com.kevahwin.openapi_simple_storeapp.model.Product;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, UUID> {

}
