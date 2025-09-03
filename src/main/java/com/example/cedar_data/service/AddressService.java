package com.example.cedar_data.service;
import com.example.cedar_data.dto.AddressDto;
import com.example.cedar_data.model.Address;
import com.example.cedar_data.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDto> routeResults(String route) {
        List<Address> addresses = addressRepository.findByRouteNumber(route);
        List<AddressDto> addressDto = new ArrayList<>();

        for(Address a : addresses) {
            addressDto.add(mapAddress(a));
        }
        return addressDto;
    }

    public List<AddressDto> searchResults(String num, String name) {
        // Fetch address from repository
        List<Address> addresses = addressRepository.findByStreetNumberAndStreetNameContainingIgnoreCase(num, name);

        if(addresses.isEmpty()) {
            throw new RuntimeException("Address " + num + " " + name + " not found.");
        }
        // Initialize new list
        List<AddressDto> addressDto = new ArrayList<>();
        // loop through addresses
        for(Address a : addresses) {
            // converts each address to dto and stores in list
            addressDto.add(mapAddress(a));
        }
        return addressDto;
    }

    public AddressDto mapAddress(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setStreetNumber(address.getStreetNumber());
        addressDto.setStreetName(address.getStreetName());
        addressDto.setCityName(address.getCityName());
        addressDto.setZipCode(address.getZipCode());
        addressDto.setGateCode(address.getGateCode());
        addressDto.setMailRoomCode(address.getMailRoomCode());
        addressDto.setLocker_code(address.getLocker_code());
        addressDto.setRouteNumber(address.getRouteNumber());

        return addressDto;
    }
}
