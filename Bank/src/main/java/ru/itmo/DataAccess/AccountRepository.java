package ru.itmo.DataAccess;

import ru.itmo.Core.Model.Accounts.Account;
import ru.itmo.Core.Model.Transactions.AddMoneyTransaction;
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
}
