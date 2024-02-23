package ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn;

import lombok.AllArgsConstructor;
import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Services.AccountService;
import ru.itmo.Presenatation.ScenarioProvaiders.IScenarioProvider;
import ru.itmo.Presenatation.Scenarios.IScenario;
import ru.itmo.Presenatation.Scenarios.CustomerIn.SelectAccountScenario;

@AllArgsConstructor
public class SelectAccountScenarioProvider implements IScenarioProvider {
    CurrentStateManager currentStateManager;
    AccountService accountService;
    @Override
    public IScenario TryGetScenario() {
        if (currentStateManager.CustomerInSystem != null && currentStateManager.CurrentAccount == null) return new SelectAccountScenario(accountService, currentStateManager);
        return null;
    }
}
