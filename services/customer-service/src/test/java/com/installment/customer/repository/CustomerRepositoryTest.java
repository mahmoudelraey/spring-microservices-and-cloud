package com.installment.customer.repository;

import com.installment.customer.model.Customer;
import lombok.AllArgsConstructor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.BDDMockito.given;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = Customer.builder()
                .name("Mahmoud Elrayei")
                .phone("01090047203")
                .address("cairo,egypt")
                .build();
    }

    @Test
    void search() {
    }

    @Test
    void findFirstByName() {
        // given
        customerRepository.save(customer);
        // when
        Customer foundCustomer = customerRepository.findFirstByName(customer.getName()).get();
        // then
        assertThat(foundCustomer).isNotNull();
    }
}
