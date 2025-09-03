package com.example.cedar_data.repository;
import com.example.cedar_data.model.Address;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    List<Address> findByStreetNumberAndStreetNameContainingIgnoreCase(String num, String name);
    List<Address> findByRouteNumber(String route);
}
