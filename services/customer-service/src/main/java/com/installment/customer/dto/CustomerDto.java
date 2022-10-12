package com.installment.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto extends BaseDto {


    @Size(max = 255)
    @NotEmpty(message = "name mandatory")
    private String name;
    @Size(max = 255)
    @NotEmpty(message = "phone mandatory")
    private String phone;
    @Size(max = 255)
    private String address;


}
