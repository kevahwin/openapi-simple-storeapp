package com.kevahwin.openapi_simple_storeapp.seeder;

import com.kevahwin.openapi_simple_storeapp.model.Address;
import com.kevahwin.openapi_simple_storeapp.model.Category;
import com.kevahwin.openapi_simple_storeapp.model.Customer;
import com.kevahwin.openapi_simple_storeapp.model.Dimension;
import com.kevahwin.openapi_simple_storeapp.model.Image;
import com.kevahwin.openapi_simple_storeapp.model.Name;
import com.kevahwin.openapi_simple_storeapp.model.PaymentMethod;
import com.kevahwin.openapi_simple_storeapp.model.Product;
import com.kevahwin.openapi_simple_storeapp.repository.CustomerRepository;
import com.kevahwin.openapi_simple_storeapp.repository.ProductRepository;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

  private final CustomerRepository customerRepository;
  private final ProductRepository productRepository;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("I ran");

    Address address1 =
        Address.builder()
            .addressLine1("12 Adekoya Lane")
            .state("Alimosho")
            .city("Lagos")
            .zip("100287")
            .build();

    Customer customer1 =
        new Customer()
            .builder()
            .name(Name.builder().firstName("Kay").lastName("Evans").build())
            .shipToAddress(address1)
            .billToAddress(address1)
            .email("kevinahwin@apple.com")
            .phone("234907432")
            .paymentMethods(
                List.of(
                    PaymentMethod.builder()
                        .displayName("Kay Evans")
                        .cardNumber(1234578934)
                        .expiryMonth(8)
                        .expiryYear(2026)
                        .cvv(231)
                        .build()))
            .build();

    Product product1 =
        new Product()
            .builder()
            .description("iPhone 17")
            .price(BigDecimal.valueOf(779.23))
            .cost(BigDecimal.valueOf(23.47))
            .categories(
                List.of(Category.builder().category("Apple").description("Electronics").build()))
            .dimensions(
                List.of(Dimension.builder().unit("mm").length(112L).width(75L).height(7L).build()))
            .images(
                List.of(
                    Image.builder()
                        .url("www.apple.com/iphone17.png")
                        .altText(JsonNullable.of("Picture showing the UltraSlim iPhone Air"))
                        .build()))
            .build();

    Address address2 =
        Address.builder()
            .addressLine1("14 Ahwin Avenue")
            .state("Garki")
            .city("Abuja")
            .zip("900001")
            .build();

    Customer customer2 =
        new Customer()
            .builder()
            .name(Name.builder().firstName("Precious").lastName("Collins").build())
            .shipToAddress(address1)
            .billToAddress(address1)
            .email("kev@apple.com")
            .phone("567898021")
            .paymentMethods(
                List.of(
                    PaymentMethod.builder()
                        .displayName("Percy Collins")
                        .cardNumber(1234578652)
                        .expiryMonth(3)
                        .expiryYear(2025)
                        .cvv(149)
                        .build()))
            .build();

    Product product2 =
        new Product()
            .builder()
            .description("Google Duo AI Phone")
            .price(BigDecimal.valueOf(809.23))
            .cost(BigDecimal.valueOf(73.77))
            .categories(
                List.of(Category.builder().category("Google").description("Electronics").build()))
            .dimensions(
                List.of(Dimension.builder().unit("mm").length(124L).width(95L).height(9L).build()))
            .images(
                List.of(
                    Image.builder()
                        .url("www.google.com/duo-ai-phone.png")
                        .altText(JsonNullable.of("Picture showing the Google Duo AI Phone"))
                        .build()))
            .build();

    customerRepository.save(customer1);
    customerRepository.save(customer2);
    productRepository.save(product1);
    productRepository.save(product2);
  }
}
