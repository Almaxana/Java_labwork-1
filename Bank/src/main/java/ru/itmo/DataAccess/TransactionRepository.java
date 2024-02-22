package ru.itmo.DataAccess;

import ru.itmo.Core.Model.Transactions.Transaction;
import ru.itmo.Core.Repositories.ITransactionRepository;

import java.util.ArrayList;

public class TransactionRepository implements ITransactionRepository {
    public TransactionRepository(){
        transactions = new ArrayList<>();
    }
    ArrayList<Transaction> transactions;
    @Override
    public void AddTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
