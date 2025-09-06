package com.example.cedar_data.repository;
import com.example.cedar_data.model.AuthorizedEin;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AuthorizedEinRepository extends CrudRepository<AuthorizedEin, String> {

    Optional<AuthorizedEin> findByAuthorizedEin(String authorizedEin);
}
