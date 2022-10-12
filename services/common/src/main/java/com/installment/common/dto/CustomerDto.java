package com.installment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
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
