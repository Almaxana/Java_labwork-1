package ru.itmo.Presenatation.Scenarios;

import ru.itmo.Core.Services.ICustomerService;

import java.util.Scanner;
import java.util.UUID;

public class CreateCustomerScenario implements IScenario {

    public CreateCustomerScenario(ICustomerService _customerService){
        customerService = _customerService;
    }
    public ICustomerService customerService;
    public String Name;
    public String SurName;
    public String Address;
    public String Passport;
    @Override
    public void Run() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter your name");
        Name = in.nextLine();

        System.out.println("\nEnter your surname");
        SurName = in.nextLine();

        System.out.println("\nEnter your address or type SKIP");
        String scan = in.nextLine();
        Address = scan.equals("SKIP") ? null : scan;

        System.out.println("\nEnter your passport or type SKIP");
        scan = in.nextLine();
        Passport = scan.equals("SKIP") ? null : scan;

        UUID id = UUID.randomUUID();

        if (customerService.CreateCustomer(Name, SurName, Address, Passport, id)) System.out.println("\nSUCCESS\n");
        else System.out.println("\nERROR    Customer isn't created\n");
    }

    @Override
    public String GetName() {
        return "Create customer";
    }
}
