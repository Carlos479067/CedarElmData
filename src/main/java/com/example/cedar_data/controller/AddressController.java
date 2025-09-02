package com.example.cedar_data.controller;
import com.example.cedar_data.dto.AddressDto;
import com.example.cedar_data.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/results")
    public List<AddressDto> searchResults(@RequestParam String num, @RequestParam String name) {
        return addressService.searchResults(num, name);
    }



}
