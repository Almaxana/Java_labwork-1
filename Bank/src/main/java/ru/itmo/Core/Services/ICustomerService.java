package ru.itmo.Core.Services;

import java.util.UUID;

public interface ICustomerService {
    boolean CreateCustomer(String name, String surname, String address, String passport, UUID id);
    boolean Login(String name, String surname);
    void Logout();
}
