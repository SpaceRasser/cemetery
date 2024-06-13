package ru.cemetery.controllers;

import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cemetery.exception.CustomersCollectionException;
import ru.cemetery.models.Customers;
import ru.cemetery.repository.CustomersRepository;
import ru.cemetery.services.CustomersService;

import java.util.List;

@RestController
public class CustomersController {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private CustomersService customersService;

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(){
        List<Customers> customers = customersService.getAllCustomers();
        return new ResponseEntity<>(customers, !customers.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customers customer){
        try {
            customersService.createCustomer(customer);
            return new ResponseEntity<Customers>(customer, HttpStatus.OK);
        }catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (CustomersCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getSingleCustomerById(@PathVariable("id") String id){
        try{
            return new ResponseEntity<>(customersService.getSingleCustomer(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Customers customer){
        try {
            customersService.updateCustomer(id, customer);
            return new ResponseEntity<>("Данные пользователя с идентификатором " + id + " успешно обновлены", HttpStatus.OK);
        }catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (CustomersCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id){
        try{
            customersService.deleteCustomer(id);
            return new ResponseEntity<>("Пользователь с идентификатором " + id + " успешно удалён!", HttpStatus.OK);
        } catch (CustomersCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
