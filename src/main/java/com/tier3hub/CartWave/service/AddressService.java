package com.tier3hub.CartWave.service;

import com.tier3hub.CartWave.dto.AddressResponse;
import com.tier3hub.CartWave.dto.CreateAddressDto;
import com.tier3hub.CartWave.dto.UpdateAddressDto;

import java.util.List;

public interface AddressService {

    AddressResponse createAddress(CreateAddressDto createAddressDto);

    AddressResponse updateAddress(UpdateAddressDto updateAddressDto, Integer id);

    AddressResponse getAddressById(Integer id);

    List<AddressResponse> getAllAddress();

    void deleteAddress(Integer id);
}
