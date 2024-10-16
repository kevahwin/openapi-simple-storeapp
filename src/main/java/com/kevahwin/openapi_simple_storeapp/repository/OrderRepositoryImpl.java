package com.kevahwin.openapi_simple_storeapp.repository;

import com.kevahwin.openapi_simple_storeapp.model.Order;
import com.kevahwin.openapi_simple_storeapp.model.OrderCustomer;
import com.kevahwin.openapi_simple_storeapp.model.OrderLine;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements
    OrderRepository {

  private final Map<UUID, Order> entityMap = new HashMap<>();

  @Override
  public <S extends Order> S save(S entity) {
    UUID id = UUID.randomUUID();
    Order.OrderBuilder orderBuilder = Order.builder();
    orderBuilder.id(id);


    if(entity.getCustomer() != null){
      orderBuilder.customer(
          OrderCustomer.builder()
              .id(UUID.randomUUID())
              .name(entity.getCustomer().getName())
              .phone(entity.getCustomer().getPhone())
              .email(entity.getCustomer().getEmail())
              .billToAddress(entity.getCustomer().getBillToAddress())
              .shipToAddress(entity.getCustomer().getShipToAddress())
              .selectedPaymentMethod(entity.getCustomer().getSelectedPaymentMethod())
              .build());
    }

    if(entity.getOrderStatus() != null){
      orderBuilder.orderStatus(entity.getOrderStatus());
    }

    if(entity.getOrderLines() != null){
      orderBuilder.orderLines(entity.getOrderLines()
          .stream()
          .map(orderLine -> OrderLine.builder()
              .id(UUID.randomUUID())
              .product(orderLine.getProduct()) //Might cause Null pointer error
              .orderQuantity(orderLine.getOrderQuantity())
              .shipQuantity(orderLine.getShipQuantity())
              .dateCreated(OffsetDateTime.now())
              .dateModified(OffsetDateTime.now())
              .build())
          .collect(Collectors.toList()));
    }

    Order order = orderBuilder
        .shipmentInfo("Amazon Prime Same Day Delivery")
        .build();

    entityMap.put(id, order);

    return (S) order;
  }

  @Override
  public <S extends Order> Iterable<S> saveAll(Iterable<S> entities) {

    return StreamSupport.stream(entities.spliterator(), false)
        .map(this::save)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Order> findById(UUID uuid) {
    return Optional.of(entityMap.get(uuid));
  }

  @Override
  public boolean existsById(UUID uuid) {
    return entityMap.get(uuid) != null;
  }

  @Override
  public Iterable<Order> findAll() {
    return entityMap.values();
  }

  @Override
  public Iterable<Order> findAllById(Iterable<UUID> uuids) {
    return StreamSupport.stream(uuids.spliterator(), false)
        .map(this::findById)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());
  }

  @Override
  public long count() {
    return entityMap.size();
  }

  @Override
  public void deleteById(UUID uuid) {
    entityMap.remove(uuid);
  }

  @Override
  public void delete(Order entity) {
    entityMap.remove(entity.getId());
  }

  @Override
  public void deleteAllById(Iterable<? extends UUID> uuids) {
    uuids.forEach(this::deleteById);
  }

  @Override
  public void deleteAll(Iterable<? extends Order> entities) {
    entities.forEach(this::delete);
  }

  @Override
  public void deleteAll() {
    entityMap.clear();
  }
}
