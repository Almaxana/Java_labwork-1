package ru.itmo.Presenatation.Scenarios.CustomerIn;

import ru.itmo.Core.Services.AccountService;
import ru.itmo.Presenatation.Scenarios.IScenario;

import java.util.Scanner;
import java.util.UUID;

public class CreateAccountScenario implements IScenario {
    public AccountService accountService;
    public CreateAccountScenario(AccountService _accountService){
        accountService = _accountService;
    }
    @Override
    public void Run() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter bank name");
        String bankName = in.nextLine();

        UUID accountId = UUID.randomUUID();

        System.out.println("\nEnter start sum");
        int currentSum = in.nextInt();

        String accountType = in.nextLine();
        System.out.println("\nType kind of account: Debet  OR   Credit  OR  Deposit");
        accountType = in.nextLine();

        switch (accountType) {
            case ("Debet"):
                if (accountService.CreateDebetAccount(accountId, currentSum, bankName)) System.out.println("\nSUCCESS   Your account is" + accountId);
                else System.out.println("\nFAILURE");
                break;
            case ("Deposit"):
                if (accountService.CreateDepositAccount(accountId, currentSum, bankName)) System.out.println("\nSUCCESS   Your account is" + accountId);
                else System.out.println("\nFAILURE");
                break;
            case ("Credit"):
                if (accountService.CreateCreditAccount(accountId, currentSum, bankName)) System.out.println("\nSUCCESS   Your account is" + accountId);
                else System.out.println("\nFAILURE");
                break;
            default:
                System.out.println("\nNo such kind of account");
                break;
        }

    }

    @Override
    public String GetName() {
        return "Create Account";
    }
}
