package ru.itmo.Core.Model.Accounts;

import java.util.UUID;

public class Credit extends Account{
    public int MAxNegativeSum;
    public Credit(UUID id, int currentSum, int maxNegativeSum, UUID customerID, UUID bankId) {
        super(id, currentSum, customerID, bankId);
        MAxNegativeSum = maxNegativeSum;
    }
}
