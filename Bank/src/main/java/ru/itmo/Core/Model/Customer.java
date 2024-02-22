package ru.itmo.Core.Model;

import ru.itmo.Core.Common.CurrentStateManager;

import java.util.UUID;

public class Customer {
    public Customer(String name, String surname, String address, String passport, UUID id){
        Name = name;
        Surname = surname;
        Address = address;
        Passport = passport;
        Id = id;
    }
    public String Name;
    public String Surname;
    public String Address;
    public String Passport;
    public UUID Id;
}
