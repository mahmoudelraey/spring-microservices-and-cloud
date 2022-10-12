package com.installment.customer.service;

import com.installment.customer.dto.CustomerDto;
import com.installment.customer.model.Customer;
import com.installment.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private CustomerDto customerDto;
    private Customer customer;

    @BeforeEach
    public void setup() {
        customerDto = CustomerDto.builder()
                .name("Mahmoud Elrayei")
                .phone("01090047203")
                .address("cairo,egypt")
                .build();

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
    void create() {
        given(customerRepository.findFirstByName(customer.getName()))
                .willReturn(Optional.empty());

        given(customerRepository.save(customer)).willReturn(customer);

        System.out.println(customerRepository);
        System.out.println(customerService);

        // when -  action or the behaviour that we are going test
        CustomerDto savedCustomer = customerService.create(customerDto);

        System.out.println(savedCustomer);
        // then - verify the output
        assertThat(savedCustomer).isNotNull();
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }
}
