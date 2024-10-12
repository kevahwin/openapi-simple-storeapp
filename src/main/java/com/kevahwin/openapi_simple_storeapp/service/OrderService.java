package com.kevahwin.openapi_simple_storeapp.service;

import com.kevahwin.openapi_simple_storeapp.model.Order;
import java.util.List;
import java.util.UUID;

public interface OrderService {

  List<Order> listOrders();

  Order getOrderById(UUID id);
}

