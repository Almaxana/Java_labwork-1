package ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn;

import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Services.ICustomerService;
import ru.itmo.Presenatation.ScenarioProvaiders.IScenarioProvider;
import ru.itmo.Presenatation.Scenarios.CustomerIn.CustomerLogoutScenario;
import ru.itmo.Presenatation.Scenarios.IScenario;

public class CustomerLogoutScenarioProvider implements IScenarioProvider {
    public CurrentStateManager currentStateManager;
    public ICustomerService customerService;

    public CustomerLogoutScenarioProvider(CurrentStateManager _currentStateManager, ICustomerService _customerService){
        currentStateManager = _currentStateManager;
        customerService = _customerService;
    }

    @Override
    public IScenario TryGetScenario() {
        if (currentStateManager.CustomerInSystem != null) return new CustomerLogoutScenario(customerService);
        else return null;
    }
}
