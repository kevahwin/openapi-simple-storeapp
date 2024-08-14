package com.kevahwin.openapi_simple_storeapp.repository;

import com.kevahwin.openapi_simple_storeapp.model.Category;
import com.kevahwin.openapi_simple_storeapp.model.Dimension;
import com.kevahwin.openapi_simple_storeapp.model.Image;
import com.kevahwin.openapi_simple_storeapp.model.Product;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements
    ProductRepository {

  private final Map<UUID, Product> entityMap = new HashMap<>();

  @Override
  public <S extends Product> S save(S entity) {
    UUID id = UUID.randomUUID();
    Product.ProductBuilder builder = Product.builder();
    builder.id(id);

    if(entity.getDescription() != null){
      builder.description(entity.getDescription());
    }

    if(entity.getImages() != null){
      builder.images(entity.getImages()
          .stream()
          .map(image -> Image.builder()
              .id(UUID.randomUUID())
              .altText(image.getAltText_JsonNullable())
              .url(image.getUrl())
              .dateCreated(OffsetDateTime.now())
              .dateModified(OffsetDateTime.now()).build())
          .collect(Collectors.toList()));
    }
    if(entity.getCategories() != null){
      builder.categories(entity.getCategories()
          .stream()
          .map(category -> Category.builder()
              .id(UUID.randomUUID())
              .category(category.getCategory())
              .dateCreated(OffsetDateTime.now())
              .dateModified(OffsetDateTime.now())
              .description(category.getDescription()).build())
          .collect(Collectors.toList()));
    }

    if(entity.getDimensions() != null){
      builder.dimensions(entity.getDimensions()
          .stream()
          .map(dimension -> Dimension.builder()
              .width(dimension.getWidth())
              .height(dimension.getHeight())
              .length(dimension.getLength())
              .unit(dimension.getUnit())
              .build()
          ).collect(Collectors.toList())
      );
    }

    if(entity.getPrice() != null){
      builder.price(entity.getPrice());
    }

    if(entity.getCost() != null){
      builder.cost(entity.getCost());
    }

    Product product = builder.build();
    entityMap.put(id, product);
    return (S) product;
  }

  @Override
  public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {

    return StreamSupport.stream(entities.spliterator(), false)
        .map(this::save)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Product> findById(UUID uuid) {
    return Optional.of(entityMap.get(uuid));
  }

  @Override
  public boolean existsById(UUID uuid) {
    return entityMap.get(uuid) != null;
  }

  @Override
  public Iterable<Product> findAll() {
    return entityMap.values();
  }

  @Override
  public Iterable<Product> findAllById(Iterable<UUID> uuids) {
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
  public void delete(Product entity) {
    entityMap.remove(entity.getId());
  }

  @Override
  public void deleteAllById(Iterable<? extends UUID> uuids) {
    uuids.forEach(this::deleteById);
  }

  @Override
  public void deleteAll(Iterable<? extends Product> entities) {
    entities.forEach(this::delete);
  }

  @Override
  public void deleteAll() {
    entityMap.clear();
  }
}
