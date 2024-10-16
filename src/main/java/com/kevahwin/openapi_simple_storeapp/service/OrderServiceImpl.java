package com.kevahwin.openapi_simple_storeapp.service;

import com.kevahwin.openapi_simple_storeapp.model.Order;
import com.kevahwin.openapi_simple_storeapp.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements
    OrderService {

  private final OrderRepository orderRepository;
  @Override
  public List<Order> listOrders() {
    return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Order getOrderById(UUID id) {
    return orderRepository.findById(id).orElseThrow();
  }
}
