package ru.cemetery.services;

import jakarta.validation.ConstraintViolationException;
import ru.cemetery.exception.CustomersCollectionException;
import ru.cemetery.models.Customers;

import java.util.List;

public interface CustomersService {

    public void createCustomer(Customers customers) throws ConstraintViolationException, CustomersCollectionException;

    public List<Customers> getAllCustomers();

    public Customers getSingleCustomer(String id) throws CustomersCollectionException;

    public void updateCustomer(String id, Customers customers) throws CustomersCollectionException;

    public void deleteCustomer(String id) throws CustomersCollectionException;
}
