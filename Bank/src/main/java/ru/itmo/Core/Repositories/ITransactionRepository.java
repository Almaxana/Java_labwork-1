package ru.itmo.Core.Repositories;

import ru.itmo.Core.Model.Transactions.Transaction;

public interface ITransactionRepository {
    void AddTransaction(Transaction transaction);
}
