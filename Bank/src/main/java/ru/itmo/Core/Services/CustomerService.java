package ru.itmo.Core.Services;

import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Model.Customer;
import ru.itmo.Core.Repositories.ICustomerRepository;

import java.util.UUID;

public class CustomerService implements ICustomerService{
    public ICustomerRepository customerRepository;
    public CurrentStateManager currentStateManager;
    public CustomerService(ICustomerRepository _customerRepository, CurrentStateManager _currentStateManager){
        customerRepository = _customerRepository;
        currentStateManager = _currentStateManager;
    }
    @Override
    public boolean CreateCustomer(String name, String surname, String address, String passport, UUID id) {
        return customerRepository.AddCustomer(new Customer(name, surname, address, passport, id));
    }

    @Override
    public boolean Login(String name, String surname) {
        Customer customer = customerRepository.GetCustomerByNameSurname(name, surname);
        if ( customer == null) return false;
        currentStateManager.CustomerInSystem = customer;
        return true;
    }

    @Override
    public void Logout() {
        currentStateManager.CustomerInSystem = null;
        currentStateManager.CurrentAccount = null;
    }
}
