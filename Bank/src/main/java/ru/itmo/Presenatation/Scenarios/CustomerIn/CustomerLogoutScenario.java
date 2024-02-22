package ru.itmo.Presenatation.Scenarios.CustomerIn;

import ru.itmo.Core.Services.ICustomerService;
import ru.itmo.Presenatation.Scenarios.IScenario;

import java.util.Scanner;

public class CustomerLogoutScenario implements IScenario {
    public CustomerLogoutScenario(ICustomerService _customerService){
        customerService = _customerService;
    }
    public ICustomerService customerService;

    @Override
    public void Run() {
        customerService.Logout();
        System.out.println("\nSUCCESS\n");
    }

    @Override
    public String GetName() {
        return "Customer Logout";
    }
}
