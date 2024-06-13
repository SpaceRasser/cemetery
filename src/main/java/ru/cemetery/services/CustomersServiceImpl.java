package ru.cemetery.services;

import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cemetery.exception.CustomersCollectionException;
import ru.cemetery.models.Customers;
import ru.cemetery.repository.CustomersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService{

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public void createCustomer(Customers customers) throws ConstraintViolationException, CustomersCollectionException {
        Optional<Customers> customersOptional = customersRepository.findByCustomer(customers.getPhone());
        if(customersOptional.isPresent()){
            throw new CustomersCollectionException(CustomersCollectionException.CustomersAlreadyExists());
        }else {
            customersRepository.save(customers);
        }
    }

    @Override
    public List<Customers> getAllCustomers() {
        List<Customers> customers = customersRepository.findAll();
        if (!customers.isEmpty()) {
            return customers;
        } else {
            return new ArrayList<Customers>();
        }
    }

    @Override
    public Customers getSingleCustomer(String id) throws CustomersCollectionException {
        Optional<Customers> optionalCustomers = customersRepository.findById(id);
        if(!optionalCustomers.isPresent()){
            throw new CustomersCollectionException(CustomersCollectionException.NotFoundException(id));
        }else {
            return optionalCustomers.get();
        }
    }

    @Override
    public void updateCustomer(String id, Customers customers) throws CustomersCollectionException {
        Optional<Customers> customerWithId = customersRepository.findById(id);
        Optional<Customers> customerWithPhone = customersRepository.findById(customers.getPhone());

        if(customerWithId.isPresent()){

            if(customerWithPhone.isPresent() && !customerWithPhone.get().getId().equals(id)){
                throw new CustomersCollectionException(CustomersCollectionException.CustomersAlreadyExists());
            }

            Customers customerToUpdate = customerWithId.get();

            customerToUpdate.setName(customers.getName());
            customerToUpdate.setLastName(customers.getLastName());
            customerToUpdate.setPatronymicName(customers.getPatronymicName());
            customerToUpdate.setBirthDate(customers.getBirthDate());
            customerToUpdate.setPhone(customers.getPhone());
            customerToUpdate.setEmail(customers.getEmail());
            customersRepository.save(customerToUpdate);
        }else {
            throw new CustomersCollectionException(CustomersCollectionException.NotFoundException(id));
        }
    }

    @Override
    public void deleteCustomer(String id) throws CustomersCollectionException {
        Optional<Customers> customersOptional = customersRepository.findById(id);
        if(!customersOptional.isPresent()){
            throw new CustomersCollectionException(CustomersCollectionException.NotFoundException(id));
        }else {
            customersRepository.deleteById(id);
        }
    }
}
