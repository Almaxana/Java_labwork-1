package ru.itmo.Core.Repositories;

import ru.itmo.Core.Model.Accounts.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IAccountRepository {
    boolean AddAccount(Account account);
    List<Account> GetAccountsByCustomerId(UUID customerId);
    void AddMoney(UUID accountId, int sum);

}
