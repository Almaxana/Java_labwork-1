package ru.itmo.Presenatation.Scenarios.CustomerIn.AccountIn;

import lombok.AllArgsConstructor;
import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Services.AccountService;
import ru.itmo.Presenatation.Scenarios.IScenario;

import java.util.Scanner;


@AllArgsConstructor
public class GetMoneyScenario implements IScenario {
    CurrentStateManager currentStateManager;
    AccountService accountService;
    @Override
    public void Run() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nEnter sum");
        int sum = in.nextInt();

        if (accountService.GetMoney(currentStateManager.CurrentAccount.Id, currentStateManager.CustomerInSystem, sum)) System.out.println("\nSUCCESS\n");
        else System.out.println("\nFAILURE\n");
    }

    @Override
    public String GetName() {
        return "Get money";
    }
}
