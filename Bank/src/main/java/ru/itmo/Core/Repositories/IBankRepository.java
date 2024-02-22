package ru.itmo.Core.Repositories;

import ru.itmo.Core.Model.Bank;
import ru.itmo.Core.Model.Customer;

public interface IBankRepository {
    Bank GetBankByName(String name);
    boolean AddBank(Bank bank);
}
