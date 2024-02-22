package ru.itmo.Presenatation.Scenarios;

import ru.itmo.Core.Services.ICustomerService;

import java.util.Scanner;

public class CustomerLoginScenario implements IScenario{
    public CustomerLoginScenario(ICustomerService _customerService){
        customerService = _customerService;
    }
    public ICustomerService customerService;

    @Override
    public void Run() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter your name");
        String name = in.nextLine();

        System.out.println("\nEnter your surname");
        String surName = in.nextLine();

        if (customerService.Login(name, surName)) System.out.println("\nSUCCESS You are authorized\n");
        else System.out.println("\nERROR    Customer isn't found\n");
    }

    @Override
    public String GetName() {
        return "Customer Login";
    }
}
