package ru.itmo.Presenatation.ScenarioProvaiders;

import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Services.ICustomerService;
import ru.itmo.Presenatation.Scenarios.CreateCustomerScenario;
import ru.itmo.Presenatation.Scenarios.IScenario;

public class CreateCustomerScenarioProvider implements IScenarioProvider{
    public CurrentStateManager currentStateManager;
    public ICustomerService customerService;

    public CreateCustomerScenarioProvider(CurrentStateManager _currentStateManager, ICustomerService _customerService){
        currentStateManager = _currentStateManager;
        customerService = _customerService;
    }

    @Override
    public IScenario TryGetScenario() {
        if (currentStateManager.CustomerInSystem == null) return new CreateCustomerScenario(customerService);
        else return null;
    }
}
