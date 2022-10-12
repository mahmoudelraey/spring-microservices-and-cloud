package com.installment.customer.service;

import com.installment.common.dto.CustomerDto;
import com.installment.common.util.DateUtil;
import com.installment.customer.mapper.CustomerMapper;
import com.installment.customer.model.Customer;
import com.installment.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public List<CustomerDto> search(String fromDateString, String toDateString, String customerName) {
        Date fromDate = DateUtil.getStartDateForSearch(fromDateString);
        Date toDate = DateUtil.getEndDateForSearch(toDateString);
        List<Customer> customerList = customerRepository.search(fromDate, toDate, customerName == null || customerName.trim().isEmpty() ? null : customerName);
        return customerMapper.mapToCustomerDtoList(customerList);
    }

    public CustomerDto create(CustomerDto customerDto) {
        Optional<Customer> categoryList = customerRepository.findFirstByName(customerDto.getName());
        if (categoryList.isPresent()) {
            throw new RuntimeException("");
        }
        Customer createCustomer = customerMapper.mapToCustomer(customerDto);
        Customer dbCustomer = customerRepository.save(createCustomer);

        return customerMapper.mapToCustomerDto(dbCustomer);
    }

    public CustomerDto update(CustomerDto customerDto) {
        Customer updateCustomer = customerMapper.mapToCustomer(customerDto);

        Customer dbCustomer = customerRepository.save(updateCustomer);
        return customerMapper.mapToCustomerDto(dbCustomer);
    }


    public void delete(String customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        customerRepository.delete(customer);
    }

    public CustomerDto findById(String customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer != null && optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            return customerMapper.mapToCustomerDto(customer);
        }
        return null;
    }
}
