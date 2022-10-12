package com.installment.customer.repository;

import com.installment.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {


    List<Customer> search(@Param("fromDate") Date fromDate,
                          @Param("toDate") Date toDate,
                          @Param("customerName") String customerName);

    Optional<Customer> findFirstByName(String customerName);

}
