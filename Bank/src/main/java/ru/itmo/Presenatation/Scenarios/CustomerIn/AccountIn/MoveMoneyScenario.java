package ru.itmo.Presenatation.Scenarios.CustomerIn.AccountIn;

import lombok.AllArgsConstructor;
import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Services.AccountService;
import ru.itmo.Presenatation.Scenarios.IScenario;

import java.util.Scanner;
@AllArgsConstructor
public class MoveMoneyScenario implements IScenario {
    CurrentStateManager currentStateManager;
    AccountService accountService;
    @Override
    public void Run() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter target account");
        String targetAccount  = in.nextLine();

        System.out.println("\nEnter sum");
        int sum  = in.nextInt();

        accountService.MoveMoney(currentStateManager.CurrentAccount.Id, targetAccount, currentStateManager.CustomerInSystem, sum);
    }

    @Override
    public String GetName() {
        return "Move money";
    }
}
