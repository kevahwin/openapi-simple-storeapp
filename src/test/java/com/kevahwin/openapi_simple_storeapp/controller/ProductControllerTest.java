package com.kevahwin.openapi_simple_storeapp.controller;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

@SpringBootTest
class ProductControllerTest extends BaseTest {

  @Test
  void testListAllProducts() throws Exception {
    mockMvc
        .perform(get(ProductController.BASE_URL + "/products").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()", greaterThan(0)));
  }

  @Test
  void testGetProductById() throws Exception {
    mockMvc.perform(
        get(ProductController.BASE_URL + "/products/{productId}", testProduct.getId())
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(testProduct.getId().toString()));
  }
}
