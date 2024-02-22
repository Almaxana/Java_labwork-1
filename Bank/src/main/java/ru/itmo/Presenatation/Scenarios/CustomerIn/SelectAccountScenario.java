package ru.itmo.Presenatation.Scenarios.CustomerIn;

import lombok.AllArgsConstructor;
import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Model.Accounts.Account;
import ru.itmo.Core.Repositories.IAccountRepository;
import ru.itmo.Core.Services.AccountService;
import ru.itmo.Presenatation.Scenarios.IScenario;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class SelectAccountScenario implements IScenario {
    AccountService accountService;
    CurrentStateManager currentStateManager;
    @Override
    public void Run() {
        Scanner in = new Scanner(System.in);


        List<Account> accountList = accountService.GetAccountsByCustomerId(currentStateManager.CustomerInSystem.Id);
        if (accountList.isEmpty()) {
            System.out.println("\nYou have no accounts\n");
            return;
        }

        System.out.println("\nChose one of your account");
        for (Account account : accountList){
            System.out.println(account.Id + "\n");
        }

        String chosenAccount = in.nextLine();
        currentStateManager.CurrentAccount = accountList.stream().filter(account -> account.Id.toString().equals(chosenAccount)).findFirst().orElse(null);

        if (currentStateManager.CurrentAccount == null) System.out.println("\nAccount number isn't correct");
        else System.out.println("\nSUCCESS\n");
    }

    @Override
    public String GetName() {
        return "Select Account";
    }
}
