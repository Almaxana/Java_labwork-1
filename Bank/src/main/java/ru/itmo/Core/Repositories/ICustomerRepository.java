package ru.itmo.Core.Repositories;

import ru.itmo.Core.Model.Customer;

public interface ICustomerRepository {
    Customer GetCustomerByNameSurname(String name, String Surname);
    boolean AddCustomer(Customer customer);
}
