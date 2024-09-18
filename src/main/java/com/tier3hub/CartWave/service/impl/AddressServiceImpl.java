package com.tier3hub.CartWave.service.impl;

import com.tier3hub.CartWave.dto.AddressResponse;
import com.tier3hub.CartWave.dto.CreateAddressDto;
import com.tier3hub.CartWave.dto.UpdateAddressDto;
import com.tier3hub.CartWave.entities.Address;
import com.tier3hub.CartWave.exception.ResourceNotFoundException;
import com.tier3hub.CartWave.repositories.AddressRepo;
import com.tier3hub.CartWave.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AddressResponse createAddress(CreateAddressDto createAddressDto) {
        Address address = modelMapper.map(createAddressDto,Address.class);
        address.setCreatedAt(LocalDateTime.now());
        Address save = addressRepo.save(address);
        return modelMapper.map(save,AddressResponse.class);
    }

    @Override
    public AddressResponse updateAddress(UpdateAddressDto updateAddressDto, Integer id) {
        Address address = addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not found"));
        address.setAddressLine1(updateAddressDto.getAddressLine1());
        address.setAddressLine2(updateAddressDto.getAddressLine2());
        address.setCity(updateAddressDto.getCity());
        address.setState(updateAddressDto.getState());
        address.setPostalCode(updateAddressDto.getPostalCode());
        address.setCountry(updateAddressDto.getCountry());
        address.setUpdatedAt(LocalDateTime.now());
        Address save = addressRepo.save(address);
        return modelMapper.map(save,AddressResponse.class);
    }

    @Override
    public AddressResponse getAddressById(Integer id) {
        Address address = addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not found"));
        return modelMapper.map(address,AddressResponse.class);
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        List<Address> address = addressRepo.findAll();
        return address.stream().map(address1 -> modelMapper.map(address1,AddressResponse.class)).toList();
    }

    @Override
    public void deleteAddress(Integer id) {
        Address address = addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not found"));
        addressRepo.delete(address);
    }
}
