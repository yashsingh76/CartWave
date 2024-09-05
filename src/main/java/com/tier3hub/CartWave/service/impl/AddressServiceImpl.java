package com.tier3hub.CartWave.service.impl;

import com.tier3hub.CartWave.dto.AddressResponse;
import com.tier3hub.CartWave.dto.CreateAddressDto;
import com.tier3hub.CartWave.dto.UpdateAddressDto;
import com.tier3hub.CartWave.entities.Address;
import com.tier3hub.CartWave.repositories.AddressRepo;
import com.tier3hub.CartWave.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AddressResponse createAddress(CreateAddressDto createAddressDto) {
        Address address = modelMapper.map(createAddressDto, Address.class);
        address.setAddressLine1(createAddressDto.getAddressLine1());
        return null;
    }

    @Override
    public AddressResponse updateAddress(UpdateAddressDto updateAddressDto, Integer id) {
        return null;
    }

    @Override
    public AddressResponse getAddressById(Integer id) {
        return null;
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        return List.of();
    }

    @Override
    public void deleteAddress(Integer id) {

    }
}
