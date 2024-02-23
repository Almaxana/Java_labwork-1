package ru.itmo.Core.Services;

import lombok.AllArgsConstructor;
import ru.itmo.Core.Common.CurrentStateManager;
import ru.itmo.Core.Model.Accounts.Account;
import ru.itmo.Core.Model.Accounts.Credit;
import ru.itmo.Core.Model.Accounts.Debet;
import ru.itmo.Core.Model.Accounts.Deposit;
import ru.itmo.Core.Model.Bank;
import ru.itmo.Core.Model.Customer;
import ru.itmo.Core.Repositories.IAccountRepository;
import ru.itmo.Core.Repositories.IBankRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
public class AccountService {
    public IAccountRepository accountRepository;
    public IBankRepository bankRepository;
    public CurrentStateManager currentStateManager;
    public boolean CreateDebetAccount(UUID accountId, int currentSum, String bankName){
        Bank bank = bankRepository.GetBankByName(bankName);
        if (bank == null) return false;
        return accountRepository.AddAccount(new Debet(accountId, currentSum, bank.FixedDebetPercent, currentStateManager.CustomerInSystem.Id, bank.Id));
    }
    public boolean CreateCreditAccount(UUID accountId, int currentSum, String bankName){
        Bank bank = bankRepository.GetBankByName(bankName);
        if (bank == null) return false;
        return accountRepository.AddAccount(new Credit(accountId, currentSum, bank.CreditMaxNegativeSum, currentStateManager.CustomerInSystem.Id, bank.Id));
    }

    public boolean CreateDepositAccount(UUID accountId, int currentSum, String bankName){
        Bank bank = bankRepository.GetBankByName(bankName);
        if (bank == null) return false;
        return accountRepository.AddAccount(new Deposit(accountId, currentSum, currentSum, bank.DepositLength, currentStateManager.CustomerInSystem.Id, bank.Id));
    }

    public List<Account> GetAccountsByCustomerId(UUID customerId){
        return accountRepository.GetAccountsByCustomerId(customerId);
    }

    public void AddMoney(UUID accountId, int sum){
        accountRepository.AddMoney(accountId, sum);
    }
    public boolean GetMoney(UUID accountId, Customer customer, int sum){
        return accountRepository.GetMoney(accountId, customer, sum);
    }

    public  boolean MoveMoney(UUID accountFrom, String stringIdAccountTo, Customer customer, int sum){
        return accountRepository.MoveMoney(accountFrom, stringIdAccountTo, customer, sum);
    }
}
