package com.kevahwin.openapi_simple_storeapp.service;

import com.kevahwin.openapi_simple_storeapp.model.Product;
import java.util.List;
import java.util.UUID;

public interface ProductService {

  List<Product> listProducts();

  Product getProductById(UUID id);
}
