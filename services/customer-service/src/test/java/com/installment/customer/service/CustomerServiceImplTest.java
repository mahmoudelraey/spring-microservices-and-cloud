package com.installment.customer.service;

import com.installment.customer.dto.CustomerDto;
import com.installment.customer.mapper.CustomerMapper;
import com.installment.customer.model.Customer;
import com.installment.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    private ModelMapper modelMapper;

    private CustomerMapper customerMapper;


    private CustomerServiceImpl customerService;

    private CustomerDto customerDto;
    private Customer customer;

    @BeforeEach
    public void setup() {
        modelMapper = new ModelMapper();
        customerMapper = new CustomerMapper(modelMapper);
        customerService = new CustomerServiceImpl(customerRepository, customerMapper);


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
        // given
        given(customerRepository.save(customer)).willReturn(customer);

        // when -  action or the behaviour that we are going test
        CustomerDto savedCustomer = customerService.create(customerDto);

        // then - verify the output
        assertThat(savedCustomer).isNotNull();
    }

    @Test
    void update() {
        // given
        given(customerRepository.save(customer)).willReturn(customer);

        // then
        String name = "Ali";
        String phone = "01009540069";


        customerDto.setName(name);
        customerDto.setPhone(phone);
        customerDto.setId(customer.getId());

        CustomerDto updatedCustomerDto = customerService.update(customerDto);

        // when
        assertThat(updatedCustomerDto.getName()).isEqualTo(name);
        assertThat(updatedCustomerDto.getPhone()).isEqualTo(phone);
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }
}
