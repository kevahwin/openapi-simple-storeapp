package com.kevahwin.openapi_simple_storeapp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

@SpringBootTest
class OrderControllerTest extends BaseTest {

  @Test
  void testGetAllOrders() throws Exception {
    mockMvc
        .perform(get(OrderController.BASE_URL + "/orders").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()", greaterThan(0)));
  }

  @Test
  void testGetOrderById() throws Exception {
    mockMvc.perform(
            get(OrderController.BASE_URL + "/orders/{orderId}", testOrder.getId())
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(testOrder.getId().toString()));
  }
}
