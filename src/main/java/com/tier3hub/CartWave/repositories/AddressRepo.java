package com.tier3hub.CartWave.repositories;

import com.tier3hub.CartWave.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {

   // Address findByCountryAndStateAndCityAndPostalCode(String country, String state, String city, String postalCode);
}
