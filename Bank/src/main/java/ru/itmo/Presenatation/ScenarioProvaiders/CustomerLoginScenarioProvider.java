package ru.itmo.Presenatation.ScenarioProvaiders;

import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Services.ICustomerService;
import ru.itmo.Presenatation.Scenarios.CustomerLoginScenario;
import ru.itmo.Presenatation.Scenarios.IScenario;

public class CustomerLoginScenarioProvider implements IScenarioProvider{
    public CurrentStateManager currentStateManager;
    public ICustomerService customerService;

    public CustomerLoginScenarioProvider(CurrentStateManager _currentStateManager, ICustomerService _customerService){
        currentStateManager = _currentStateManager;
        customerService = _customerService;
    }

    @Override
    public IScenario TryGetScenario() {
        if (currentStateManager.CustomerInSystem == null) return new CustomerLoginScenario(customerService);
        else return null;
    }
}
