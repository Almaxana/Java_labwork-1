package ru.itmo.Core.Repositories;

import ru.itmo.Core.Model.Accounts.Account;
import ru.itmo.Core.Model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IAccountRepository {
    boolean AddAccount(Account account);
    List<Account> GetAccountsByCustomerId(UUID customerId);
    void AddMoney(UUID accountId, int sum);
    boolean GetMoney(UUID accountId, Customer customer, int sum);
    boolean MoveMoney(UUID accountFrom, String stringIdAccountTo, Customer customer, int sum);

}
