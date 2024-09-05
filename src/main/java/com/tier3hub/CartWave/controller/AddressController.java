package com.tier3hub.CartWave.controller;

import com.tier3hub.CartWave.dto.AddressResponse;
import com.tier3hub.CartWave.dto.CreateAddressDto;
import com.tier3hub.CartWave.dto.UpdateAddressDto;
import com.tier3hub.CartWave.service.AddressService;
import com.tier3hub.CartWave.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addresses")
    public ResponseEntity<Object> createAddress(@RequestBody CreateAddressDto createAddressDto){
        AddressResponse address = addressService.createAddress(createAddressDto);
        return ResponseHandler.generateResponse("Address is created successfully", HttpStatus.CREATED, address);
    }

    @PutMapping("/update/addresses/{id}")
    public ResponseEntity<Object> updateAddress(@RequestBody UpdateAddressDto updateAddressDto,@PathVariable Integer id){
        AddressResponse address = addressService.updateAddress(updateAddressDto,id);
        return ResponseHandler.generateResponse("Address is updated successfully",HttpStatus.OK,address);
    }

    @GetMapping("/addresses/get/{id}")
    public ResponseEntity<Object> getAddressById(@PathVariable Integer id){
        AddressResponse address = addressService.getAddressById(id);
        return ResponseHandler.generateResponse("Address is fetched successfully",HttpStatus.FOUND,address);
    }

    @GetMapping("/addresses")
    public ResponseEntity<Object> getAddresses(){
        List<AddressResponse> address = addressService.getAllAddress();
        return ResponseHandler.generateResponse("Addresses are fetched successfully",HttpStatus.FOUND,address);
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseHandler.generateResponse("Address are deleted successfully",HttpStatus.OK,null);
    }
}
