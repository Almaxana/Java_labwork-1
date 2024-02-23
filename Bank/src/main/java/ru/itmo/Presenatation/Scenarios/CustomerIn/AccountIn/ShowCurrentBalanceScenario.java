package ru.itmo.Presenatation.Scenarios.CustomerIn.AccountIn;

import lombok.AllArgsConstructor;
import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Presenatation.Scenarios.IScenario;

@AllArgsConstructor
public class ShowCurrentBalanceScenario implements IScenario {
    CurrentStateManager currentStateManager;
    @Override
    public void Run() {
        System.out.println(currentStateManager.CurrentAccount.CurrentSum + "\n");
    }

    @Override
    public String GetName() {
        return "Show my current balance";
    }
}
