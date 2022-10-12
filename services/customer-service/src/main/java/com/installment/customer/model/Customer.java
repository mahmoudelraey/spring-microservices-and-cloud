package com.installment.customer.model;

import com.installment.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author G520991
 */
@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Customer.search", query = "select customer from Customer customer where (:fromDate is null or customer.creationDate >= :fromDate)" +
        " and (:toDate is null or customer.creationDate <= :toDate) " +
        " and (:customerName is null or customer.name = :customerName) order by customer.creationDate desc ")
public class Customer extends BaseEntity {

    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;


}
