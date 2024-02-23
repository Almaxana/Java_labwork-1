package ru.itmo.DataAccess;

import ru.itmo.Core.Model.Accounts.Account;
import ru.itmo.Core.Model.Customer;
import ru.itmo.Core.Model.Transactions.AddMoneyTransaction;
import ru.itmo.Core.Model.Transactions.GetMoneyTransaction;
import ru.itmo.Core.Model.Transactions.MoveMoneyTransaction;
import ru.itmo.Core.Model.Transactions.Transaction;
import ru.itmo.Core.Repositories.IAccountRepository;
import ru.itmo.Core.Repositories.ITransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountRepository implements IAccountRepository {
    ITransactionRepository transactionRepository;
    private ArrayList<Account> accounts;
    public AccountRepository(ITransactionRepository _transactionRepository){
        transactionRepository = _transactionRepository;
        accounts = new ArrayList<>();
    }
    @Override
    public boolean AddAccount(Account account) {
        accounts.add(account);
        return true;
    }

    @Override
    public List<Account> GetAccountsByCustomerId(UUID customerId) {
        return accounts.stream().filter(account -> account.CustomerId == customerId).collect(Collectors.toList());
    }

    public void AddMoney(UUID accountId, int sum){
        Account accountToOperate = accounts.stream().filter(account -> account.Id == accountId).findFirst().get();
        AddMoneyTransaction transaction = new AddMoneyTransaction(accountToOperate, sum);
        transactionRepository.AddTransaction(transaction);
        transaction.Execute();
    }

    @Override
    public boolean GetMoney(UUID accountId, Customer customer, int sum) {
        Account accountToOperate = accounts.stream().filter(account -> account.Id == accountId).findFirst().get();
        GetMoneyTransaction transaction = new GetMoneyTransaction(accountToOperate, customer, sum);
        transactionRepository.AddTransaction(transaction);
        return transaction.Execute();
    }

    @Override
    public boolean MoveMoney(UUID accountFromId, String stringIdAccountTo, Customer customer, int sum) {
        Account accountTo = accounts.stream().filter(account -> account.Id.toString().equals(stringIdAccountTo)).findFirst().orElse(null);
        if (accountTo == null) return false;
        Account accountFrom = accounts.stream().filter(account -> account.Id == accountFromId).findFirst().get();
        MoveMoneyTransaction moveMoneyTransaction = new MoveMoneyTransaction(accountFrom, accountTo, customer, sum);
        transactionRepository.AddTransaction(moveMoneyTransaction);
        return moveMoneyTransaction.Execute();
    }
}
