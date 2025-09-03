package com.example.cedar_data.repository;
import com.example.cedar_data.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByEinNumber(String einNumber);

    User getByPassword(String password);

}
