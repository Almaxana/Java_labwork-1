package ru.itmo.Presenatation.Scenarios;

import ru.itmo.Core.Services.CentralBank;
import ru.itmo.Core.Services.ICustomerService;

import java.util.Scanner;
import java.util.UUID;

public class CreateBankScenario implements IScenario{
    public CentralBank centralBank;
    public CreateBankScenario(CentralBank _centralBank){
        centralBank = _centralBank;
    }
    @Override
    public void Run() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter bank name");
        String Name = in.nextLine();

        System.out.println("\nEnter maxDoubtSum");
        int maxDoubtSum = in.nextInt();

        System.out.println("\nEnter commission");
        int commission = in.nextInt();

        System.out.println("\nEnter debet percent");
        int debetPercent = in.nextInt();

        System.out.println("\nEnter credit max negative sum");
        int creditMaxNegativeSum = in.nextInt();


        System.out.println("\nEnter deposit percent border");
        int depositPercentBorder = in.nextInt();

        UUID id = UUID.randomUUID();

        if (centralBank.CreateBank(Name, maxDoubtSum, commission, debetPercent, id, creditMaxNegativeSum, depositPercentBorder)) System.out.println("\nSUCCESS\n");
        else System.out.println("\nERROR    Customer isn't created\n");
    }

    @Override
    public String GetName() {
        return "Create bank";
    }
}

//TODO: builder for bank, account, customer