package com.installment.customer.mapper;

import com.installment.common.dto.CustomerDto;
import com.installment.customer.model.Customer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CustomerMapper {

    private final ModelMapper modelMapper;


    public Customer mapToCustomer(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }

    public CustomerDto mapToCustomerDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    public List<Customer> mapToCustomerList(List<CustomerDto> customerDtoList) {
        return customerDtoList.stream().map(customerDto -> mapToCustomer(customerDto)).collect(Collectors.toList());
    }

    public List<CustomerDto> mapToCustomerDtoList(List<Customer> customerList) {
        return customerList.stream().map(customer -> mapToCustomerDto(customer)).collect(Collectors.toList());
    }
}
