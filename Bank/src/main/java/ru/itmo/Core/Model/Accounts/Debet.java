package ru.itmo.Core.Model.Accounts;

import java.util.UUID;

public class Debet extends Account{
    public int FixPercent;
    public Debet(UUID id, int currentSum, int fixPercent, UUID customerID, UUID bankId) {
        super(id, currentSum, customerID, bankId);
        FixPercent = fixPercent;
    }
}
