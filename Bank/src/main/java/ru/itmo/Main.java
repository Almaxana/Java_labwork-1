package ru.itmo;

import org.joda.time.DateTime;
import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Model.Accounts.Credit;
import ru.itmo.Core.Model.Accounts.Debet;
import ru.itmo.Core.Model.Accounts.Deposit;
import ru.itmo.Core.Model.Bank;
import ru.itmo.Core.Model.Customer;
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
import ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn.AccountIn.AddMoneyScenarioProvider;
import ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn.AccountIn.GetMoneyScenarioProvider;
import ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn.AccountIn.MoveMoneyScenarioProvider;
import ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn.AccountIn.ShowCurrentBalanceScenarioProvider;
import ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn.CreateAccountScenarioProvider;
import ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn.CustomerLogoutScenarioProvider;
import ru.itmo.Presenatation.ScenarioProvaiders.CustomerIn.SelectAccountScenarioProvider;
import ru.itmo.Presenatation.ScenarioRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CurrentStateManager currentStateManager = new CurrentStateManager();
        currentStateManager.CurrentData = new DateTime();
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
        providers.add(new AddMoneyScenarioProvider(currentStateManager, new AccountService(accountRepository, bankRepository, currentStateManager)));
        providers.add(new GetMoneyScenarioProvider(currentStateManager, new AccountService(accountRepository, bankRepository, currentStateManager)));
        providers.add(new MoveMoneyScenarioProvider(currentStateManager, new AccountService(accountRepository, bankRepository, currentStateManager)));
        providers.add(new ShowCurrentBalanceScenarioProvider(currentStateManager));


        Customer user = new Customer("Ks", "Al", "asdgasg", "sdgasgd", UUID.randomUUID());
        Bank bank = new Bank("Sber", UUID.randomUUID(), 1, 1, 1, 1, 1);
        Debet debet = new Debet(UUID.randomUUID(), 30, 20, user.Id, bank.Id);
        Deposit deposit = new Deposit(UUID.randomUUID(), 10, 20, 0, user.Id, bank.Id);
        Credit credit = new Credit(UUID.randomUUID(), 20, 1, user.Id, bank.Id);

        accountRepository.AddAccount(deposit);
        accountRepository.AddAccount(debet);
        accountRepository.AddAccount(credit);
        bankRepository.AddBank(bank);
        customerRepository.AddCustomer(user);

        currentStateManager.CustomerInSystem = user;
        /*currentStateManager.CurrentAccount = deposit;*/
        deposit.dateOfStart = currentStateManager.CurrentData.minusDays(10);

        ScenarioRunner scenarioRunner = new ScenarioRunner(providers);
        while (true){
            scenarioRunner.Run();
            currentStateManager.CurrentData = new DateTime();
        }

    }
}