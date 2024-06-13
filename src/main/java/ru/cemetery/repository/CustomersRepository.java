package ru.cemetery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ru.cemetery.models.Customers;

import java.util.Optional;

@Repository
public interface CustomersRepository extends MongoRepository<Customers, String> {

    @Query("{'phone': ?0}")
    Optional<Customers> findByCustomer(String customer);
}
