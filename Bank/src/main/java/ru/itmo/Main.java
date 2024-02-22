package ru.itmo;

import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Repositories.IAccountRepository;
import ru.itmo.Core.Repositories.IBankRepository;
import ru.itmo.Core.Repositories.ICustomerRepository;
import ru.itmo.Core.Repositories.ITransactionRepository;
import ru.itmo.Core.Services.AccountService;
import ru.itmo.Core.Services.CentralBank;
import ru.itmo.Core.Services.CustomerService;
import ru.itmo.DataAccess.AccountRepository;
import ru.itmo.DataAccess.BanksRepository;
import ru.itmo.DataAccess.CustomerRepository;
import ru.itmo.DataAccess.TransactionRepository;
import ru.itmo.Presenatation.ScenarioProvaiders.*;
import ru.itmo.Presenatation.ScenarioRunner;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CurrentStateManager currentStateManager = new CurrentStateManager();
        ICustomerRepository customerRepository = new CustomerRepository();
        ITransactionRepository transactionRepository = new TransactionRepository();
        IAccountRepository accountRepository = new AccountRepository(transactionRepository);
        IBankRepository bankRepository = new BanksRepository();


        ArrayList<IScenarioProvider> providers = new ArrayList<>();
        providers.add(new CreateCustomerScenarioProvider(currentStateManager, new CustomerService(customerRepository, currentStateManager)));
        providers.add(new CustomerLoginScenarioProvider(currentStateManager, new CustomerService(customerRepository, currentStateManager)));
        providers.add(new CustomerLogoutScenarioProvider(currentStateManager, new CustomerService(customerRepository, currentStateManager)));
        providers.add(new CreateAccountScenarioProvider(currentStateManager, new AccountService(accountRepository, bankRepository, currentStateManager)));
        providers.add(new CreateBankScenarioProvider(new CentralBank(bankRepository), currentStateManager));
        providers.add(new SelectAccountScenarioProvider(currentStateManager, new AccountService(accountRepository, bankRepository, currentStateManager)));

        ScenarioRunner scenarioRunner = new ScenarioRunner(providers);
        while (true){
            scenarioRunner.Run();
        }

    }
}