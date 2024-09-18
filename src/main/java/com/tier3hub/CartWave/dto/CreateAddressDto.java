package com.tier3hub.CartWave.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressDto {

    @NotBlank(message = "Address Line 1 is required")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "state is required")
    private String state;

    @NotBlank(message = "postal code is required")
    private String postalCode;

    @NotBlank(message = "country is required")
    private String country;


}
