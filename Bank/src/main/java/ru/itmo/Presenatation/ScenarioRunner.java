package ru.itmo.Presenatation;
import ru.itmo.Presenatation.ScenarioProvaiders.IScenarioProvider;
import ru.itmo.Presenatation.Scenarios.IScenario;

import java.util.ArrayList;
import java.util.Scanner;


public class ScenarioRunner {
    public ArrayList<IScenarioProvider> providers;
    public ScenarioRunner(ArrayList<IScenarioProvider> _providers){
        providers = _providers;
    }

    public void Run(){

        ArrayList<IScenario> scenarios = new ArrayList<>();
        for (IScenarioProvider provider : providers){
            IScenario scenario = provider.TryGetScenario();
            if (scenario != null) scenarios.add(scenario);
        }

        System.out.println("Type the variant which you chose:\n");
        for (IScenario scenario : scenarios){
            System.out.println(scenario.GetName());
        }
        System.out.println("\n");


        Scanner in = new Scanner(System.in);
        String ClientChoice = in.nextLine();

        for (IScenario scenario : scenarios){
            if (ClientChoice.equals(scenario.GetName())){
                scenario.Run();
                break;
            }
        }

    }
}
