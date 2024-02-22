package ru.itmo.Core.Model.Accounts;

import java.util.UUID;

public abstract class Account {
    public Account(UUID id, int currentSum, UUID customerId, UUID bankId){
        Id = id;
        CurrentSum = currentSum;
        CustomerId = customerId;
        BankId = bankId;
    }
    public UUID Id;
    public int CurrentSum;
    public UUID CustomerId;
    public UUID BankId;
}
