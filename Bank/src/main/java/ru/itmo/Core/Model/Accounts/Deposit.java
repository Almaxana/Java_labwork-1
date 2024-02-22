package ru.itmo.Core.Model.Accounts;

import java.util.UUID;

public class Deposit extends Account{
    public int StartSum;
    public int Length;
    public Deposit(UUID id, int currentSum, int startSum, int length, UUID customerID, UUID bankId) {
        super(id, currentSum, customerID, bankId);
        StartSum = startSum;
        Length = length;
    }
}
