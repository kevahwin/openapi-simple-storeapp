package com.kevahwin.openapi_simple_storeapp.service;

import com.kevahwin.openapi_simple_storeapp.model.Product;
import com.kevahwin.openapi_simple_storeapp.repository.ProductRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements
    ProductService {

  private final ProductRepository productRepository;

  @Override
  public List<Product> listProducts() {
    return StreamSupport.stream(productRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Product getProductById(UUID id) {

    return productRepository.findById(id).orElseThrow();
  }
}
