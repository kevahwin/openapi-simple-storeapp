package com.kevahwin.openapi_simple_storeapp.seeder;

import com.kevahwin.openapi_simple_storeapp.model.Address;
import com.kevahwin.openapi_simple_storeapp.model.Customer;
import com.kevahwin.openapi_simple_storeapp.model.Name;
import com.kevahwin.openapi_simple_storeapp.model.PaymentMethod;
import com.kevahwin.openapi_simple_storeapp.repository.CustomerRepository;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

  private final CustomerRepository customerRepository;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("I ran");

    Address address1 = Address.builder().addressLine1("12 Adekoya Lane")
        .state("Alimosho")
        .city("Lagos")
        .zip("100287")
        .build();

    Customer customer1 = new Customer().builder().name(Name.builder().firstName("Kay").lastName("Evans").build())
        .shipToAddress(address1)
        .billToAddress(address1)
        .email("kevinahwin@apple.com")
        .phone("234907432")
        .paymentMethods(List.of(PaymentMethod.builder()
                .displayName("Kay Evans")
            .cardNumber(1234578934)
            .expiryMonth(8)
            .expiryYear(2026)
            .cvv(231).build()))
        .build();

    Address address2 = Address.builder().addressLine1("14 Ahwin Avenue")
        .state("Garki")
        .city("Abuja")
        .zip("900001")
        .build();

    Customer customer2 = new Customer().builder().name(Name.builder().firstName("Precious").lastName("Collins").build())
        .shipToAddress(address1)
        .billToAddress(address1)
        .email("kev@apple.com")
        .phone("567898021")
        .paymentMethods(List.of(PaymentMethod.builder()
            .displayName("Percy Collins")
            .cardNumber(1234578652)
            .expiryMonth(3)
            .expiryYear(2025)
            .cvv(149).build()))
        .build();

    customerRepository.save(customer1);
    customerRepository.save(customer2);
  }
}
