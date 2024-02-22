package ru.itmo.DataAccess;

import ru.itmo.Core.Model.Customer;
import ru.itmo.Core.Repositories.ICustomerRepository;

import java.util.ArrayList;

public class CustomerRepository implements ICustomerRepository {

    private ArrayList<Customer> customers;
    public CustomerRepository(){
        customers = new ArrayList<>();
    }
    @Override
    public Customer GetCustomerByNameSurname(String name, String Surname) {
        return customers.stream().filter(elem->elem.Name.equals(name) && elem.Surname.equals(Surname)).findFirst().orElse(null);
    }

    @Override
    public boolean AddCustomer(Customer customer) {
        if (GetCustomerByNameSurname(customer.Name, customer.Surname) != null) return false;
        customers.add(customer);
        return true;
    }
}
