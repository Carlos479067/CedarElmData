package com.example.cedar_data.controller;
import com.example.cedar_data.dto.AddressDto;
import com.example.cedar_data.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/results")
    public List<AddressDto> searchResults(@RequestParam(required = false) String num, @RequestParam(required = false) String name, @RequestParam(required = false) String neighborhood) {
        return addressService.searchResults(num, name, neighborhood);
    }

    @GetMapping("/codes/{routeNumber}")
    public List<AddressDto> routeResults(@PathVariable String routeNumber) {
        return addressService.routeResults(routeNumber);
    }

    @GetMapping("/splits/{routeNumber}")
    public List<AddressDto> splitResults(@PathVariable String routeNumber) {
        return addressService.routeResults(routeNumber);
    }



}
