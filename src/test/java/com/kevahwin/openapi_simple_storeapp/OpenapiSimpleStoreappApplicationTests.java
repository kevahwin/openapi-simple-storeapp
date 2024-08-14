package com.kevahwin.openapi_simple_storeapp;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import com.kevahwin.openapi_simple_storeapp.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenapiSimpleStoreappApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testDataLoad(){
		assertThat(customerRepository.count()).isGreaterThan(0L);
	}

}
