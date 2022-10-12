package com.installment.customer.controller;

import com.installment.customer.dto.CustomerDto;
import com.installment.customer.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by mawlana .
 */
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerControllerImpl {

    private final CustomerServiceImpl customerService;


    @PostMapping
    public CustomerDto create(@Valid @RequestBody CustomerDto customer) {
        return customerService.create(customer);
    }

    @PutMapping
    public CustomerDto update(@Valid @RequestBody CustomerDto customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String customerId) {
        customerService.delete(customerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable(name = "id") String customerId) {
        return customerService.findById(customerId);
    }


    @GetMapping("/search")
    public List<CustomerDto> search(@DateTimeFormat(pattern = "yyyy-mm-dd") @Valid @RequestParam(name = "fromDate", required = false) String fromDate,
                                    @DateTimeFormat(pattern = "yyyy-mm-dd") @Valid @RequestParam(name = "toDate", required = false) String toDate,
                                    @RequestParam(name = "customerName", required = false) String customerName) {
        return customerService.search(fromDate, toDate, customerName);
    }

}
