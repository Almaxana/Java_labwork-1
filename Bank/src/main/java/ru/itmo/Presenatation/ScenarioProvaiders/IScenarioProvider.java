package ru.itmo.Presenatation.ScenarioProvaiders;

import ru.itmo.Presenatation.Scenarios.IScenario;

public interface IScenarioProvider {
    IScenario TryGetScenario();
}
